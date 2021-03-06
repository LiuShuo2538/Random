package huanghe.telephone;

import java.math.BigDecimal;

/**
 * Created by ${LiuShuo} on 2016/6/29.
 */
public class Telephone {

    /**
     * 生成固定电话号码
     * 座机号码
     * 国内：一线城市：3位数区号+8位数座机电话号码=11位
     * 国内：普通城市、4位数区号+7位数座机电话号码=11位
     *
     * @param value
     * @return
     */
    public static Object getM(Object value,Object key){
        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return "";
        String str = value+"";
        str=str.replace(" ", "");
        if (str.length() !=11)return value;
        //去掉前后空格长度小于等于1的直接返回
        if (str.trim().length()<2) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;

        if (salt.length()<1){
            //没有盐值
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }


        //电话号码判断 0：不符合本判断标准不做操作   11:手机  113：一线城市座机  114：普通城市座机
        int type = 0;
        String newStr2 = "";
        String newStr1 ="";
        String[] num1to3 = {
                "130","131","132","155","156","186","185","186","185","145","134","135","136","137","138","139","150","151","152","157","158","159","182","183","188","187","133","153","180","181","189"
        };
        //一线城市前3位
        String[] num1Line ={"010","022","021","023"};
        //普通城市前4位
        String[] num2Line ={"0311","0310","0319","0312","0313","0314","0315","0335","0317","0316","0318","0591","0592","0598","0594","0595","0596","0599","0593","0597","0791","0798","0790","0792","0701","0793","0795","0794","0796","0797","0531","0532","0533","0536","0535","0631","0537","0633","0534","0530","0351","0352","0353","0355","0349","0354","0358","0357","0359","0471","0472","0476","0479","0470","0475","0477","0482","0371","0378","0379","0373","0393","0370","0377","0394","0396","0411","0412","0413","0414","0415","0416","0417","0418","0419","0410","0714","0710","0719","0717","0714","0712","0713","0718","0716","0431","0423","0434","0437","0435","0439","0436","0433","0440","0731","0733","0732","0734","0730","0736","0735","0737","0746","0745","0744","0451","0452","0459","0458","0453","0454","0455","0457","0456","0755","0756","0754","0751","0752","0769","0760","0757","0759","0516","0518","0517","0527","0515","0514","0513","0511","0519","0510","0512","0520","0771","0772","0773","0774","0779","0777","0898","0899","0890","0812","0838","0816","0813","0832","0833","0830","0831","0571","0574","0573","0572","0575","0579","0570","0580","0577","0576","0851","0852","0853","0858","0551","0554","0552","0555","0556","0559","0550","0557","0565","0563","0871","0870","0874","0877","0879","0888","0873","0878","0919","0917","0913","0914","0891","0892","8018","8059","0897","0931","0935","0938","0933","0937","0937","0971","0972","0979","0975","0951","0952","0953","0954","0991","0990","0995","0998","0908","0996"
        };
        str =  value+"";

        if (str.length()==11) {
            //验证是否为手机
            String s1to3 = str.substring(0, 3);
            for(int i = 0;i<num1to3.length;i++){
                boolean isMobilePhone = num1to3[i].contains(s1to3);
                if (isMobilePhone) {
                    type = 11;
                    break;
                }
            }
            //验证是否为一线城市

            for(int i = 0;i<num1Line.length;i++){
                boolean is1LinePhone = num1Line[i].contains(s1to3);
                if (is1LinePhone) {
                    type = 113;
                    break;
                }
            }
            //验证是否为普通城市
            String s1to4 = str.substring(0, 4);
            for(int i = 0;i<num2Line.length;i++){
                boolean is2LinePhone = num2Line[i].contains(s1to4);
                if (is2LinePhone) {
                    type = 114;
                    break;
                }
            }
        }

        if (type==0){
            return value;
        }
        if (type==11) {
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
        }
        if (type==113){

            String subStr1to7 = str.substring(0, 7);
            String subStr5to7 = str.substring(4,7);
            String subStr8to11 = str.substring(7,11);
            java.util.Random random = new java.util.Random(Math.abs(subStr1to7.hashCode()+hashSalt));
            newStr1 = num1Line[random.nextInt(num1Line.length)];
            int hash1 = Math.abs(subStr5to7.hashCode()+hashSalt);
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

        }
        if(type==114){
            String subStr1to7 = str.substring(0, 7);
            String subStr4to7 = str.substring(3,7);
            String subStr8to11 = str.substring(7,11);
            java.util.Random random = new java.util.Random(Math.abs(subStr1to7.hashCode()+hashSalt));
            newStr1 = num2Line[random.nextInt(num2Line.length)];
            int hash1 = Math.abs(subStr4to7.hashCode()+hashSalt);
            int hash2 = Math.abs(subStr8to11.hashCode()+hashSalt);
            java.util.Random random1 = new java.util.Random(hash1);
            java.util.Random random2 = new java.util.Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            String tempStr1="";
            String tempStr2="";
            //生成5-7位
            int code = (int) (((float)dom1/(float)hash1) * 1000);
            if (code<10){
                tempStr1= "00" + code;
            } else if (code < 100) {
                tempStr1= "0" + code;
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
        }
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
