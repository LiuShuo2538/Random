package huanghe.license;

import two_param.license.*;

/**
 * Created by ${LiuShuo} on 2016/6/30.
 */
public class TestLisense {
    public static void main(String[] args) {
        Object m = two_param.license.License.getM("612621600002519", 123);
        System.out.println(m);
    }
}
