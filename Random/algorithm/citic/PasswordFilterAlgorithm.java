package citic;

import java.math.BigDecimal;

/**
 * 中信银行特有算法 密码清洗统一清洗为112233
 * Created by ${LiuShuo} on 7/20/2016.
 */
public class PasswordFilterAlgorithm {

    public static Object getModelPassword(Object value, Object key){

        if (value==null||value.equals("null")||value.equals("")) return "";
        String str = value+"";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"")&&str.startsWith("\"")){
            isSuangYin = 1;
        }
        String s = "112233";
        if (isSuangYin == 1){
            s = "\"" + s +"\"";
        }
        if(value instanceof BigDecimal){
            return new BigDecimal(s);
        }else if(value instanceof Long){
            return Long.parseLong(s);
        }else if(value instanceof Double){
            return Double.parseDouble(s);
        }
        return s;
    }



}
