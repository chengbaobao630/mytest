package thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static Utils.Print.*;
/**
 * Created by cheng on 2016/4/28 0028.
 */
public class EvenChecker implements Runnable {
    private IntGenarator genarator;
    private final int id;

    public EvenChecker(IntGenarator g,int id) {
        genarator=g;
        this.id = id;
    }

    @Override
    public void run() {
        while (!genarator.isCanceled()){
            int val=genarator.next();
            if (val%2!=0){
                print(val+" not even");
                genarator.cancel();
            }
        }
    }

    public static void test(IntGenarator gp,int count){
        print("Press Control-c to exit");
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int a=0;a<count;a++){
            exec.execute(new EvenChecker(gp,a));
        }
        exec.shutdown();
    }
    public static void test(IntGenarator gp){
        test(gp,10);
    }
}
