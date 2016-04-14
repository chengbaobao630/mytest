package classtest.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 2016/4/9 0009.
 */
public class SnowRemoveRobot implements  Robot {
    String name;

    public SnowRemoveRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        List<Operation> operations=new ArrayList<>();
        operations.add(new Operation() {
            @Override
            public String description() {
                return name+"can shovel snow";
            }

            @Override
            public void command() {
                System.out.println(name+"shoveling snow");
            }
        });
        operations.add(new Operation() {
            @Override
            public String description() {
                return name+"can chip ice";
            }

            @Override
            public void command() {
                System.out.println(name+"chipping ice");
            }
        });
        operations.add(new Operation() {
            @Override
            public String description() {
                return name+"can clear the roof";
            }

            @Override
            public void command() {
                System.out.println(name+"clearing roof");
            }
        });

        return operations;
    }

    public  static void  main(String[] args){
    Robot.Test.test(new SnowRemoveRobot("Slusher"));
    }
}
