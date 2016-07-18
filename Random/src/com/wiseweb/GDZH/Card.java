package com.wiseweb.GDZH;

/**
 * Created by ${LiuShuo} on 2016/6/21.
 */
public class Card {


    /**
     * 外汇账号23位：203+9位机构代码+3位账别代码+8位顺序号。（101、112、113、114、127、138）脱最后8位
     存款账号23位：帐别码（000） 脱16-20位
     存款账号20位：3位地区代码+2位人行代码+4位交换行号+3位账别+5位顺序号+2位检验码+1位存款属性。其中顺序号由系统自动产生。脱顺序码
     贷款分户账户23位：由23位数字组成，第1-5位为预留位，第6-17位为其隶属贷款主档代码，第18-22位为该贷款主档下分户账的序号，第23为校验位。
     前5位为0；第六位至第十七位为位贷款主档号；第十八位至第二十二位为顺序号，由系统自动生成；最后一位为五级分类标志。脱顺序码
     内部分户账户28位：不脱
     贷款主挡代码12位，脱敏2-10
      * @param value
     * @return
     */
    public static Object getM(Object value){
        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str = value+"";
        String newStr = "";
        String[] test = {"101","112","113","114","127","138"};
        //类型 0 不脱   231外汇账号23位     232存款账号23位      202存款账号20位      233贷款分户账号23位     121贷款主挡代码12位
        int type = 0;
        //str的长度为23且不能是23位的空格
        if (str.length()==23){
            String sub1to3 = str.substring(0, 3);
            String sub13to15 = str.substring(12, 15);
            String sub1to5 = str.substring(0, 5);
            //判断外汇帐别true：是外汇
            boolean b=false;
            for (int i = 0; i < test.length ; i++) {
                b = sub13to15.equals(test[i]);
                if (b){
                    break;
                }
            }

            if (sub1to3.equals("203")&&b){
                //231外汇账号23位
                type=231;
                System.out.println(type+"--外汇");
            }else if (sub1to3.equals("203")&&sub13to15.equals("000")){
                //232存款账号23位
                type=232;
                System.out.println(type+"--存23");
            }else if (sub1to5.equals("00000")){
                //233贷款分户账号23位
                type=233;
                System.out.println(type+"--贷23");
            }else {
                //符合23位但不是账户类型，直接返回原值
                System.out.println(type+"--错23");
                return value;
            }
        } else if (str.length()==20){
            String sub10to12 = str.substring(9, 12);
            if (sub10to12.equals("000")){
                //202存款账号20位
                type=202;
                System.out.println(type+"--20");
            }else {
                //符合20位但不是账户类型，直接返回原值
                System.out.println(type+"--错20");
                return value;
            }

        } else if (str.length()==12){
                type=121;
                System.out.println(type+"--12");
        }else {
            //不符合类型，直接返回原值
            System.out.println(type+"--大错");
            return value;
        }
        //外汇脱后8位
        if (type==231){
            int hash1 = Math.abs(str.substring(15,23).hashCode());
            java.util.Random random1 = new java.util.Random(hash1);
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            String tempStr2="";
            //生成4位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 10000));
            if (code<10){
                tempStr1= "000" + code;
            } else if (code < 100) {
                tempStr1= "00" + code;
            } else if (code < 1000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            //生成4位
            int code2 =  Math.abs((int) (((float)dom1/(float)hash1)*((float)dom1/(float)hash1)* 10000));
            if (code2<10){
                tempStr2= "000" + code2;
            } else if (code2 < 100) {
                tempStr2= "00" + code2;
            } else if (code2 < 1000) {
                tempStr2=  "0" + code2;
            } else {
                tempStr2=  "" + code2;
            }
            newStr=str.substring(0,15)+tempStr1+tempStr2;
            System.out.println(newStr);
        }
        //存款账号23位
        if (type==232){
            int hash1 = Math.abs(str.substring(15,20).hashCode());
            java.util.Random random1 = new java.util.Random(hash1);
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";

            //生成5位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 100000));
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1= "00" + code;
            } else if (code < 10000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr=str.substring(0,15)+tempStr1+str.substring(20,23);
            System.out.println(newStr);
        }
        //存款账号20位
        if (type==202){
            int hash1 = Math.abs(str.substring(12,17).hashCode());
            java.util.Random random1 = new java.util.Random(hash1);
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            //生成5位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 100000));
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1= "00" + code;
            } else if (code < 10000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr=str.substring(0,12)+tempStr1+str.substring(17,20);
            System.out.println(newStr);
        }
        //贷款分户账号23位
        if (type==233){
            int hash1 = Math.abs(str.substring(17,22).hashCode());
            java.util.Random random1 = new java.util.Random(hash1);
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            //生成5位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 100000));
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1= "00" + code;
            } else if (code < 10000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr=str.substring(0,17)+tempStr1+str.substring(22,23);
            System.out.println(newStr);
        }
        if (type==121){
            int hash1 = Math.abs(str.substring(1,10).hashCode());
            java.util.Random random1 = new java.util.Random(hash1);
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            String tempStr2="";
            //生成4位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 10000));
            if (code<10){
                tempStr1= "000" + code;
            } else if (code < 100) {
                tempStr1= "00" + code;
            } else if (code < 1000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            //生成5位
            int code2 =  Math.abs((int) (((float)dom1/(float)hash1)*((float)dom1/(float)hash1)* 100000));
            if (code2<10){
                tempStr2= "0000" + code2;
            } else if (code2 < 100) {
                tempStr2= "000" + code2;
            } else if (code2 < 1000) {
                tempStr2= "00" + code2;
            } else if (code2 < 10000) {
                tempStr2=  "0" + code2;
            } else {
                tempStr2=  "" + code2;
            }
            newStr=str.substring(0,1)+tempStr1+tempStr2+str.substring(10,12);
            System.out.println(newStr);
        }

        if (type==0)return value;

        return newStr;
    }






    public static Object getR(Object value){

        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str = value+"";
        String newStr = "";
        String[] test = {"101","112","113","114","127","138"};
        //类型 0 不脱   231外汇账号23位     232存款账号23位      202存款账号20位      233贷款分户账号23位     121贷款主挡代码12位
        int type = 0;
        //str的长度为23且不能是23位的空格
        if (str.length()==23){
            String sub1to3 = str.substring(0, 3);
            String sub13to15 = str.substring(12, 15);
            String sub1to5 = str.substring(0, 5);
            //判断外汇帐别true：是外汇
            boolean b=false;
            for (int i = 0; i < test.length ; i++) {
                b = sub13to15.equals(test[i]);
                if (b){
                    break;
                }
            }

            if (sub1to3.equals("203")&&b){
                //231外汇账号23位
                type=231;
                System.out.println(type+"--外汇");
            }else if (sub1to3.equals("203")&&sub13to15.equals("000")){
                //232存款账号23位
                type=232;
                System.out.println(type+"--存23");
            }else if (sub1to5.equals("00000")){
                //233贷款分户账号23位
                type=233;
                System.out.println(type+"--贷23");
            }else {
                //符合23位但不是账户类型，直接返回原值
                System.out.println(type+"--错23");
                return value;
            }
        } else if (str.length()==20){
            String sub10to12 = str.substring(9, 12);
            if (sub10to12.equals("000")){
                //202存款账号20位
                type=202;
                System.out.println(type+"--20");
            }else {
                //符合20位但不是账户类型，直接返回原值
                System.out.println(type+"--错20");
                return value;
            }

        } else if (str.length()==12){
            type=121;
            System.out.println(type+"--12");
        }else {
            //不符合类型，直接返回原值
            System.out.println(type+"--大错");
            return value;
        }
        //外汇脱后8位
        if (type==231){
            int hash1 = Math.abs(str.substring(15,23).hashCode());
            java.util.Random random1 = new java.util.Random();
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            String tempStr2="";
            //生成4位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 10000));
            if (code<10){
                tempStr1= "000" + code;
            } else if (code < 100) {
                tempStr1= "00" + code;
            } else if (code < 1000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            //生成4位
            int code2 =  Math.abs((int) (((float)dom1/(float)hash1)*((float)dom1/(float)hash1)* 10000));
            if (code2<10){
                tempStr2= "000" + code2;
            } else if (code2 < 100) {
                tempStr2= "00" + code2;
            } else if (code2 < 1000) {
                tempStr2=  "0" + code2;
            } else {
                tempStr2=  "" + code2;
            }
            newStr=str.substring(0,15)+tempStr1+tempStr2;
            System.out.println(newStr);
        }
        //存款账号23位
        if (type==232){
            int hash1 = Math.abs(str.substring(15,20).hashCode());
            java.util.Random random1 = new java.util.Random();
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";

            //生成5位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 100000));
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1= "00" + code;
            } else if (code < 10000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr=str.substring(0,15)+tempStr1+str.substring(20,23);
            System.out.println(newStr);
        }
        //存款账号20位
        if (type==202){
            int hash1 = Math.abs(str.substring(12,17).hashCode());
            java.util.Random random1 = new java.util.Random();
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            //生成5位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 100000));
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1= "00" + code;
            } else if (code < 10000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr=str.substring(0,12)+tempStr1+str.substring(17,20);
            System.out.println(newStr);
        }
        //贷款分户账号23位
        if (type==233){
            int hash1 = Math.abs(str.substring(17,22).hashCode());
            java.util.Random random1 = new java.util.Random();
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            //生成5位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 100000));
            if (code<10){
                tempStr1= "0000" + code;
            } else if (code < 100) {
                tempStr1= "000" + code;
            } else if (code < 1000) {
                tempStr1= "00" + code;
            } else if (code < 10000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr=str.substring(0,17)+tempStr1+str.substring(22,23);
            System.out.println(newStr);
        }
        if (type==121){
            int hash1 = Math.abs(str.substring(1,10).hashCode());
            java.util.Random random1 = new java.util.Random();
            int dom1 = random1.nextInt(hash1);
            String tempStr1="";
            String tempStr2="";
            //生成4位
            int code =  Math.abs((int) (((float)dom1/(float)hash1) * 10000));
            if (code<10){
                tempStr1= "000" + code;
            } else if (code < 100) {
                tempStr1= "00" + code;
            } else if (code < 1000) {
                tempStr1= "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            //生成5位
            int code2 =  Math.abs((int) (((float)dom1/(float)hash1)*((float)dom1/(float)hash1)* 100000));
            if (code2<10){
                tempStr2= "0000" + code2;
            } else if (code2 < 100) {
                tempStr2= "000" + code2;
            } else if (code2 < 1000) {
                tempStr2= "00" + code2;
            } else if (code2 < 10000) {
                tempStr2=  "0" + code2;
            } else {
                tempStr2=  "" + code2;
            }
            newStr=str.substring(0,1)+tempStr1+tempStr2+str.substring(10,12);
            System.out.println(newStr);
        }

        if (type==0)return value;

        return newStr;
    }

}
