package com.wiseweb.email;

//import java.util.regex.Pattern;

import java.util.regex.Matcher;

/**
 * Created by ${LiuShuo} on 2016/6/22.
 */
public class Email {

    public static Object getM(Object value,Object key){

        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;

        String str = value+"";
        String newStr="";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
        boolean b = p.matcher(str).find();
        if (b){
            if (str.startsWith("@")||str.startsWith(" "))return value;
            String[] split = str.split("@");

            for (int i = 0; i < split[0].length(); i++) {
                
            }








            newStr= ""+"@"+split[1];
        }else return value;

        return newStr;
    }

    public static Object getR(Object value){

        return "";
    }


}
