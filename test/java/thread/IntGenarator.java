package thread;

/**
 * Created by cheng on 2016/4/28 0028.
 */
public  abstract class IntGenarator {
    private volatile boolean canceled= false;

    public abstract int next();

    public void cancel(){canceled=true;}

    public boolean isCanceled(){return canceled;}

}
