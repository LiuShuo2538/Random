package two_param.bank;
import java.util.*;
import java.math.*;
/**
 * 完成
 * Created by ${LiuShuo} on 2016/6/22.
 */
public class Bank {
    public static Object getM(Object value, Object key){
        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str = value+"";
        //不允许含有空格（证件含有空格，直接返回不做清洗）
        if (str.contains(" ")) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;

        if (salt.length()<1){
            //没有盐值
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }

        String newStr1="";
        String newStr2="";
        String newStr3="";
        String newStrFir="";
        String newStrEnd="";
        int tempOdd = 0;//奇数
        int tempEven = 0;//偶数
        //类型判断 0：不符合标准不进行脱敏 16：贷记卡  19：借记卡
        int type =0;

        str = value+"";
        if (str.length()==16){
            type=16;
        }
        if (str.length()==19){
            type=19;
        }
        //不符合标准不做处理
        if (type==0){
            return value;
        }

        //贷记卡
        if (type==16){
            String tempStr1="";
            newStr1 = str.substring(0, 10);
            String subStr11to15 = str.substring(10, 15);
            int hash1 = Math.abs(subStr11to15.hashCode()+hashSalt);
            java.util.Random random = new java.util.Random(hash1);
            int dom1 = random.nextInt(hash1);
            //生成5个固定数
            int code = (int) (((float)dom1/(float)hash1) * 100000);
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1=  "00" + code;
            } else if (code < 10000) {
                tempStr1=  "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr2 = tempStr1;
            newStrFir = newStr1 + newStr2;
            for (int i = 0; i < newStrFir.length(); i++) {
                //奇数
                if (i%2!=0){
                    String sOdd = newStrFir.substring(i, i + 1);
                    tempOdd+=Integer.parseInt(sOdd);
                }else{
                    //偶数
                    String sEven = newStrFir.substring(i, i + 1);
                    int i1 = Integer.parseInt(sEven)*2;
                    if (i1>9){
                        tempEven+=(i1-(i1/10))+(i1/10);
                    }else {
                        tempEven+=i1;
                    }
                }
                for (int j = 0; j < 10; j++) {
                    if ((tempOdd+tempEven+i)%10==0){
                        newStrEnd=tempOdd+tempEven+i+"";
                        break;
                    }
                }
            }
        }
        //借记卡
        if (type==19) {
            String tempStr1 = "";
            newStr1 = str.substring(0, 13);
            String subStr14to18 = str.substring(13, 18);
            int hash1 = Math.abs(subStr14to18.hashCode() + hashSalt);
            java.util.Random random = new java.util.Random(hash1);
            int dom1 = random.nextInt(hash1);
            //生成5个固定数
            int code = (int) (((float) dom1 / (float) hash1) * 100000);
            if (code < 10) {
                tempStr1 = "0000" + code;
            } else if (code < 100) {
                tempStr1 = "000" + code;
            } else if (code < 1000) {
                tempStr1 = "00" + code;
            } else if (code < 10000) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
            newStr2 = tempStr1;
            newStrFir = newStr1 + newStr2;
            for (int i = 0; i < newStrFir.length(); i++) {
                //奇数
                if (i%2!=0){
                    String sOdd = newStrFir.substring(i, i + 1);
                    tempOdd+=Integer.parseInt(sOdd);
                }else{
                //偶数
                    String sEven = newStrFir.substring(i, i + 1);
                    int i1 = Integer.parseInt(sEven)*2;
                    if (i1>9){
                        tempEven+=(i1-(i1/10))+(i1/10);
                    }else {
                        tempEven+=i1;
                    }
                }
                for (int j = 0; j < 10; j++) {
                   if ((tempOdd+tempEven+j)%10==0){
                       newStrEnd=j+"";
                       break;
                   }
                }
            }
        }
        String s = newStrFir + newStrEnd;
        if(value instanceof BigDecimal){
            return new BigDecimal(s);
        }else if(value instanceof Long){
            return Long.parseLong(s);
        }else if(value instanceof Double){
            return Double.parseDouble(s);
        }
        return s;


















    }

    public static Object getR(Object value, Object key){
        return "";
    }
}
