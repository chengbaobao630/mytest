package cc.firstTest.Service.Impl;

import cc.firstTest.Service.FTPSrv;
import cc.firstTest.Utils.FTPUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cheng on 2016/4/11 0011.
 */
@Service
public class FTPSrvImpl implements FTPSrv {

    private static Logger log= LoggerFactory.getLogger(FTPSrv.class);

    @Value("${ftpPath}")
    private String ftpPath;

    @Value("${ftpAddr}")
    private String ftpAddr;

    @Value("${ftpPort}")
    private String ftpPort;

    @Value("${ftpUsername}")
    private String ftpUsername;

    @Value("${ftpPassword}")
    private String ftpPassword;

    @Override
    public List<FTPFile> getAllFiles() {
        try {
            FTPClient ftp = FTPUtils.ftpConnect(ftpPath, ftpAddr, Integer.valueOf(ftpPort), ftpUsername, ftpPassword);
            return Arrays.asList(ftp.listFiles());
        }catch (Exception e){
            log.error("get ftp file error",e);
        }
        return null;
    }

    
}
