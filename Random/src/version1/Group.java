package version1;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ${LiuShuo} on 7/21/2016.
 */
public class Group {

    public static Object getModelGroupNum(Object value,Object key){

        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replace(" ", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
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


        if (!java.util.regex.Pattern.compile("[0-9A-Z]{8}-?[1-9X]").matcher(str).matches()) return value;

        int isGangFuHao= 0;
        if (str.length()==10){
            str = str.replace("-","");
            isGangFuHao = 1;
        }
        Random random = new Random(hashSalt);
        String newStr1="";
        String newStr2="";
        String newStr3="";
        String newStr4="";
        String temp1to8="";

        //\u7EC4\u7EC7\u673A\u6784\u7801\u7B2C\u4E00\u4F4D\u51FA\u82F1\u6587\u7684\u51E0\u7387\u5C0F\u4E00\u4E9B?\u597D\u50CF\u6CA1\u67090
        String[] every8 = {"1","2","3","5","6","7","8","9","1","2","3","5","6","7","8","9","A","B","C","D","1","2","3","5","6","7","8","9","E","F","G","H","I","J","1","2","3","5","6","7","8","9","K","L","M","1","2","3","5","6","7","8","9","N","O","P","Q","1","2","3","5","6","7","8","9","R","S","1","2","3","5","6","7","8","9","T","U","V","1","2","3","5","6","7","8","9","W","X","1","2","3","5","6","7","8","9","Y","Z"};

        int[] validate = {3,7,9,10,5,8,4,2};

        //\u7B2C\u4E5D\u4F4D\u9A8C\u8BC1\u7801
        String[] num9= {"1","2","3","4","5","6","7","8","9","X","0"};

        HashMap start = new HashMap();
        start.put("0",0);
        start.put("1",1);
        start.put("2",2);
        start.put("3",3);
        start.put("4",4);
        start.put("5",5);
        start.put("6",6);
        start.put("7",7);
        start.put("8",8);
        start.put("9",9);
        start.put("A",10);
        start.put("B",11);
        start.put("C",12);
        start.put("D",13);
        start.put("E",14);
        start.put("F",15);
        start.put("G",16);
        start.put("H",17);
        start.put("I",18);
        start.put("J",19);
        start.put("K",20);
        start.put("L",21);
        start.put("M",22);
        start.put("N",23);
        start.put("O",24);
        start.put("P",25);
        start.put("Q",26);
        start.put("R",27);
        start.put("S",28);
        start.put("T",29);
        start.put("U",30);
        start.put("V",31);
        start.put("W",32);
        start.put("X",33);
        start.put("Y",34);
        start.put("Z",35);

        int hash1 = Math.abs(str.substring(0, 1).hashCode()+hashSalt);
        int dom1 = random.nextInt(hash1);
        newStr1 = every8[hash1 % (every8.length - 1)];

        //\u4EA7\u751F3\u4F4D\u6570
        int code =(int)(((float)dom1/(float)hash1)*1000);
        if (code < 10) {
            newStr2= "00" + code;
        } else if (code < 100) {
            newStr2=  "0" + code;
        } else {
            newStr2=  "" + code;
        }
        //\u4EA7\u751F4\u4F4D\u6570
        int code2 =(int)(((float)dom1/(float)hash1)*((float)dom1/(float)hash1)*10000);
        if (code2 < 10) {
            newStr3= "000" + code2;
        } else if (code2 < 100) {
            newStr3=  "00" + code2;
        } else if (code2 < 1000) {
            newStr3=  "0" + code2;
        } else {
            newStr3=  "" + code2;
        }
        //\u7B2C\u4E5D\u4F4D\u9A8C\u8BC1\u7801\u7B97\u6CD5
        int add8 = Integer.parseInt(start.get(newStr1).toString());
        temp1to8=newStr1+newStr2+newStr3;
        for (int i = 1; i <temp1to8.length() ; i++) {
            String s =temp1to8.substring(i,i+1);
            add8 += Integer.parseInt(s) * validate[i];
        }
        int validateCode = 10 - Math.abs(add8) % 11;

        newStr4= num9[validateCode];

        String s = temp1to8+newStr4;
        if (isGangFuHao == 1){
            s = s.substring(0,8) + "-" + s.substring(8,9);
        }
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
