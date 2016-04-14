package cc.firstTest.Service;

import org.apache.commons.net.ftp.FTPFile;

import java.util.List;

/**
 * Created by cheng on 2016/4/11 0011.
 */
public interface FTPSrv {
    List<FTPFile>  getAllFiles();

}
