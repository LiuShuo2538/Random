package citic.password;

import java.math.BigDecimal;

/**
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class Password {
    public static Object getM(Object value,Object key) {

        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value == null || value.equals("null") || value.equals("")) return value;
        String s = value + "";
        s="112233";
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
