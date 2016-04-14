package thread;

import java.util.concurrent.*;

/**
 * Created by cheng on 2016/4/4 0004.
 */
public class MainThread {
/*    public  static  void  main(String[] args){
        ExecutorService exec=Executors.newCachedThreadPool();
       for(int i=0;i<5;i++)
           exec.execute(new LiftOff());
           exec.shutdown();

    }*/
    public  static  void  main(String[] args){
        ExecutorService exec=Executors.newSingleThreadExecutor();
       for(int i=0;i<5;i++)
           exec.execute(new LiftOff());
           exec.shutdown();

    }
}
