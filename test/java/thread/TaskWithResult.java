package thread;

import java.util.concurrent.Callable;

/**
 * Created by cheng on 2016/4/4 0004.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult"+id;
    }
}
