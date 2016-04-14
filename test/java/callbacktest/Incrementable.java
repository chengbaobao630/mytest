package callbacktest;

/**
 * Created by cheng on 2016/3/27 0027.
 */
public interface Incrementable {
    void  increment();
}

class Callee1 implements  Incrementable{
    private  int i = 0;
    @Override
    public void increment() {
    i++;
    System.out.println(i);
    }

}

class  MyIncrement{
    public  void increment(){System.out.println("Other operation");}
    static  void f(MyIncrement mi){mi.increment();}
}

class Callee2 extends MyIncrement{
    private int i=0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    private  class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }

}
class  Caller{
    private Incrementable callbaclReference;
    Caller(Incrementable cbh){
        callbaclReference=cbh;
    }
    void  go(){
        callbaclReference.increment();
    }
}



