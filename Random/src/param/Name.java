package param;

/**
 * Created by ${LiuShuo} on 8/23/2016.
 */
public class Name {
    public int a= 1;
    public static int b = 1;

    public static void main(String[] args) {
        Name s1 = new Name();
        Name s2 = new Name();
        s1.a = s1.a + 1;
        s2.a = s2.a + 1;
        System.out.println("s1.a=" +s1.a);
        System.out.println("s2.a=" +s2.a);

        s1.b = s1.b + 1;
        s2.b = s2.b + 1;
        System.out.println("s1.b=" +s1.b);
        System.out.println("s2.b=" +s2.b);
    }

}
