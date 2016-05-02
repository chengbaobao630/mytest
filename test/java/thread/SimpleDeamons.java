package thread;
import org.springframework.aop.ThrowsAdvice;

import java.util.concurrent.*;
import  static Utils.Print.*;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class SimpleDeamons implements Runnable{
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this.hashCode());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            print("sleep() interrupted");
        }
    }

    public  static void  main(String[] args) throws  Exception{
        for(int i = 0;i < 10;i++){
            Thread deamon=new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        print("All deamons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }

}
