package thread;
import java.util.concurrent.ThreadFactory;

import  static Utils.Print.*;

/**
 * Created by cheng on 2016/4/28 0028.
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        print("run by "+t);
        print("eh = "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        print("ccaught thread "+t);
        print("caught "+e);
    }
}

class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        print(this+"creating new Thread");
        Thread t =new Thread(r);
        print("create"+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        print("eh= "+t.getUncaughtExceptionHandler());
        return t;
    }
}
