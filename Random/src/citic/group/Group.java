package citic.group;

/**
 * Created by ${LiuShuo} on 2016/7/4.
 */
public class Group {
    public static Object getM(Object value,Object key) {
        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value == null || value.equals("null") || value.equals("")) return value;
        String str = value + "";
        str = str.replace(" ", "");
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;

        if (salt.length() < 1) {
            //没有盐值
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }






        if (str.length() == 8){









        }else if(str.length() == 9){









        }else return value;

        return "";
    }


}
