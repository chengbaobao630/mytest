package cc.firstTest.MongoRepo;

import cc.firstTest.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cheng on 2015/12/8 0008.
 */
public interface UserInfoRepo {

    User findByNameAndPass(String name,String password);

    List<String> getAccounts();

    void  insertUser(User user) throws  Exception;

    public void insertUsers(List<User> users) throws Exception;
}
