package com.wiseweb.algorithm;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 固定电话脱敏算法（11位）
 * 脱敏后六位
 * Created by ${LiuShuo} on 2016/7/19.
 */
public class FixedTelephoneFilterAlgorithm {
    public static Object getModelFixedTele(Object value, Object key){
        //\u5224\u65AD\u53C2\u6570\u662F\u5426\u4E3Anull\u3001"null"\u3001"" ,\u4E3Atrue\u65F6\u4E0D\u505A\u5904\u7406
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"")&&str.startsWith("\"")){
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        //\u9A8C\u8BC1\u662F\u5426\u6570\u5B57
        Pattern numRegex = Pattern.compile("^([0-9]{11})$");
        if (!numRegex.matcher(str).matches()) return value;
        if (str.length() != 11) return value;
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        //\u76D0\u503Chash
        int hashSalt = 0;
        if (salt.length() < 1) {
            //\u6CA1\u6709\u76D0\u503C
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
        if (isSuangYin == 1){
            s = "\"" + s +"\"";
        }
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
