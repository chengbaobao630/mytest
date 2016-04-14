package cc.firstTest.MongoRepo;

import cc.firstTest.domain.Page;
import cc.firstTest.domain.ResourceInfo;

import java.util.List;

/**
 * Created by cheng on 2016/1/6 0006.
 */
public interface ResourceRepo {

    Boolean save(ResourceInfo resource);

    Boolean remove(String id);

    List<ResourceInfo> getResourceByPage(Page page);

    Integer getTotalSize();

    List<String> getNames(Page page);

    boolean  removeByNames(List<String> name);
}
