package version3;

import version3.Birthday.Birthday;
import version3.ID.ID;
import version3.Name.Name;
import version3.Telephone.TelePhone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${LiuShuo} on 8/31/2016.
 */
public class TestPublic {
    public static void main(String[] args) {
//        Pattern compile = Pattern.compile("^(19|20)?[0-9]{2}(/|-)(0|1)?[1-9](/|-)(((0|1|2)?[1-9])|3[0-1])$");
//        Pattern compile = Pattern.compile("[0-9]*(.)[0-9]{2}$");
//        Matcher matcher = compile.matcher("783.21");
//        boolean matches = matcher.matches();
//        System.out.println(matches);
//        Object o = Birthday.getBirthday("\"1992/2/25\"", 77);
//        Object o = Name.getModelComName("·啊实·啊实打=", 12);
//        Object o = TelePhone.getModelTele("13630950849", null);
        Object o = ID.getModelIDCard(220323199203080817L, null);

        System.out.println(o);

    }
}
