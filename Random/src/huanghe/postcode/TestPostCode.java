package huanghe.postcode;

import two_param.postcode.*;

/**
 * Created by ${LiuShuo} on 2016/6/29.
 */
public class TestPostCode {
    public static void main(String[] args) {

        Object m = two_param.postcode.PostCode.getM(123456, 11111);
        System.out.println(m);
    }
}

