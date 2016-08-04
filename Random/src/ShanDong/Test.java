package ShanDong;

/**
 * Created by ${LiuShuo} on 8/4/2016.
 */
public class Test {
    public static void main(String[] args) {
        Object o = null;
        try {
            o = NameENameCompositeFilterAlgorithm.getModelComName("山东钱钱撒大有限公司", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(o);


    }
}
