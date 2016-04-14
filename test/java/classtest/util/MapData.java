package classtest.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by cheng on 2016/4/1 0001.
 */
public class MapData {
    public  static Map map(Iterable iterable, Integer integer){
        Map hashMap=new HashMap();
        Iterator iterator=iterable.iterator();
        while (iterator.hasNext()){
            hashMap.put(iterator.next(),integer);
        }
        return hashMap;
    }
}
