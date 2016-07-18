package com.wiseweb.common.util;

/**
 * Created by ${LiuShuo} on 2016/6/17.
 */
public class Bank2 {

    public static Object getModelBankCardID(Object value){

        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str="";
        String newStr1="";
        String newStr2="";
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
            String subStr11to16 = str.substring(10, 16);
            int hash1 = Math.abs(subStr11to16.hashCode());
            java.util.Random random = new java.util.Random(hash1);
            int dom1 = random.nextInt(hash1);
            //生成6个固定数
            int code = (int) (((float)dom1/(float)hash1) * 1000000);
            if (code<10){
                tempStr1= "00000" + code;
            } else if (code < 100) {
                tempStr1= "0000" + code;
            } else if (code < 1000) {
                tempStr1=  "000" + code;
            } else if (code < 10000) {
                tempStr1=  "00" + code;
            } else if (code < 100000) {
                tempStr1=  "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr2 = tempStr1;
        }
        //借记卡
        if (type==19){
            String tempStr1="";
            String tempStr2="";
            newStr1 = str.substring(0, 9);
            String subStr10to19 = str.substring(9, 19);
            int hash1 = Math.abs(subStr10to19.hashCode());
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
            //生成5个固定数
            int code1 = (int) (((float)dom1/(float)hash1)*((float)dom1/(float)hash1) * 100000);
            if (code<10){
                tempStr2= "0000" + code1;
            } else if (code1 < 100) {
                tempStr2= "000" + code1;
            } else if (code1 < 1000) {
                tempStr2=  "00" + code1;
            } else if (code1 < 10000) {
                tempStr2=  "0" + code1;
            } else {
                tempStr2=  "" + code1;
            }
            newStr2 = tempStr1+tempStr2;
        }
        return newStr1+newStr2;
    }


    public static Object getRandomBankCardID(Object value){

//判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str="";
        String newStr1="";
        String newStr2="";
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
            String subStr11to16 = str.substring(10, 16);
            int hash1 = Math.abs(subStr11to16.hashCode());
            java.util.Random random = new java.util.Random();
            int dom1 = random.nextInt(hash1);
            //生成6个固定数
            int code = (int) (((float)dom1/(float)hash1) * 1000000);
            if (code<10){
                tempStr1= "00000" + code;
            } else if (code < 100) {
                tempStr1= "0000" + code;
            } else if (code < 1000) {
                tempStr1=  "000" + code;
            } else if (code < 10000) {
                tempStr1=  "00" + code;
            } else if (code < 100000) {
                tempStr1=  "0" + code;
            } else {
                tempStr1=  "" + code;
            }
            newStr2 = tempStr1;
        }
        //借记卡
        if (type==19){
            String tempStr1="";
            String tempStr2="";
            newStr1 = str.substring(0, 9);
            String subStr10to19 = str.substring(9, 19);
            int hash1 = Math.abs(subStr10to19.hashCode());
            java.util.Random random = new java.util.Random();
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
            //生成5个数
            int code1 = (int) (((float)dom1/(float)hash1)*((float)dom1/(float)hash1) * 100000);
            if (code<10){
                tempStr2= "0000" + code1;
            } else if (code1 < 100) {
                tempStr2= "000" + code1;
            } else if (code1 < 1000) {
                tempStr2=  "00" + code1;
            } else if (code1 < 10000) {
                tempStr2=  "0" + code1;
            } else {
                tempStr2=  "" + code1;
            }
            newStr2 = tempStr1+tempStr2;
        }
        return newStr1+newStr2;







    }




















}
