package ShanDong;




/**
 * Created by ${LiuShuo} on 8/4/2016.
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Object o = AddressFilterAlgorithm.getModelAddress("山东日照龙12镇xx村！@社--组", null);
        System.out.println(o);
    }
}
