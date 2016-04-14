package cc.firstTest.Dao;


import java.util.List;

/**
 * Created by cheng on 2015/12/4 0004.
 */
public interface  BaseDao<T> {

    T getById(Class<T> clazz,String uid);

    List<T> gets(Class<T> clazz);

    Boolean save(List<T> list);

    Boolean del(List<T> list);

    Boolean update(T t);


}
