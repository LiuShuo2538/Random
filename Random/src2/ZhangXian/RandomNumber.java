package ZhangXian;

/**
 * 数字就脱 需要保持唯一性 和盐值无关
 * Created by ${LiuShuo} on 2016/9/8.
 */
public class RandomNumber {

    public static Object getRN(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length() == 0) return value;

        String[] arrabc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] arrABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] arr123 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String Pabc = "[a-z]";
        String PABC = "[A-Z]";
        String P123 = "[0-9]";

        String[] arrStr = new String[str.length()];
        for (int i = 0; i < arrStr.length; i++) {
            String temp = str.substring(i, i + 1);
            if (java.util.regex.Pattern.compile(Pabc).matcher(temp).matches()) {
                int i1 = "abcdefghijklmnopqrstuvwxyz".indexOf(temp);
                if (i1 == 25) {
                    i1 = 0;
                } else {
                    i1++;
                }
                arrStr[i] = arrabc[i1];

            } else if (java.util.regex.Pattern.compile(PABC).matcher(temp).matches()) {
                int i1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(temp);
                if (i1 == 25) {
                    i1 = 0;
                } else {
                    i1++;
                }
                arrStr[i] = arrABC[i1];

            } else if (java.util.regex.Pattern.compile(P123).matcher(temp).matches()) {
                int i1 = "0123456789".indexOf(temp);
                if (i1 == 9) {
                    i1 = 0;
                } else {
                    i1++;
                }
                arrStr[i] = arr123[i1];
            } else if (temp.equals("-")){
                arrStr[i] = "-";
            }else return value;
        }
        String s = "";
        for (int i = 0; i < arrStr.length; i++) {
            s += arrStr[i];
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;

    }


}
