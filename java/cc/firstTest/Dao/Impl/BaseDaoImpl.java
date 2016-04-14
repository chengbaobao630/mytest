package cc.firstTest.Dao.Impl;

import cc.firstTest.Dao.BaseDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cheng on 2015/12/4 0004.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public T getById(Class<T> clazz, String uid) {
        return null;
    }

    @Override
    public List<T> gets(Class<T> clazz) {
        return null;
    }

    @Override
    public Boolean save(List list) {
        return null;
    }

    @Override
    public Boolean del(List list) {
        return null;
    }

    @Override
    public Boolean update(T t) {
        return null;
    }
}
