package id2;

/**
 * Created by ${LiuShuo} on 8/3/2016.
 */
public class Test {
    public static void main(String[] args) {
//        java.util.regex.Pattern id15 = java.util.regex.Pattern.compile("^[0-9]{15}\\s*$");
//
//        System.out.println(id15.matcher("123X56789012345").matches());
        Object o = ICCompositeFilterAlgorithm.getModelIDCard("320025197110148016", null);
        System.out.println(o);
    }
}
