package Practice;

import Practice.com.entity.Persion;
import ShanDong.NameENameCompositeFilterAlgorithm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by ${LiuShuo} on 8/15/2016.
 */
public class Test {
    public static void main(String[] args) {

        Class clazz = Persion.class;
        System.out.println(clazz);

        Persion persion = new Persion();
        Class<? extends Persion> aClass = persion.getClass();
        System.out.println(aClass);

        try {
            Class<?> aClass1 = Class.forName("Practice.com.entity.Persion");
            System.out.println(aClass1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        Class<?> aClass1 = this.getClass().getClassLoader().loadClass("Practice.com.entity.Persion");

        Constructor[] constructors = clazz.getConstructors();//构造器
        System.out.println(constructors[0]);

        Method[] methods = clazz.getMethods();//获取运行时类及其所有父类中声明为public的方法
        System.out.println(methods[0]);
        System.out.println();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0; i <declaredMethods.length ; i++) {
            System.out.println(declaredMethods[i]);
        }
        try {
            Persion persion1 = (Persion) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
