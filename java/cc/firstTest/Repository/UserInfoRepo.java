package cc.firstTest.Repository;


import cc.firstTest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by cheng on 2015/12/7 0007.
 */
public interface UserInfoRepo extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {

    @Query(value = "FROM User  where account=?1 and pwd = ?2")
     User findByNameAndPass(String account,String password);

    @Query(value = "FROM User ")
    List<User> getUsers();
}
