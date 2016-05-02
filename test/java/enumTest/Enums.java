package enumTest;

import java.util.Random;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class Enums {
    private static Random random=new Random(47);
    public static <T extends Enum<T>> T random(Class<T> clazz){
    return random(clazz.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[random.nextInt(values.length)];
    }
}
