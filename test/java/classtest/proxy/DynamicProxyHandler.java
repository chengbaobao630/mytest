package classtest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cheng on 2016/4/7 0007.
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***** proxy: "+proxy.getClass()+
        ",method: "+method+",args: "+args);
        if(args!=null)
            for(Object o:args){
                System.out.println(o);
            }

        return method.invoke(proxied,args);
    }

}

class SimpleDynamicProxy{
    public  static void consumer(Interfcae iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void  main(String[] args){
    RealObject realObject=new RealObject();
        consumer(realObject);
        Interfcae proxy= (Interfcae) Proxy.newProxyInstance(Interfcae.class.getClassLoader(),new Class[]{Interfcae.class},new DynamicProxyHandler(realObject));
    consumer(proxy);
    }
}
