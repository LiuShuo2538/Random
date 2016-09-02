package version3.Licence;

import java.math.BigDecimal;

/**
 * Created by ${LiuShuo} on 2016/9/1.
 */
public class Licence {

    public static Object getModelLicence(Object value, Object key) {

        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length() != 15) return value;
        String s = "";

        s = str.substring(0,2)+"***********"+str.substring(str.length()-2,str.length());

        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }


}
