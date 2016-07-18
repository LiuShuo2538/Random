package two_param.public_pack;

/**
 * Created by ${LiuShuo} on 2016/6/22.
 */
public class ValiDate {
    public static void main(String[] args) {
        String str ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*[A-Za-z]*[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]*");
        for (int i=0;i<str.length();i++){
//            java.util.regex.Matcher matcher = pattern.matcher(str.substring(i,i+1));
//            boolean matches = matcher.matches();
            String substring = str.substring(i, i + 1);

            System.out.print("\""+substring+"\",");
//
//
//
//
        }

//        String[] str = {
//
//                "漳州市","厦门市","泉州市","福州市","莆田市","宁德市","三明市","南平市","龙岩市"
//
//
//
//
//        };
//        for (int i = 0; i < str.length; i++) {
//
//            System.out.print("\""+"福建省"+str[i]+"\",");
//        }







    }

















}
