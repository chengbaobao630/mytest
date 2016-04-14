package Utils;

import java.util.*;

/**
 * Created by cheng on 2016/4/14 0014.
 */
public class New {
    public static  <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }

    public static <T> List<T> list(){
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> linkedList(){
        return new LinkedList<T>();
    }

    public static <T> Set<T> set(){
        return new HashSet<T>();
    }

    public static <T>  Queue<T> queue(){
        return new LinkedList<>();
    }
}
