package version2;

/**
 * Created by ${LiuShuo} on 2016/9/5.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Object o = NameENameAddressFilterAlgorithm.getModelNameAddr("济宁市通恒农贸有限责任公司", null);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
