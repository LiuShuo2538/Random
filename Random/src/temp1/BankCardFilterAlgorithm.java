package temp1;

import java.math.BigDecimal;

/**
 * 银行卡号过滤算法（16、19位）
 * 16位贷记卡前10位不变，清洗后6位（最后一位通过计算得出）
 * 19位借记卡清洗后6位（最后一位通过计算得出）（前6位卡bin + 8 + 2位卡类型 + 4位机构号 + 5位顺序号 + 1位校验码）
 * Created by zhengbing on 2016/6/21.
 */
public class BankCardFilterAlgorithm {

    public static Object getModelBCard(Object value, Object key){
        //\u5224\u65AD\u53C2\u6570\u662F\u5426\u4E3Anull\u3001"null"\u3001"" ,\u4E3Atrue\u65F6\u4E0D\u505A\u5904\u7406
        if (value==null||value.equals("null")||value.equals("")) return "";
        String str = value+"";
        //\u4E0D\u5141\u8BB8\u542B\u6709\u7A7A\u683C\uFF08\u8BC1\u4EF6\u542B\u6709\u7A7A\u683C\uFF0C\u76F4\u63A5\u8FD4\u56DE\u4E0D\u505A\u6E05\u6D17\uFF09
        if (str.contains(" ")) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //\u76D0\u503Chash
        int hashSalt = 0;

        if (salt.length()<1){
            //\u6CA1\u6709\u76D0\u503C
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }
        String newStr1="";
        String newStr2="";
        String newStr3="";
        String newStrFir="";
        String newStrEnd="";
        int tempOdd = 0;//\u5947\u6570
        int tempEven = 0;//\u5076\u6570
        //\u7C7B\u578B\u5224\u65AD 0\uFF1A\u4E0D\u7B26\u5408\u6807\u51C6\u4E0D\u8FDB\u884C\u8131\u654F 16\uFF1A\u8D37\u8BB0\u5361  19\uFF1A\u501F\u8BB0\u5361
        int type =0;

        str = value+"";
        if (str.length()==16){
            type=16;
        }
        if (str.length()==19){
            type=19;
        }
        //\u4E0D\u7B26\u5408\u6807\u51C6\u4E0D\u505A\u5904\u7406
        if (type==0){
            return value;
        }
        //\u8D37\u8BB0\u5361
        if (type==16){
            String tempStr1="";
            newStr1 = str.substring(0, 10);
            String subStr11to15 = str.substring(10, 15);
            int hash1 = Math.abs(subStr11to15.hashCode()+hashSalt);
            java.util.Random random = new java.util.Random(hash1);
            int dom1 = random.nextInt(hash1);
            //\u751F\u62105\u4E2A\u56FA\u5B9A\u6570
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
                //\u5947\u6570
                if (i%2!=0){
                    String sOdd = newStrFir.substring(i, i + 1);
                    tempOdd+=Integer.parseInt(sOdd);
                }else{
                    //\u5076\u6570
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
        //\u501F\u8BB0\u5361
        if (type==19) {
            String tempStr1 = "";
            newStr1 = str.substring(0, 13);
            String subStr14to18 = str.substring(13, 18);
            int hash1 = Math.abs(subStr14to18.hashCode() + hashSalt);
            java.util.Random random = new java.util.Random(hash1);
            int dom1 = random.nextInt(hash1);
            //\u751F\u62105\u4E2A\u56FA\u5B9A\u6570
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
                //\u5947\u6570
                if (i%2!=0){
                    String sOdd = newStrFir.substring(i, i + 1);
                    tempOdd+=Integer.parseInt(sOdd);
                }else{
                    //\u5076\u6570
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



}
