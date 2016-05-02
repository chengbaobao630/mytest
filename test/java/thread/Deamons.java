package thread;
import java.util.concurrent.TimeUnit;

import static Utils.Print.*;
/**
 * Created by cheng on 2016/4/27 0027.
 */
public class Deamons {
    public static void main(String args[]) throws Exception{
        Thread d=new Thread(new Deamon());
        d.setDaemon(true);
        d.start();
        print("d.isDeamon()="+d.isDaemon()+".");
        TimeUnit.SECONDS.sleep(1);
    }
}
