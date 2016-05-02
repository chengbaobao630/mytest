package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import  static Utils.Print.*;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class DeamonFromFactory implements Runnable {
    @Override
    public void run() {
        try{
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread()+" "+this);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            print("Interrupted");
        }
    }

    public  static void  main(String[] args) throws  Exception{
        ExecutorService executorService= Executors.newCachedThreadPool(new DeamonThreadFactory());
        for(int a=0;a<10;a++){
            executorService.execute(new DeamonFromFactory());
        }
        print("All thread started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
