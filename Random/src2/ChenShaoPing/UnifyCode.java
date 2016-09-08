package ChenShaoPing;

import java.util.HashMap;

/**
 * Created by ${LiuShuo} on 2016/9/8.
 */
public class UnifyCode {
    public static Object getUC(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        int hashSalt = 12345678;
        if (salt == null || salt.equals("null") || salt.equals("")) {
        } else {
            hashSalt = Math.abs(Integer.parseInt(((saltok + "abc").hashCode() + "").substring(0, 4)));
        }
        if (str.length() != 18) return value;
        int[] validate = {3, 7, 9, 10, 5, 8, 4, 2};
        //\u7B2C\u4E5D\u4F4D\u9A8C\u8BC1\u7801
        String[] num9 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "X", "0"};

        int[] validate18 = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 23, 8, 24, 10, 30, 28};
        HashMap start = new HashMap();
        start.put("0", 0);
        start.put("1", 1);
        start.put("2", 2);
        start.put("3", 3);
        start.put("4", 4);
        start.put("5", 5);
        start.put("6", 6);
        start.put("7", 7);
        start.put("8", 8);
        start.put("9", 9);
        start.put("A", 10);
        start.put("B", 11);
        start.put("C", 12);
        start.put("D", 13);
        start.put("E", 14);
        start.put("F", 15);
        start.put("G", 16);
        start.put("H", 17);
        start.put("J", 18);
        start.put("K", 19);
        start.put("L", 22);
        start.put("M", 21);
        start.put("N", 22);
        start.put("P", 23);
        start.put("Q", 24);
        start.put("R", 25);
        start.put("T", 26);
        start.put("U", 27);
        start.put("W", 28);
        start.put("X", 29);
        start.put("Y", 30);
        try {
            String str1 = str.substring(0, 8);
            String strGroup = str.substring(8, 16);
            String newStr4 = "";
            String temp1to8 = "";
            if (!java.util.regex.Pattern.compile("[0-9]{8}").matcher(strGroup).matches()) return value;
            int i8 = Integer.parseInt(strGroup) + hashSalt;
            if (i8 < 10) {
                temp1to8 = "0000000" + i8;
            } else if (i8 < 100) {
                temp1to8 = "000000" + i8;
            } else if (i8 < 1000) {
                temp1to8 = "00000" + i8;
            } else if (i8 < 10000) {
                temp1to8 = "0000" + i8;
            } else if (i8 < 100000) {
                temp1to8 = "000" + i8;
            } else if (i8 < 1000000) {
                temp1to8 = "00" + i8;
            } else if (i8 < 10000000) {
                temp1to8 = "0" + i8;
            } else if (i8 > 99999999) {
                temp1to8 = (i8 + "").substring(1, 9);
            } else {
                temp1to8 = "" + i8;
            }

            int add8 = Integer.parseInt(temp1to8.substring(0, 1));
            for (int i = 1; i < temp1to8.length(); i++) {
                String s = temp1to8.substring(i, i + 1);
                add8 += Integer.parseInt(s) * validate[i];
            }
            int validateCode = 10 - Math.abs(add8) % 11;

            newStr4 = num9[validateCode];
            String str2 = temp1to8 + newStr4;
            String s = str1 + str2;


            int add17 = Integer.parseInt(temp1to8.substring(0, 1));
            for (int i = 1; i < s.length(); i++) {
                String sTemp = s.substring(i, i + 1);
                Integer s1 = (Integer) start.get(sTemp);
                add17 += s1 * validate18[i];
            }
            int validateCode18 = 31 - Math.abs(add17) % 31;

            s = str1 + str2 + validateCode18%10;
            System.out.println(str1.length()+str2.length());
            if (isSuangYin == 1) {
                s = "\"" + s + "\"";
            }
            return s;
        } catch (Exception e) {
            return value;
        }

    }
}
