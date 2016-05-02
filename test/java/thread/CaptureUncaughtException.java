package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cheng on 2016/4/28 0028.
 */
public class CaptureUncaughtException {
    public static  void  main(String[] args){
        ExecutorService exec= Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }
}
