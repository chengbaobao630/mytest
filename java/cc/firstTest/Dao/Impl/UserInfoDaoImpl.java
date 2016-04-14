package cc.firstTest.Dao.Impl;

import cc.firstTest.Dao.UserInfoDao;
import cc.firstTest.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2015/12/4 0004.
 */
@Component("userDao")
public class UserInfoDaoImpl extends BaseDaoImpl<User> implements UserInfoDao {

    @Resource(name = "jdbcTemplate")

    private JdbcTemplate jdbcTemplate;

    public User findByNameAndPass(String account, String pass) {
        String hql = "from User where account='" + account + "' and pwd='" + pass + "'";
        String sql = "select * from user_info where account='" + account + "' and pwd='" + pass + "'";
        User user=jdbcTemplate.queryForObject(sql,User.class);
        List<Map<String,Object>> resultMap= jdbcTemplate.queryForList(sql);
        return user;
    }

    @Override
    public User getById(Class<User> clazz, String uid) {
        return null;
    }
}
