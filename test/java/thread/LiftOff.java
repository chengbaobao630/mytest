package thread;

/**
 * Created by cheng on 2016/4/4 0004.
 */
public  class  LiftOff implements Runnable {
    protected int countDown=10;
    private static  int taskCount=0;
    private final int id =taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {

        this.countDown = countDown;
    }

    public  String status(){
        return "#"+id+"("+
                (countDown>0?countDown:"Lift Off!")+").";
    }

    @Override

    public void run() {
        while (countDown-->0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
