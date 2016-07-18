package inter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ${LiuShuo} on 2016/7/13.
 */
public class Test11 {
    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void test() throws IOException {
        Properties pro = new Properties();
        FileInputStream is =  new FileInputStream(new File("jdbc.properties"));
        pro.load(is);

        System.out.println( pro.getProperty("userName"));
        Iterator<Map.Entry<Object, Object>> iterator = pro.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
