package inter;

/**
 * Created by ${LiuShuo} on 2016/7/5.
 */
public class TestA {
        final int a = 0;
        public void p(final int a, int b){
            class te{
                void print(){
                    System.out.println(TestA.this.a);
                }
            }
            new te().print();
        }
        public static void main(String[] args) {
            new TestA().p(111, 222);

        }
}


