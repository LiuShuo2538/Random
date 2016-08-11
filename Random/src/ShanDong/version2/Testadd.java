package ShanDong.version2;


/**
 * Created by ${LiuShuo} on 8/10/2016.
 */
public class Testadd {
    public static void main(String[] args) throws Exception {
        Object o = AddressFilterAlgorithm.getModelAddress("日照市北京路198号市府大楼", null);
//        Object o = NameENameCompositeFilterAlgorithm.getModelComName("日照大厦1721室日照市审计局", 123);
        System.out.println(o);
    }
}
