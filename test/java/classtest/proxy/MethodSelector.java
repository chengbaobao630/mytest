package classtest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import  static Utils.Print.*;

/**
 * Created by cheng on 2016/4/7 0007.
 */
public class MethodSelector implements InvocationHandler {
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    private Object proxied;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("interesting"))
                print("Proxy detected the interesting methos");
            return method.invoke(proxied,args);

    }

}
interface SomeMethods{
    void  boring1();
    void  boring2();
    void interesting(String arg);
    void boring3();
}

class Implemenationg implements  SomeMethods{
    @Override
    public void boring1() {
        print("boring1");
    }

    @Override
    public void boring2() {
        print("boring2");
    }

    @Override
    public void interesting(String arg) {
        print("interesting "+arg );
    }

    @Override
    public void boring3() {
        print("boring3");
    }
}

class SelectingMethods{
    public  static  void  main(String args[]){
        SomeMethods proxy=(SomeMethods)Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),new Class[]{SomeMethods.class},new MethodSelector(new Implemenationg()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}
