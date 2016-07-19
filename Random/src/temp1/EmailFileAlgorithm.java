package temp1;

/**
 * 电子邮箱过滤算法
 * 邮箱最短长度6
 * “@”后缀不做清洗
 * Created by ${LiuShuo} on 2016/7/15.
 */
public class EmailFileAlgorithm {

    public static Object getModelEmail(Object value , Object key){

        //\u5224\u65AD\u53C2\u6570\u662F\u5426\u4E3Anull\u3001"null"\u3001"" ,\u4E3Atrue\u65F6\u4E0D\u505A\u5904\u7406
        if (value == null || value.equals("null") || value.equals("")) return "";
        if (value instanceof byte[] )return value;
        String str = value + "";
        str = str.replace(" ", "");
        //\u53BB\u6389\u524D\u540E\u7A7A\u683C\u957F\u5EA6\u5C0F\u4E8E\u7B49\u4E8E1\u7684\u76F4\u63A5\u8FD4\u56DE
        if (str.trim().length() < 6) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //\u76D0\u503Chash
        int hashSalt = 0;
        if (salt.length() < 1) {
        //\u6CA1\u6709\u76D0\u503C
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }
        String[] arrLetter = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] arrNum = {"1","2","3","4","5","6","7","8","9","0"};
        String newStr="";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
        java.util.regex.Pattern p1 = java.util.regex.Pattern.compile("^([a-zA-Z])$");
        java.util.regex.Pattern p2 = java.util.regex.Pattern.compile("^([0-9])$");
        boolean b = p.matcher(str).matches();
        if (b){
            if (str.startsWith("@")||str.startsWith(" "))return value;
            String[] split = str.split("@");
            String[] nameArray =new String [split[0].length()];
            if (split[0].length()<5)return value;
            for (int i = 0; i < split[0].length(); i++) {
                int hash1 = Math.abs(split[0].substring(i, i + 1).hashCode() + hashSalt);
                //\u82F1\u6587
                if (p1.matcher(split[0].substring(i,i+1)).matches()){
                    nameArray[i] = arrLetter[hash1%(arrLetter.length-1)];
                }else if (p2.matcher(split[0].substring(i,i+1)).matches()){
                    //\u6570\u5B57
                    nameArray[i] = arrNum[hash1%(arrNum.length-1)];
                }else{
                    nameArray[i] = split[0].substring(i,i+1);
                }
                newStr+=nameArray[i];
            }
            newStr+="@"+split[1];
        }else return value;
        return newStr;


    }
}
