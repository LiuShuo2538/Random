package com.wise.version1;

import version1.NameENameCompositeFilterAlgorithm;

/**
 * Created by ${LiuShuo} on 8/22/2016.
 */
public class Test {
    public static void main(String[] args) {
        /*日照市东港区北京路188号
算法：将所有replace(" ","")替换replaceAll("\\s*","")
         */

//        Object o = SanFenGuiYuanQi.getModelNameAddr("中国", null);
//        Object o = SHANDONGSanFenGuiYuanQi.getModelNameAddr("南宁市金谷隆粮油购销有限公司　　　　　　　　　　　　　　元数据", null);
        Object o = null;
        try {
            o = NameENameCompositeFilterAlgorithm.getModelComName("南宁市金谷隆粮油购销有限公司　　　　　　　　　　　　　　元数据", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String replace = "南宁市金谷隆粮油购销有限公司　　　　　　　　　　　　　　元数据".replaceAll("\\u3000", "");
//        int i = "　　　　　　　　　　　　　　".hashCode();
//        int j = "                            ".hashCode();
//        int k = "                            ".hashCode();
//        System.out.println(i+"------"+j+"------"+k);o
        System.out.println(o);
    }
}
