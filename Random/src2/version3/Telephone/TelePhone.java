package version3.Telephone;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ${LiuShuo} on 2016/9/1.
 */
public class TelePhone {
    public static Object getModelTele(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");//鬼空格
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }

        //\u624B\u673A\u524D\u4E09\u4F4D
        String[] num1to3 = {"130", "131", "132", "155", "156", "186", "185", "186", "185", "145", "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159", "182", "183", "188", "187", "133", "153", "180", "181", "189"};
        //\u4E00\u7EBF\u57CE\u5E02\u524D3\u4F4D
        String[] num1Line = {"010", "022", "021", "023"};
        //\u666E\u901A\u57CE\u5E02\u524D4\u4F4D
        String[] num2Line = {"0311", "0310", "0319", "0312", "0313", "0314", "0315", "0335", "0317", "0316", "0318", "0591", "0592", "0598", "0594", "0595", "0596", "0599", "0593", "0597", "0791", "0798", "0790", "0792", "0701", "0793", "0795", "0794", "0796", "0797", "0531", "0532", "0533", "0536", "0535", "0631", "0537", "0633", "0534", "0530", "0351", "0352", "0353", "0355", "0349", "0354", "0358", "0357", "0359", "0471", "0472", "0476", "0479", "0470", "0475", "0477", "0482", "0371", "0378", "0379", "0373", "0393", "0370", "0377", "0394", "0396", "0411", "0412", "0413", "0414", "0415", "0416", "0417", "0418", "0419", "0410", "0714", "0710", "0719", "0717", "0714", "0712", "0713", "0718", "0716", "0431", "0423", "0434", "0437", "0435", "0439", "0436", "0433", "0440", "0731", "0733", "0732", "0734", "0730", "0736", "0735", "0737", "0746", "0745", "0744", "0451", "0452", "0459", "0458", "0453", "0454", "0455", "0457", "0456", "0755", "0756", "0754", "0751", "0752", "0769", "0760", "0757", "0759", "0516", "0518", "0517", "0527", "0515", "0514", "0513", "0511", "0519", "0510", "0512", "0520", "0771", "0772", "0773", "0774", "0779", "0777", "0898", "0899", "0890", "0812", "0838", "0816", "0813", "0832", "0833", "0830", "0831", "0571", "0574", "0573", "0572", "0575", "0579", "0570", "0580", "0577", "0576", "0851", "0852", "0853", "0858", "0551", "0554", "0552", "0555", "0556", "0559", "0550", "0557", "0565", "0563", "0871", "0870", "0874", "0877", "0879", "0888", "0873", "0878", "0919", "0917", "0913", "0914", "0891", "0892", "8018", "8059", "0897", "0931", "0935", "0938", "0933", "0937", "0937", "0971", "0972", "0979", "0975", "0951", "0952", "0953", "0954", "0991", "0990", "0995", "0998", "0908", "0996"
        };
        Set setS = new HashSet(Arrays.asList(num1to3));
        Set setH3 = new HashSet(Arrays.asList(num1Line));
        Set setH4 = new HashSet(Arrays.asList(num2Line));

        String s = "";

        //\u7535\u8BDD\u53F7\u7801\u5224\u65AD 0\uFF1A\u4E0D\u7B26\u5408\u672C\u5224\u65AD\u6807\u51C6\u4E0D\u505A\u64CD\u4F5C(\u5224\u65AD\u957F\u5EA6\u65F6\u76F4\u63A5\u8FD4\u56DE) 7:\u666E\u901A\u57CE\u5E02\u5EA7\u673A\u4E0D\u5E26\u533A\u53F7   8:\u4E00\u7EBF\u57CE\u5E02\u5EA7\u673A\u4E0D\u5E26\u533A\u53F7  11:\u624B\u673A  113\uFF1A\u4E00\u7EBF\u57CE\u5E02\u5EA7\u673A  114\uFF1A\u666E\u901A\u57CE\u5E02\u5EA7\u673A
        int type = 0;
        if (!java.util.regex.Pattern.compile("[0-9]*").matcher(str).matches()) return value;
        if (str.length() == 7) {
            type = 7;
        } else if (str.length() == 8) {
            type = 8;
        } else if (str.length() == 11) {
            if (setS.contains(str.substring(0, 3))) {
                type = 11;
            }
            if (setH3.contains(str.substring(0, 3))) {
                type = 113;
            }
            if (setH4.contains(str.substring(0, 4))) {
                type = 114;
            }
        } else return value;

        if (type == 7) {
            s = "*******";
        }
        if (type == 8) {
            s = "********";
        }
        if (type == 11) {
            s = str.substring(0, 3) + "********";
        }
        if (type == 113) {
            s = str.substring(0, 3) + "********";
        }
        if (type == 114) {
            s = str.substring(0, 4) + "*******";
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        if (value instanceof BigDecimal) {
            return new BigDecimal(s);
        } else if (value instanceof Long) {
            return Long.parseLong(s);
        } else if (value instanceof Double) {
            return Double.parseDouble(s);
        }
        return s;
    }
}
