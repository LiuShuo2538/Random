import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ${LiuShuo} on 2016/7/6.
 */
public class Ca {
    @Test
    public void TestFor() {

    }
    @Test
    public void Test2(){
        File f = new File("f:/localdown/localtxt1.txt");
        FileInputStream in = null;
        try {
            in = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            int read = in.read(buffer);
            while (read!= -1){
                for (int i = 0; i < read; i++) {
                    System.out.println((char)buffer[i]);
                }
                read = in.read(buffer);
            }






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in!= null){
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void Test1(){

        File f = new File("f:/localdown/localtxt1.txt");
//        File f2 = new File("f:/localtar");
//        File f3 = new File("srctxt.txt");
//
//        System.out.println(f3.renameTo(f));

        FileInputStream inn = null;
        try {
            inn = new FileInputStream(f);
            int read = inn.read();
            while (read!= -1){
                System.out.println((char) read);
                read = inn.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inn != null){
                    inn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }





}