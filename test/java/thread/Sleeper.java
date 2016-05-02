package thread;
import  static Utils.Print.*;
/**
 * Created by cheng on 2016/4/28 0028.
 */
public class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }

    public void run() {
        try{
        sleep(duration);
        }catch (InterruptedException e){
            print(getName()+"was interrupted."+
            "isInterrupted():"+isInterrupted());
            return;
        }
        print(getName()+" was awakened");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }

    public void run() {
        try{
            sleeper.join();
        }catch (InterruptedException e){
        print("Interrupted");
        }
        print(getName()+" join completed");
    }
}

