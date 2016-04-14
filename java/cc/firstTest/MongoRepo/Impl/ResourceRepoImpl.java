package cc.firstTest.MongoRepo.Impl;

import cc.firstTest.MongoRepo.ResourceRepo;
import cc.firstTest.domain.Page;
import cc.firstTest.domain.ResourceInfo;
import com.mongodb.CommandResult;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cheng on 2016/1/6 0006.
 */
@Component
public class ResourceRepoImpl implements ResourceRepo {


    @Resource(name = "mongoTemplate")
    MongoTemplate mongoTemplate;


    @Override
    public Boolean save(ResourceInfo resource) {
        try{
            mongoTemplate.save(resource);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean remove(String id) {
        return null;
    }

    @Override
    public List<ResourceInfo> getResourceByPage(Page page) {
        Query query=new Query();
        List<ResourceInfo> list;
        if (page!=null)
            list= mongoTemplate.find(query.with(page),ResourceInfo.class);
        else
            list=mongoTemplate.findAll(ResourceInfo.class);

        return list;
    }

    @Override
    public Integer getTotalSize() {
        Query query=new Query();
        Long totalSize=mongoTemplate.count(query,ResourceInfo.class);
        return totalSize.intValue();
    }

    @Override
    public List<String> getNames(Page page) {
        Query query=new Query();
        List<String> names;
        CommandResult result=null;
        if (page!=null) {
            //names= mongoTemplate.find(query.addCriteria(new Criteria("name")).with(page),ResourceInfo.class,"resourceInfo");
            names= mongoTemplate.find(query.withHint("name"),String.class);
        }
        else
            names= mongoTemplate.find(query.withHint("name"),String.class);

        return names;
    }

    @Override
    public boolean removeByNames(List<String> name) {
        try {
            mongoTemplate.remove(new Query(Criteria.where("name").in(name)), ResourceInfo.class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
