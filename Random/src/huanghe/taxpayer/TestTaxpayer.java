package huanghe.taxpayer;


import two_param.taxpayer.*;

/**
 * Created by ${LiuShuo} on 2016/6/30.
 */
public class TestTaxpayer {
    public static void main(String[] args) {

//        Object m = Taxpayer.getM("410104764886171", 123);
//        Object m = Taxpayer.getM("22032319920308081x", 123);
//        Object m = Taxpayer.getM("22032319920308081700", 123);
        Object m = two_param.taxpayer.Taxpayer.getM("123456A2345678X", "77asdaww8787");
        System.out.println(m);



        /*
        532 922 566 344 056
        370 112 197 906 155 399
        370 112 197 906 155 399
        370 112 197 906 155 39900
        220 800 530 102 875 00011
         */
    }
}
