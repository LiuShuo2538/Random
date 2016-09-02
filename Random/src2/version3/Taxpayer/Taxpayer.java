package version3.Taxpayer;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by ${LiuShuo} on 2016/9/1.
 */
public class Taxpayer {
    public static Object getModelTaxNum(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
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
        if (str.length() == 15) {
            type = 15;
        } else if (str.length() == 18) {
            type = 18;
        } else if (str.length() == 20) {
            type = 20;
        } else return value;
        if (type == 15) {
            s = str.substring(0, 3) + "*********" + str.substring(str.length() - 3, str.length());
        }
        if (type == 18) {
            s = str.substring(0, 3) + "************" + str.substring(str.length() - 3, str.length());
        }
        if (type == 20) {
            s = str.substring(0, 3) + "**************" + str.substring(str.length() - 3, str.length());
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}
