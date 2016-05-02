package thread;

import java.util.UUID;

/**
 * Created by cheng on 2016/4/28 0028.
 */
public class Joining {
    public static void main(String[] args){
        Sleeper
                sleepy=new Sleeper("Sleepy",1500),
                grumpy=new Sleeper("Grumpy",1500);
        Joiner
                dopey=new Joiner("Dopey",sleepy),
                doc=new Joiner("Doc",grumpy);
        grumpy.interrupt();

        System.out.print(UUID.randomUUID().toString());
    }
}
