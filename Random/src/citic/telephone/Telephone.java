package citic.telephone;


import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 脱敏后6位号码，脱敏结果符合真实电话号生成规则且与原数据不同，如果同一原数据多次出现，脱敏生成的新数据也保持唯一。
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class Telephone {
    public static Object getM(Object value,Object key) {
        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value == null || value.equals("null") || value.equals("")) return value;
        String str = value + "";
        str = str.replace(" ", "");
        //验证是否数字
        Pattern numRegex = Pattern.compile("^([0-9]{11})$");
        if (!numRegex.matcher(str).matches()) return value;
        if (str.length() != 11) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;
        if (salt.length() < 1) {
            //没有盐值
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }
        String newStr2 = "";
        String newStr1 ="";
        String subStr1 = "";
        int hash = 0;
        if (str.substring(0,1).equals("0")){
            newStr1 = str.substring(0,str.length()-6);
            subStr1 = str.substring(str.length()-6,str.length());
            hash = Math.abs(subStr1.hashCode() + hashSalt);
            java.util.Random random1 = new java.util.Random(hash);
            int dom = random1.nextInt(hash);

            int code = (int) (((float)dom/(float)hash) * 1000);
            if (code<10){
                newStr2= "00" + code;
            } else if (code < 100) {
                newStr2= "0" + code;
            } else {
                newStr2=  "" + code;
            }
            int code2 = (int) (((float)dom/(float)hash)*((float)dom/(float)hash)* 1000);
            if (code2<10){
                newStr2 += "00" + code2;
            } else if (code2 < 100) {
                newStr2 +=  "0" + code2;
            } else {
                newStr2 +=   "" + code2;
            }
        }else return value;

        String s = newStr1+newStr2;
        if(value instanceof BigDecimal){
            return new BigDecimal(s);
        }else if(value instanceof Long){
            return Long.parseLong(s);
        }else if(value instanceof Double){
            return Double.parseDouble(s);
        }
        return s;
    }



}
