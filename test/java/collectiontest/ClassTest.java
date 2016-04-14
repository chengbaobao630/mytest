package collectiontest;

/**
 * Created by cheng on 2016/3/31 0031.
 */
public class ClassTest {

    public  static  void  main(String[] args) throws  Exception{
        char[] cs={'a','b','c'};
        System.out.println(cs.getClass().isPrimitive());
        System.out.println(cs.getClass().isArray());
        System.out.println(cs.getClass().isSynthetic());
        System.out.println(cs.getClass().getSuperclass().getName());
        System.out.println(cs.getClass().getName());
        System.out.println(cs.getClass().getComponentType().getName());
    }
}
