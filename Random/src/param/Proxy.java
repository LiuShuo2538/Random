package param;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ${LiuShuo} on 8/16/2016.
 */
public class Proxy {
    public static void main(String[] args) {
//        PPhone p = new PPhone();
//        p.setPhone(new IPhone());
//        p.call();
        Object proxyInstance = MPPhone.getProxyInstance(new IPhone());
        Phone proxyInstance1 = (Phone) proxyInstance;
        proxyInstance1.call();

    }

}

interface Phone {
    void call();
}

class IPhone implements Phone {
    @Override
    public void call() {
        System.out.println(" 被代理类工作 ");
    }
}

class PPhone implements Phone {

    private IPhone iPhone;

    public void setPhone(IPhone phone) {

        this.iPhone = phone;
    }

    @Override
    public void call() {
        System.out.println(" 代理类工作 ");
        iPhone.call();
    }
}

class DPPhone implements InvocationHandler{

    //被代理类声明
    private Object obj ;

    public void setObj(Object obj){
        this.obj = obj;
    }

    //当我们同通过代理类的对象调用接口中声明的方法时，会转变为被代理类中同名方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //反射执行被代理类的方法
        System.out.println(" 代理类执行方法 ");
        Object returnVal = method.invoke(obj , args);
        return returnVal;
    }
}

class MPPhone{
    public static Object getProxyInstance(Object o){//被代理类对象
        DPPhone dpPhone = new DPPhone();
        dpPhone.setObj(o);
        System.out.println(" 返回代理类对象 ");
        return  java.lang.reflect.Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),dpPhone);
    }
}


















