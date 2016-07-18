package com.wiseweb.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${LiuShuo} on 2016/6/22.
 */
public class TestEmail {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");

        String input = "1@qq.com";
        Matcher matcher = p.matcher(input);
        boolean b = matcher.find();
        System.out.println(b);

    }
}
