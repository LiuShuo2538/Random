package version1;

import java.util.regex.Pattern;

/**
 * Created by ${LiuShuo} on 7/20/2016.
 */
public class Test {
    public static void main(String[] args) {
//        Object o = AddressFilterAlgorithm.getModelAddress("吉林四平铁东北门街北桥委二十四组", 1);

//        String s = "1区";
//        String[] split = s.split("区");
//        System.out.println(split.length);
//        Object o = NameENameCompositeFilterAlgorithm.getModelComName("胡伟斌", "axfgf");


//        Object o = Tele.getModelTele("1234567\\", 2);


//        if (Pattern.compile("[0-9A-Z]{8}-?[1-9X]").matcher("A2345678-X").matches()){
//            System.out.println("符合");
//        }


//        Object o = Group.getModelGroupNum("B2345678X", 10);

        String s1 = "1";
        String s2 = "";
        String s3 = "3";
        String s13 = "13";
        String s123 = s1+s2+s3;
        System.out.println(s13.getBytes().length);
        System.out.println(s123.getBytes().length);
//        System.out.println(o);
    }
}
