package classtest.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories=
            new ArrayList<>();
    static {

    }
}
