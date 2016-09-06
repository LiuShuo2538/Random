package version4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 电话号过滤算法（手机+座机 7、8、11、12位）
 * 所有位数全部清洗
 * Created by 刘硕 on 2016/9/6.
 */
public class TelephoneFilterAlgorithm {

    public static Object getModelTele(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");//\u9B3C\u7A7A\u683C
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        int hashSalt = 0;
        if (salt.length() < 1) {
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }
//\u624B\u673A\u524D\u4E09\u4F4D
        String[] num1to3 = {"130", "131", "132", "155", "156", "186", "185", "186", "185", "145", "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159", "182", "183", "188", "187", "133", "153", "180", "181", "189"};
//\u4E00\u7EBF\u57CE\u5E02\u524D3\u4F4D
        String[] num1Line = {"010", "021", "020", "022", "023", "024", "025", "027", "028", "029",};
//\u666E\u901A\u57CE\u5E02\u524D4\u4F4D
        String[] num2Line = {"0470", "0431", "0978", "0979", "0970", "0991", "0994", "0993", "0992", "0990", "0909", "0995", "0999", "0906", "0901", "0996", "0902", "0997", "0998", "0908", "0903", "0910", "0911", "0913", "0912", "0915", "0914", "0917", "0916", "0919", "0931", "0943", "0930", "0935", "0936", "0937", "0937", "0937", "0935", "0938", "0933", "0934", "0971", "0972", "0973", "0974", "0975", "0976", "0977", "0872", "0878", "0875", "0877", "0876", "0879", "0691", "0692", "0887", "0886", "0883", "0888", "0817", "0818", "0832", "0826", "0831", "0813", "0830", "0851", "0858", "0856", "0855", "0854", "0853", "0859", "0852", "0852", "0857", "0951", "0952", "0953", "0953", "0954", "0871", "0881", "0874", "0870", "0873", "0873", "0750", "0662", "0771", "0771", "0776", "0777", "0779", "0775", "0773", "0774", "0772", "0772", "0778", "0777", "0898", "0899", "0899", "0890", "0837", "0834", "0833", "0838", "0812", "0835", "0816", "0825", "0839", "0744", "0738", "0738", "0738", "0745", "0745", "0734", "0734", "0739", "0735", "0746", "0746", "0763", "0769", "0751", "0753", "0754", "0768", "0752", "0660", "0762", "0755", "0759", "0668", "0758", "0757", "0760", "0718", "0891", "0892", "0983", "0894", "0895", "0896", "0897", "0731", "0732", "0732", "0733", "0737", "0730", "0730", "0736", "0736", "0398", "0377", "0378", "0370", "0713", "0728", "0712", "0712", "0712", "0728", "0728", "0716", "0728", "0724", "0716", "0711", "0714", "0715", "0713", "0715", "0710", "0710", "0722", "0719", "0719", "0717", "0717", "0718", "0535", "0631", "0532", "0538", "0634", "0538", "0537", "0537", "0530", "0539", "0633", "0632", "0632", "0631", "0371", "0373", "0391", "0372", "0392", "0393", "0374", "0395", "0396", "0376", "0394", "0375", "0379", "0398", "0795", "0790", "0799", "0797", "0796", "0796", "0794", "0794", "0792", "0531", "0635", "0635", "0534", "0533", "0543", "0546", "0536", "0536", "0536", "0556", ".0556", "0591", "0594", "0599", "0599", "0592", "0595", "0595", "0596", "0597", "0598", "0598", "0593", "0791", "0792", "0798", "0793", "0701", "0579", "0579", "0577", "0551", "0554", "0552", "0557.", "0561", "0558", "0558", "0564", "0565", "0550", "0553", "0563", "0559", "0555", "0562", "0559", "0513", "0512", "0571", "0571", "0575", "0572", "0573", "0573", "0574", "0574", "0580", "0576", "0576", "0579", "0579", "0578", "0570", "0570", "0577", "0514", "0511", "0511", "0519", "0510", "0510", "0510", "0512", "0520", "0516", "0518", "0517", "0517", "0527", "0515", "0515", "0514", "0523", "0523", "0451", "0455", "0458", "0454", "0454", "0453", "0454", "0454", "0453", "0453", "0453", "0452", "0459", "0456", "0456", "0456", "0438", "0432", "0432", "0433", "0433", "0433", "0433", "0435", "0435", "0439", "0448", "0434", "0436", "0437", "0434", "0436", "0439", "0451", "0450", "0419", "0410", "0410", "0413", "0412", "0412", "0417", "0411", "0411", "0414", "0415", "0416", "0429", "0429", "0421", "0421", "0418", "0427", "0411", "0470", "0476", "0479", "0482", "0475", "0475", "0470", "0351", "0354", "0350", "0352", "0357", "0357", "0359", "0353", "0355", "0356", "0471", "0474", "0479", "0472", "0478", "0473", "0477", "0470", "0311", "0319", "0311", "0318", "0319", "0319", "0310", "0317", "0317", "0317", "0315", "0335", "0312", "0314", "0312", "0312", "0316", "0313"
        };
        Set setS = new HashSet(Arrays.asList(num1to3));
        Set setH3 = new HashSet(Arrays.asList(num1Line));
        Set setH4 = new HashSet(Arrays.asList(num2Line));
        String fenGeFu = "-";
        int indexFenGeFu1 = -1;
        int indexFenGeFu2 = -1;
        String newStr1 = "";
        String newStr2 = "";
//\u7535\u8BDD\u53F7\u7801\u5224\u65AD 0\uFF1A\u4E0D\u7B26\u5408\u672C\u5224\u65AD\u6807\u51C6\u4E0D\u505A\u64CD\u4F5C(\u5224\u65AD\u957F\u5EA6\u65F6\u76F4\u63A5\u8FD4\u56DE) 7:\u666E\u901A\u57CE\u5E02\u5EA7\u673A\u4E0D\u5E26\u533A\u53F7   8:\u4E00\u7EBF\u57CE\u5E02\u5EA7\u673A\u4E0D\u5E26\u533A\u53F7  11:\u624B\u673A  113\123\uFF1A\u4E00\u7EBF\u57CE\u5E02\u5EA7\u673A  114\124\uFF1A\u666E\u901A\u57CE\u5E02\u5EA7\u673A
        int type = 0;
/*\u7535\u8BDD\u53F7\u7801\u5224\u65AD\uFF1A\u624B\u673Aor\u5EA7\u673A \u5EA7\u673A\u53EF\u80FD\u51FA\u73B0\u2018-\u2019*/
        if (str.contains(fenGeFu)) {
            int i = str.indexOf(fenGeFu);
            int j = str.lastIndexOf(fenGeFu);
            if (i == j && i != -1) {
                indexFenGeFu1 = i;
            } else {
                indexFenGeFu1 = i;
                indexFenGeFu2 = j;
            }
        }
        str = str.replace(fenGeFu, "");
        String s1to3 = str.substring(0, 3);
        String s1to4 = str.substring(0, 4);
        if (str.length() == 7) {
            type = 7;
        } else if (str.length() == 8) {
            type = 8;
        } else if (str.length() == 11) {
//\u9A8C\u8BC1\u662F\u5426\u4E3A\u624B\u673A
            if (setS.contains(s1to3)) {
                type = 11;
            }
            if (setH3.contains(s1to3)) {
                type = 113;
            }
            if (setH4.contains(s1to4)) {
                type = 114;
            }
        } else if (str.length() == 12) {
            if (setH3.contains(s1to3)) {
                type = 123;
            }
            if (setH4.contains(s1to4)) {
                type = 124;
            }
        } else return value;
        if (type == 7) {
            String tempStr1 = "";
            String tempStr2 = "";
            String subStr03 = str.substring(0, 3);
            String subStr37 = str.substring(3, 7);
            int hash1 = Math.abs(subStr03.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr37.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            int code = (int) (((float) dom1 / (float) hash1) * 1000);
            if (code < 10) {
                tempStr1 = "00" + code;
            } else if (code < 100) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
//\u751F\u62108-11\u4F4D
            int code2 = (int) (((float) dom2 / (float) hash2) * ((float) dom2 / (float) hash2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;
        }
        if (type == 8) {

            String tempStr1 = "";
            String tempStr2 = "";
            String subStr04 = str.substring(0, 4);
            String subStr48 = str.substring(4, 8);
            int hash1 = Math.abs(subStr04.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr48.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            int code = (int) (((float) dom1 / (float) hash1) * 1000);
            if (code < 10) {
                tempStr1 = "000" + code;
            } else if (code < 100) {
                tempStr1 = "00" + code;
            } else if (code < 1000) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
//\u751F\u62108-11\u4F4D
            int code2 = (int) (Math.pow(((float) dom2 / (float) hash2), 2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;

        }
        if (type == 11) {
            String subStr1to3 = str.substring(0, 3);
            String subStr4to7 = str.substring(3, 7);
            String subStr8to11 = str.substring(7, 11);
            Random random = new Random(Math.abs(subStr1to3.hashCode() + hashSalt));
            newStr1 = num1to3[random.nextInt(num1to3.length)];
            int hash1 = Math.abs(subStr4to7.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr8to11.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            String tempStr1 = "";
            String tempStr2 = "";
//\u751F\u62104-7\u4F4D
            int code = (int) (((float) dom1 / (float) hash1) * 10000);
            if (code < 10) {
                tempStr1 = "000" + code;
            } else if (code < 100) {
                tempStr1 = "00" + code;
            } else if (code < 1000) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
//\u751F\u62108-11\u4F4D
            int code2 = (int) (((float) dom2 / (float) hash2) * ((float) dom2 / (float) hash2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;

        }
        if (type == 113) {
            String subStr1to7 = str.substring(0, 7);
            String subStr5to7 = str.substring(4, 7);
            String subStr8to11 = str.substring(7, 11);
            Random random = new Random(Math.abs(subStr1to7.hashCode() + hashSalt));
            newStr1 = num1Line[random.nextInt(num1Line.length)];
            int hash1 = Math.abs(subStr5to7.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr8to11.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            String tempStr1 = "";
            String tempStr2 = "";
            int code = (int) (((float) dom1 / (float) hash1) * 10000);
            if (code < 10) {
                tempStr1 = "000" + code;
            } else if (code < 100) {
                tempStr1 = "00" + code;
            } else if (code < 1000) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
            int code2 = (int) (((float) dom2 / (float) hash2) * ((float) dom2 / (float) hash2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;
        }
        if (type == 114) {
            String subStr1to7 = str.substring(0, 7);
            String subStr4to7 = str.substring(3, 7);
            String subStr8to11 = str.substring(7, 11);
            Random random = new Random(Math.abs(subStr1to7.hashCode() + hashSalt));
            newStr1 = num2Line[random.nextInt(num2Line.length)];
            int hash1 = Math.abs(subStr4to7.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr8to11.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            String tempStr1 = "";
            String tempStr2 = "";
            int code = (int) (((float) dom1 / (float) hash1) * 1000);
            if (code < 10) {
                tempStr1 = "00" + code;
            } else if (code < 100) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
            int code2 = (int) (((float) dom2 / (float) hash2) * ((float) dom2 / (float) hash2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;
        }
        if (type == 113) {
            String subStr1to7 = str.substring(0, 7);
            String subStr5to7 = str.substring(4, 7);
            String subStr8to12 = str.substring(7, 12);
            Random random = new Random(Math.abs(subStr1to7.hashCode() + hashSalt));
            newStr1 = num1Line[random.nextInt(num1Line.length)];
            int hash1 = Math.abs(subStr5to7.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr8to12.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            String tempStr1 = "";
            String tempStr2 = "";
            int code = (int) (((float) dom1 / (float) hash1) * 10000);
            if (code < 10) {
                tempStr1 = "000" + code;
            } else if (code < 100) {
                tempStr1 = "00" + code;
            } else if (code < 1000) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
            int code2 = (int) (((float) dom2 / (float) hash2) * ((float) dom2 / (float) hash2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;
        }
        if (type == 124) {
            String subStr1to7 = str.substring(0, 7);
            String subStr4to7 = str.substring(3, 7);
            String subStr8to12 = str.substring(7, 12);
            Random random = new Random(Math.abs(subStr1to7.hashCode() + hashSalt));
            newStr1 = num2Line[random.nextInt(num2Line.length)];
            int hash1 = Math.abs(subStr4to7.hashCode() + hashSalt);
            int hash2 = Math.abs(subStr8to12.hashCode() + hashSalt);
            Random random1 = new Random(hash1);
            Random random2 = new Random(hash2);
            int dom1 = random1.nextInt(hash1);
            int dom2 = random2.nextInt(hash2);

            String tempStr1 = "";
            String tempStr2 = "";
            int code = (int) (((float) dom1 / (float) hash1) * 10000);
            if (code < 10) {
                tempStr1 = "000" + code;
            } else if (code < 100) {
                tempStr1 = "00" + code;
            } else if (code < 1000) {
                tempStr1 = "0" + code;
            } else {
                tempStr1 = "" + code;
            }
            int code2 = (int) (((float) dom2 / (float) hash2) * ((float) dom2 / (float) hash2) * 10000);
            if (code2 < 10) {
                tempStr2 = "000" + code2;
            } else if (code2 < 100) {
                tempStr2 = "00" + code2;
            } else if (code2 < 1000) {
                tempStr2 = "0" + code2;
            } else {
                tempStr2 = "" + code2;
            }
            newStr2 = tempStr1 + tempStr2;
        }
        String s = newStr1 + newStr2;
        if (indexFenGeFu1 != -1) {
            s = s.substring(0, indexFenGeFu1) + fenGeFu + s.substring(indexFenGeFu1, s.length());
        }
        if (indexFenGeFu2 != -1) {
            s = s.substring(0, indexFenGeFu2) + fenGeFu + s.substring(indexFenGeFu2, s.length());
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}
