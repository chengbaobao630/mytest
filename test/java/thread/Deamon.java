package thread;

import  static Utils.Print.*;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class Deamon implements Runnable {
    private  Thread[] threads=new Thread[10];
    @Override
    public void run() {
        for(int a=0;a < threads.length;a++){
            threads[a]=new Thread(new DeamonSpawn());
            threads[a].start();
            print("DeamonSpawn "+a+" started");
        }
        for(int a=0;a < threads.length;a++){
            print("t["+a+"].isDeamon="+threads[a].isDaemon()+",");
        }
        while (true)
            Thread.yield();
    }
}
class DeamonSpawn implements Runnable{
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}

