package thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class DeamonThreadPoolExecutor extends ThreadPoolExecutor {
    public DeamonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new DeamonThreadFactory());
    }
}
