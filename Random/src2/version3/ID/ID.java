package version3.ID;

/**
 * Created by ${LiuShuo} on 2016/9/1.
 */
public class ID {
    public static Object getModelIDCard(Object value, Object key) {

        if (value == null || value.equals("null") || value.equals("")) return "";
        if (value instanceof byte[]) return value;
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        int type = 0;
        String s = "";
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

        if (type == 18) {
            s = str.substring(0, 6) + "************";
        }
        if (type == 15) {
            s = str.substring(0, 6) + "*********";
        }
        if (type == 9) {
            s = str.substring(0, 1) + "*********";
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}
