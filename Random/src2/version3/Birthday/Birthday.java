package version3.Birthday;

/**
 * Created by ${LiuShuo} on 8/31/2016.
 */
public class Birthday {
    public static Object getBirthday(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");//空格
        str = str.replaceAll("\\u3000", "");//加空格
        int isSuangYin = 0;// 0:\u6CA1\u6709\u53CC\u5F15\u53F7
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length() < 2) return value;//\u4E00\u4E2A\u5B57\u4EC0\u4E48\u4E5F\u4E0D\u662F
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        int hashSalt = 25;
        if (salt == null || salt.equals("null") || salt.equals("")) {
        } else {
            hashSalt = Math.abs(Integer.parseInt((saltok.hashCode() + "").substring(0, 2))) % 50;
        }
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^(19|20)?[0-9]{2}(/|-)(0|1)?[1-9](/|-)(0|1|2|3)?[1-9]$");
        String s;//最终输出
        int linkType;//0:"-" 1:"/"
        String linkStr = null;
        int yearLength = 4;//2:年只有两位 4：年有四位
        if (!p.matcher(str).matches()) {
            return value;
        } else {
            if (str.contains("-")) {
                linkType = 0;
                linkStr = "-";
            }
            if (str.contains("/")) {
                linkType = 1;
                linkStr = "/";
            }
            String[] split = str.split(linkStr);

            int nian;
            if (split[0].length() == 2) {
                nian = Integer.parseInt("19" + split[0]);
                yearLength = 2;
            } else {
                nian = Integer.parseInt(split[0]);
            }
            int yue = Integer.parseInt(split[1]);
            int ri = Integer.parseInt(split[2]);

            int newNian;
            if (yearLength == 2) {
                newNian = (nian + hashSalt / 10) % 100;
            } else {
                newNian = nian + hashSalt / 10;
            }

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
            yueStr = newYue + "";
            riStr = newRi + "";
            s = newNian + linkStr + yueStr + linkStr + riStr;
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}
