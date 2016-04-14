package cc.firstTest.Utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * Created by cheng on 2016/1/7 0007.
 */
public class FTPUtils {




    private static FTPClient ftp=new FTPClient();



   /* private FTPUtils() {
        if(ftp==null){
            ftp=new FTPClient();
        }
    }*/



    public static final  FTPClient ftpConnect(String path, String addr, int port, String username, String password)throws  Exception{
        Boolean result=false;

        Integer replay;

        ftp.connect(addr,port);

        ftp.login(username,password);

        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

        replay=ftp.getReplyCode();
        if(!FTPReply.isPositiveCompletion(replay)){
            ftp.disconnect();
            return null;
        }
        ftp.changeWorkingDirectory(path);

        return ftp;
    }

}
