package cc.firstTest.myQuartz;

import cc.firstTest.Service.FTPSrv;
import cc.firstTest.Service.ResourceSrv;
import cc.firstTest.domain.ResourceInfo;
import org.apache.commons.net.ftp.FTPFile;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by cheng on 2016/4/11 0011.
 */
@Component
public class SyncFTP{

    private  static  final String DEFAULT_PATH="/opt/ftp/";

    @Resource
    FTPSrv ftpSrv;

    @Resource
    ResourceSrv resourceSrv;

    @Scheduled(cron = "0 * */3 * * * ")
    public void syncMongoFtp() throws Exception{
        List<FTPFile> ftpFileLits=ftpSrv.getAllFiles();
        List<ResourceInfo> resources=resourceSrv.getResources(null);
        List<String> resourceNames=new ArrayList<>();
        for (ResourceInfo info:resources){
            resourceNames.add(info.getName());
        }
        Iterator it=ftpFileLits.listIterator();
        while (it.hasNext()){
            FTPFile ftpFile=(FTPFile)it.next();
            if(resourceNames.contains(new String(ftpFile.getName().getBytes(),"utf-8"))){
                resourceNames.remove(new String(ftpFile.getName().getBytes(),"utf-8"));
            }else{
                ResourceInfo resourceInfo=new ResourceInfo();
                resourceInfo.setName(new String(ftpFile.getName().getBytes(),"utf-8"));
                resourceInfo.setId(UUID.randomUUID().toString());
                resourceInfo.setCreateDate(ftpFile.getTimestamp().getTime());
                resourceInfo.setSize(ftpFile.getSize());
                resourceInfo.setType(String.valueOf(ftpFile.getType()));
                resourceInfo.setUploadUser(ftpFile.getUser());
                resourceInfo.setPath(DEFAULT_PATH);
                resourceSrv.saveReourceInfo(resourceInfo);
            }
        }
        if(resourceNames.size()>0)
            resourceSrv.removeByNames(resourceNames);
    }

}
