package classtest.proxy;
import  static Utils.Print.*;

/**
 * Created by cheng on 2016/4/7 0007.
 */
public interface Interfcae {
    void  doSomething();
    void  somethingElse(String arg);
}

class RealObject implements Interfcae{

    @Override
    public void doSomething() {
            print("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
            print("somethingElse "+arg);
    }
}
class SimpleProxy implements Interfcae{
    private Interfcae proxied;

    public SimpleProxy(Interfcae proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse "+arg);
        proxied.somethingElse(arg);
    }
}

class SimplePorxyDemo{
    public  static  void  consumer(Interfcae interfcae){
        interfcae.doSomething();
        interfcae.somethingElse("bonobo");
    }
    public static void main(String args[]){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
