package cc.firstTest.Repository.Impl;


import cc.firstTest.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by cheng on 2015/12/7 0007.
 */
public class UserInfoRepoImpl {

    @PersistenceContext
    EntityManager em;

    public  Integer specificationsTest(){
        return  null;
    }

}
