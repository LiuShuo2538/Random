package version3.Organozation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ${LiuShuo} on 2016/9/1.
 */
public class Organization {
    public static Object getModelGroupNum(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (!java.util.regex.Pattern.compile("[0-9A-Z]{8}-?[1-9X]").matcher(str).matches()) return value;
        int isGangFuHao = 0;
        if (str.length() == 10) {
            str = str.replace("-", "");
            isGangFuHao = 1;
        }
        String s = "";
        s = str.substring(0, 1) + "*******" + str.substring(str.length() - 1, str.length());

        if (isGangFuHao == 1) {
            s = s.substring(0, 8) + "-" + s.substring(8, 9);
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}
