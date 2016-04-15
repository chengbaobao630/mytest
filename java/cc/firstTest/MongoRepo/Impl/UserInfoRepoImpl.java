package cc.firstTest.MongoRepo.Impl;

import cc.firstTest.MongoRepo.UserInfoRepo;
import cc.firstTest.domain.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2015/12/8 0008.
 */
@Component(value = "userMongoDao")
public class UserInfoRepoImpl implements UserInfoRepo {

    @Resource(name = "mongoTemplate")
    MongoTemplate mongoTemplate;

    @Override
    public User findByNameAndPass(String name, String password) {
        User user= mongoTemplate.findOne(new Query(Criteria.where("account").is(name)).addCriteria(Criteria.where("pwd").is(password)),User.class);
        return user;
    }

    @Override
    public List<String> getAccounts() {
        Query query = new Query();
        query.fields().include("account");
        List<User> users=mongoTemplate.find(query,User.class);
        List<String> accounts=new ArrayList<>();
        for(User user:users){
            accounts.add(user.getAccount());
        }
       // return accounts;
        return accounts;
    }

    @Override
    public void insertUser(User user)throws  Exception {
        mongoTemplate.save(user);
    }

    public void insertUsers(List<User> users) throws Exception{
        mongoTemplate.insert(users,User.class);
    }
}
