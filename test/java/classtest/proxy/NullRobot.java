package classtest.proxy;

import classtest.util.Null;

import java.lang.reflect.Proxy;

/**
 * Created by cheng on 2016/4/9 0009.
 */
public class NullRobot{
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(Robot.class.getClassLoader(),new  Class[]{Robot.class, Null.class},new NullRobotProxyHandler(type));
    }
    public static void main(String[] args){
        Robot[] robots={
                new SnowRemoveRobot("SnowBee"),
                newNullRobot(SnowRemoveRobot.class)
        };
        for (Robot robot:robots)
            Robot.Test.test(robot);
    }

}
