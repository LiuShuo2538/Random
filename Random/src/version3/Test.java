package version3;

/**
 * Created by ${LiuShuo} on 8/16/2016.
 */
public class Test {
    public static void main(String[] args) {
        Object o = null;
        try {
            o = NameENameCompositeFilterAlgorithm.getModelComName("黑龙江省建三江农垦鑫龙水稻专业合作社", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(o);
    }

}
