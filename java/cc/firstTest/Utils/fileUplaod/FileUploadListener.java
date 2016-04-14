package cc.firstTest.Utils.fileUplaod;

import cc.firstTest.domain.FileUploadInfo;
import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cheng on 2016/1/9 0009.
 */
public class FileUploadListener implements ProgressListener {

    HttpSession  session;

    public FileUploadListener(HttpServletRequest request) {
        this.session=request.getSession();
        FileUploadInfo uploadInfo=FileUploadInfo.getIstance();
        session.setAttribute("fileUploadInfo",uploadInfo);
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
    FileUploadInfo uploadInfo=(FileUploadInfo)session.getAttribute("fileUploadInfo");
        uploadInfo.setpBytesRead(pBytesRead);
        uploadInfo.setpContentLength(pContentLength);
        uploadInfo.setpItems(pItems);
    }
}
