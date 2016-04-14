package cc.firstTest.Service;

import cc.firstTest.Dao.Impl.UserInfoDaoImpl;
import cc.firstTest.Repository.UserInfoRepo;
import cc.firstTest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cheng on 2015/12/4 0004.
 */
@Service
public class LoginSrv {
    @Autowired
    UserInfoDaoImpl userInfoDao;

    @Resource
    UserInfoRepo userInfoRepo;

    @Resource
    cc.firstTest.MongoRepo.UserInfoRepo userMongoRepo;

    public User isExist(String name,String pass){
        /*User user =userInfoDao.findByNameAndPass(name,pass);
        User user1=userInfoRepo.findByNameAndPass(name,pass);
        List<User> users=userInfoRepo.getUsers();
        PageRequest pageRequest=new PageRequest(0,1);
        Page<User> userPage=    userInfoRepo.findAll(pageRequest);*/
        User user1=userMongoRepo.findByNameAndPass(name,pass);
        if (user1!=null){

            return user1;
        }
        return null;
    }

    public Boolean accountIsExist(String account) {
        List<String> accounts=userMongoRepo.getAccounts();
        if(accounts.contains(account)){
            return true;
        }else{
            return false;
        }
    }

    public  void  addUser(User user)throws  Exception{
        userMongoRepo.insertUser(user);
    }
}
