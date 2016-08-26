package com.wiseweb.algorithm;

/**
 * 有效证件混合过滤算法
 * 包括15位身份证、18位身份证、军官证
 * 身份证 行政区代码（前六位）、性别（18位倒数第二位；15位最后一位）、日 不变
 * 2016/08/04 解决唯一约束问题
 * Created by zhengbing on 2016/6/21.
 */
public class ICCompositeFilterAlgorithm {

    public static Object getModelIDCard(Object value, Object key) {
        try {
            if (value == null || value.equals("null") || value.equals("")) return "";
            if (value instanceof byte[]) return value;
            String str = value + "";
            if (str.contains(" ")) return value;
            str = str.replaceAll("\\u3000", "");
            int isSuangYin = 0;
            if (str.endsWith("\"") && str.startsWith("\"")) {
                str = str.substring(1, str.length() - 1);
                isSuangYin = 1;
            }
            String salt = key + "";
            String saltok = salt.replaceAll("\\s*", "");
            int hashSalt = 25;
            if (salt == null || salt.equals("null") || salt.equals("")) {
            } else {
                hashSalt = Math.abs(Integer.parseInt((saltok.hashCode() + "").substring(0, 2))) % 50;
            }
            int type = 0;
            String[] soldiers = {"\u5357", "\u5317", "\u6C88", "\u5170", "\u6210", "\u6D4E", "\u5E7F", "\u53C2", "\u653F", "\u540E", "\u88C5", "\u6D77", "\u7A7A", "\u4E1C", "\u897F", "\u4E2D"};
            String[] num18 = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            int[] validate18 = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            java.util.regex.Pattern p = java.util.regex.Pattern.compile("^(\u5357|\u5317|\u6C88|\u5170|\u6210|\u6D4E|\u5E7F|\u53C2|\u653F|\u540E|\u88C5|\u6D77|\u7A7A|\u4E1C|\u897F|\u4E2D)\\d{8}$");
            java.util.regex.Pattern id18 = java.util.regex.Pattern.compile("^[1-8][0-9]{5}(19|20)[0-9]{2}[0-1][0-9][0-3][0-9](([0-9]{3}[Xx])|[0-9]{4})\\s*$");
            java.util.regex.Pattern id15 = java.util.regex.Pattern.compile("^[0-9]{15}\\s*$");
            if (id18.matcher(str).matches()) {
                type = 18;
            }
            if (id15.matcher(str).matches()) {
                type = 15;
            }
            if (p.matcher(str).matches()) {
                type = 9;
            }
            if (type == 0) return value;
            java.util.Random random = new java.util.Random(hashSalt);
            String newStr1 = "";
            String newStr2 = "";
            String newStr3 = "";
            String newStr4 = "";
            String subStr1 = "";
            String subStr2 = "";
            String subStr3 = "";
            if (type > 14) {

                newStr1 = str.substring(0, 6);
                if (type == 18) {
                    subStr2 = str.substring(6, 14);
                    int nian = Integer.parseInt(subStr2.substring(0, 4));
                    int yue = Integer.parseInt(subStr2.substring(4, 6));
                    int ri = Integer.parseInt(subStr2.substring(6, 8));

                    int newNian = nian + hashSalt / 10;
                    String yueStr = "";
                    String riStr = "";

                    int newYue = yue + hashSalt;
                    if (newYue > 12) {
                        newYue = newYue % 12;
                    }
                    int newRi = ri;
                    if (newRi > 30) {
                        newRi = newRi % 30;
                    }
                    if (newYue < 10) {
                        yueStr = "0" + newYue;
                    } else {
                        yueStr = newYue + "";
                    }
                    if (newRi < 10) {
                        riStr = "0" + newRi;
                    } else {
                        riStr = newRi + "";
                    }
                    newStr2 = newNian + "" + yueStr + riStr;

                    subStr3 = str.substring(14, 17);
                    String substring = subStr3.substring(0, 2);
                    int i1 = Integer.parseInt(substring) + hashSalt;

                    if (i1 < 10) {
                        newStr3 = "0" + i1 + subStr3.substring(subStr3.length() - 1, subStr3.length());
                    } else if (i1 < 100) {
                        newStr3 = i1 + "" + subStr3.substring(subStr3.length() - 1, subStr3.length());
                    } else {
                        newStr3 = (i1 + "").substring(1, 3) + subStr3.substring(subStr3.length() - 1, subStr3.length());
                    }

                    int add17 = 0;
                    String temp17 = newStr1 + newStr2 + newStr3;
                    for (int i = 0; i < temp17.length(); i++) {
                        String s = temp17.substring(i, i + 1);
                        add17 += Integer.parseInt(s) * validate18[i];
                    }
                    int validateCode = Math.abs(add17) % 11;
                    newStr4 = num18[validateCode] + "";
                }
                if (type == 15) {
                    subStr2 = str.substring(6, 12);
                    subStr3 = str.substring(12, 15);

                    int nian = Integer.parseInt(subStr2.substring(0, 2));
                    int yue = Integer.parseInt(subStr2.substring(2, 4));
                    int ri = Integer.parseInt(subStr2.substring(4, 6));

                    int newNian = nian - 10 + hashSalt / 10;

                    String yueStr = "";
                    String riStr = "";

                    int newYue = yue + hashSalt;
                    if (newYue > 12) {
                        newYue = newYue % 12;
                    }
                    int newRi = ri;

                    if (newYue < 10) {
                        yueStr = "0" + newYue;
                    } else {
                        yueStr = newYue + "";
                    }
                    if (newRi < 10) {
                        riStr = "0" + newRi;
                    } else {
                        riStr = newRi + "";
                    }
                    newStr2 = newNian + "" + yueStr + riStr;

                    String substring = subStr3.substring(0, 2);
                    int i1 = Integer.parseInt(substring) + hashSalt;
                    if (i1 < 10) {
                        newStr3 = "0" + i1 + subStr3.substring(subStr3.length() - 1, subStr3.length());
                    } else if (i1 < 100) {
                        newStr3 = i1 + "" + subStr3.substring(subStr3.length() - 1, subStr3.length());
                    } else {
                        newStr3 = (i1 + "").substring(1, 3) + subStr3.substring(subStr3.length() - 1, subStr3.length());
                    }
                }
            }
            if (type == 9) {
                subStr1 = str.substring(0, 1);
                subStr2 = str.substring(1, str.length());
                int hashSub1 = Math.abs(subStr1.hashCode() * subStr1.hashCode() + hashSalt);
                int hashSub2 = Math.abs(subStr2.hashCode() + hashSalt);
                int dom2 = random.nextInt(hashSub2);
                newStr1 = soldiers[hashSub1 % (soldiers.length - 1)];
                int code = (int) (((float) dom2 / (float) hashSub2) * 10000);
                if (code < 10) {
                    newStr2 = "000" + code;
                } else if (code < 100) {
                    newStr2 = "00" + code;
                } else if (code < 1000) {
                    newStr2 = "0" + code;
                } else {
                    newStr2 = "" + code;
                }
                int code2 = (int) (((float) dom2 / (float) hashSub2) * ((float) dom2 / (float) hashSub2) * 10000);
                if (code2 < 10) {
                    newStr3 = "000" + code2;
                } else if (code2 < 100) {
                    newStr3 = "00" + code2;
                } else if (code2 < 1000) {
                    newStr3 = "0" + code2;
                } else {
                    newStr3 = "" + code2;
                }
            }
            str = newStr1 + newStr2 + newStr3 + newStr4;
            if (isSuangYin == 1) {
                str = "\"" + str + "\"";
            }
            return str;
        } catch (Exception e) {
            return value;
        }
    }


}
