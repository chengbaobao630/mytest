package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cheng on 2016/4/28 0028.
 */
public   class   EvenGenerator extends IntGenarator {
    private Lock lock=new ReentrantLock();
    private  int currentValue;
    @Override
    public  int next() {
        lock.lock();
        try {
            ++currentValue;
            Thread.yield();
            ++currentValue;
            return currentValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
