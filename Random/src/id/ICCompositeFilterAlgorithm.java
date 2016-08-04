package id;

/**
 * Created by ${LiuShuo} on 8/2/2016.
 */
/**
 * 有效证件混合过滤算法
 * 包括15位身份证、18位身份证、军官证
 * 前六后二不脱
 * Created by zhengbing on 2016/6/21.
 */
public class ICCompositeFilterAlgorithm {

    public static Object getModelIDCard(Object value,Object key){

        if (value==null||value.equals("null")||value.equals("")) return "";
        if (value instanceof byte[] )return value;
        String str = value+"";
        if (str.contains(" ")) return value;
        int isSuangYin = 0;
        if (str.endsWith("\"")&&str.startsWith("\"")){
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        int hashSalt = 0;
        if (salt.length()<1){
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }
        int type = 0;
        String[] soldiers = {"\u5357","\u5317","\u6C88","\u5170","\u6210","\u6D4E","\u5E7F","\u53C2","\u653F","\u540E","\u88C5","\u6D77","\u7A7A","\u4E1C","\u897F","\u4E2D"};

        String[] num18 = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        int[] validate18 = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^(\u5357|\u5317|\u6C88|\u5170|\u6210|\u6D4E|\u5E7F|\u53C2|\u653F|\u540E|\u88C5|\u6D77|\u7A7A|\u4E1C|\u897F|\u4E2D)\\d{8}$");
        if (str.length()==18){
            type=18;
        }
        if (str.length()==15){
            type=15;
        }
        if (p.matcher(str).matches()){
            type=9;
        }
        if (type==0)return value;
        java.util.Random random = new java.util.Random(hashSalt);
        String newStr1="";
        String newStr2="";
        String newStr3="";
        String newStr4="";
        String subStr1="";
        String subStr2="";
        String subStr3="";
        String subStr4="";
        if (type>14){
            int hash1 = 0;
            int hash2 = 0;
            int hash3 = 0;
            int hash4 = 0;
            int dom1 = 0;
            int dom2 = 0;
            java.util.Calendar birthday = java.util.Calendar.getInstance();
            subStr1 = str.substring(0, 6);
            if (type==18){
                subStr2 = str.substring(6, 14);
                subStr3 = str.substring(14, 17);
                hash1 = Math.abs(subStr1.hashCode()+hashSalt);
                hash2 = Math.abs(subStr2.hashCode()+hashSalt);
                hash3 = Math.abs(subStr3.hashCode()+hashSalt);
                dom1 = random.nextInt(hash2);
                dom2 = random.nextInt(hash3);
                newStr1 = subStr1;
                birthday.set(java.util.Calendar.YEAR, (int)(((float)dom1/(float)hash2)*50)+ 1950);
                birthday.set(java.util.Calendar.MONTH, (int)(((float)dom1/(float)hash2) * 12));
                birthday.set(java.util.Calendar.DATE, (int)(((float)dom1/(float)hash2) * 31));
                StringBuilder builder = new StringBuilder();
                builder.append(birthday.get(java.util.Calendar.YEAR));
                long month = birthday.get(java.util.Calendar.MONTH) + 1;
                if (month < 10) {
                    builder.append("0");
                }
                builder.append(month);
                long date = birthday.get(java.util.Calendar.DATE);
                if (date < 10) {
                    builder.append("0");
                }
                builder.append(date);
                newStr2=builder.toString();
                int code =(int)(((float)dom2/(float)hash3)*100);
                if (code < 10) {
                    newStr3= "0" + code;
                } else {
                    newStr3=  "" + code;
                }
                newStr3 +=subStr3.substring(subStr3.length()-1,subStr3.length());
                int add17 = 0;
                String temp17= newStr1 + newStr2 +newStr3;
                for (int i = 0; i <temp17.length() ; i++) {
                    String s =temp17.substring(i,i+1);
                    add17 += Integer.parseInt(s) * validate18[i];
                }
                int validateCode = Math.abs(add17) % 11;
                newStr4 = num18[validateCode]+"";
            }
            if (type==15){
                subStr2 = str.substring(6, 12);
                subStr3 = str.substring(12, 15);
                hash1 = Math.abs(subStr1.hashCode()+hashSalt);
                hash2 = Math.abs(subStr2.hashCode()+hashSalt);
                hash3 = Math.abs(subStr3.hashCode()+hashSalt);
                java.util.Random random2 = new java.util.Random(hash2);
                dom1 = random2.nextInt(hash2);
                dom2 = random.nextInt(hash3);
                newStr1 = subStr1;

                birthday.set(java.util.Calendar.YEAR, (int)(((float)dom1/(float)hash2)*50)+ 1950);
                birthday.set(java.util.Calendar.MONTH, (int)(((float)dom1/(float)hash2) * 12));
                birthday.set(java.util.Calendar.DATE, (int)(((float)dom1/(float)hash2) * 31));
                StringBuilder builder = new StringBuilder();
                builder.append(birthday.get(java.util.Calendar.YEAR));
                long month = birthday.get(java.util.Calendar.MONTH) + 1;
                if (month < 10) {
                    builder.append("0");
                }
                builder.append(month);
                long date = birthday.get(java.util.Calendar.DATE);
                if (date < 10) {
                    builder.append("0");
                }
                builder.append(date);
                newStr2=builder.toString().substring(2,8);
                int code =(int)(((float)dom2/(float)hash3)*100);
                if (code < 10) {
                    newStr3= "0" + code;
                } else {
                    newStr3=  "" + code;
                }
                newStr3 +=subStr3.substring(subStr3.length()-1,subStr3.length());
            }
        }
        if (type==9){
            subStr1=str.substring(0,1);
            subStr2=str.substring(1,str.length());
            int hashSub1 = Math.abs(subStr1.hashCode() * subStr1.hashCode()+hashSalt);
            int hashSub2 = Math.abs(subStr2.hashCode()+hashSalt);
            int dom2 = random.nextInt(hashSub2);
            newStr1 = soldiers[hashSub1 % (soldiers.length-1)];
            int code =(int)(((float)dom2/(float)hashSub2)*10000);
            if (code < 10) {
                newStr2= "000" + code;
            } else if (code < 100) {
                newStr2=  "00" + code;
            } else if (code < 1000) {
                newStr2=  "0" + code;
            } else {
                newStr2=  "" + code;
            }
            int code2 =(int)(((float)dom2/(float)hashSub2)*((float)dom2/(float)hashSub2)*10000);
            if (code2 < 10) {
                newStr3= "000" + code2;
            } else if (code2 < 100) {
                newStr3=  "00" + code2;
            } else if (code2 < 1000) {
                newStr3=  "0" + code2;
            } else {
                newStr3=  "" + code2;
            }
        }
        str =newStr1+newStr2+newStr3+newStr4;
        if (isSuangYin == 1){
            str = "\"" + str +"\"";
        }
        return str;
    }
}