package citic.mobile_phone;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class MobilePhone {
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
        String[] num1to3 = {
                "130","131","132","155","156","186","185","186","185","145","134","135","136","137","138","139","150","151","152","157","158","159","182","183","188","187","133","153","180","181","189"
        };
        String newStr2 = "";
        String newStr1 ="";
        boolean isMobilePhone = false;
        //验证是否为手机
        String s1to3 = str.substring(0, 3);
        for(int i = 0;i<num1to3.length;i++){
            isMobilePhone = num1to3[i].contains(s1to3);
            if (isMobilePhone) break;
        }
        if (!isMobilePhone){
            return value;
        }
        String subStr1to3 = str.substring(0, 3);
        String subStr4to7 = str.substring(3,7);
        String subStr8to11 = str.substring(7,11);
        java.util.Random random = new java.util.Random(Math.abs(subStr1to3.hashCode()+hashSalt));
        newStr1 = num1to3[random.nextInt(num1to3.length)];
        int hash1 = Math.abs(subStr4to7.hashCode()+hashSalt);
        int hash2 = Math.abs(subStr8to11.hashCode()+hashSalt);
        java.util.Random random1 = new java.util.Random(hash1);
        java.util.Random random2 = new java.util.Random(hash2);
        int dom1 = random1.nextInt(hash1);
        int dom2 = random2.nextInt(hash2);

        String tempStr1="";
        String tempStr2="";
        //生成4-7位
        int code = (int) (((float)dom1/(float)hash1) * 10000);
        if (code<10){
            tempStr1= "000" + code;
        } else if (code < 100) {
            tempStr1= "00" + code;
        } else if (code < 1000) {
            tempStr1=  "0" + code;
        } else {
            tempStr1=  "" + code;
        }
        //生成8-11位
        int code2 = (int) (((float)dom2/(float)hash2)*((float)dom2/(float)hash2)* 10000);
        if (code2<10){
            tempStr2= "000" + code2;
        } else if (code2 < 100) {
            tempStr2= "00" + code2;
        } else if (code2 < 1000) {
            tempStr2=  "0" + code2;
        } else {
            tempStr2=  "" + code2;
        }
        newStr2=tempStr1+tempStr2;

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
