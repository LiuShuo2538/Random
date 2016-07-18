package two_param.email;

/**
 * Created by ${LiuShuo} on 2016/6/29.
 */
public class Email {
    public static Object getM(Object value, Object key) {

        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value == null || value.equals("null") || value.equals("")) return value;
        String str = value + "";
        str = str.replace(" ", "");
        //去掉前后空格长度小于等于1的直接返回
        if (str.trim().length() < 6) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;
        if (salt.length() < 1) {
            //没有盐值
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
                //英文
                if (p1.matcher(split[0].substring(i,i+1)).matches()){
                    nameArray[i] = arrLetter[hash1%(arrLetter.length-1)];
                }else if (p2.matcher(split[0].substring(i,i+1)).matches()){
                //数字
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
