package cc.firstTest.Service;

import cc.firstTest.MongoRepo.ResourceRepo;
import cc.firstTest.domain.Page;
import cc.firstTest.domain.ResourceInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by cheng on 2016/1/6 0006.
 */
@Service
public class ResourceSrv {
    @Resource
    ResourceRepo resourceRepo;

    public Boolean saveReourceInfo(ResourceInfo resourceInfo){
      return  resourceRepo.save(resourceInfo);

    }

    public List<ResourceInfo> getResources(Page page){
        return resourceRepo.getResourceByPage(page);
    }

    public Integer getTotalSize(){
        return resourceRepo.getTotalSize();
    }

    public List<String> getFileNames(Page page){
        return resourceRepo.getNames(page);
    }

    public boolean removeByNames(List<String> name){
        return resourceRepo.removeByNames(name);
    }
}
