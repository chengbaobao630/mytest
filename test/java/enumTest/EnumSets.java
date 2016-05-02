package enumTest;
import org.omg.PortableServer.POA;

import java.util.EnumSet;

import  static  enumTest.AlarmPoints.*;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class EnumSets {

    public static void main(String args[]){
        EnumSet<AlarmPoints> pointses=
                EnumSet.noneOf(AlarmPoints.class);
        pointses.add(BATHROOM);
        System.out.println(pointses);
        pointses.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(pointses);
        pointses=EnumSet.allOf(AlarmPoints.class);
        System.out.println(pointses);
        pointses.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(pointses);
        pointses.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        System.out.println(pointses);
        pointses=EnumSet.complementOf(pointses);
        System.out.println(pointses);
        pointses=EnumSet.complementOf(pointses);
        System.out.println(pointses);


    }
}
