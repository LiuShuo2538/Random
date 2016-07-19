package temp1;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 手机脱敏算法（11位）
 * 所有位数全部脱敏
 * Created by ${LiuShuo} on 2016/7/19.
 */
public class MobilePhoneFilterAlgorithm {
    public static Object getModelMobilePhone(Object value, Object key){
        //\u5224\u65AD\u53C2\u6570\u662F\u5426\u4E3Anull\u3001"null"\u3001"" ,\u4E3Atrue\u65F6\u4E0D\u505A\u5904\u7406
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replace(" ", "");
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
        String saltok = salt.replace(" ", "");
        //\u76D0\u503Chash
        int hashSalt = 0;
        if (salt.length() < 1) {
        //\u6CA1\u6709\u76D0\u503C
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }
        String[] num1to3 = {
                "130","131","132","155","156","186","185","186","185","145","134","135","136","137","138","139","150","151","152","157","158","159","182","183","188","187","133","153","180","181","189"
        };
        String newStr2 = "";
        String newStr1 ="";
        boolean isMobilePhone = false;
        //\u9A8C\u8BC1\u662F\u5426\u4E3A\u624B\u673A
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
        //\u751F\u62104-7\u4F4D
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
        //\u751F\u62108-11\u4F4D
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
