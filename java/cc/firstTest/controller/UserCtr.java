package cc.firstTest.controller;

import cc.firstTest.Service.ResourceSrv;
import cc.firstTest.Utils.FTPUtils;
import cc.firstTest.Utils.fileUplaod.FileUploadListener;
import cc.firstTest.domain.FileUploadInfo;
import cc.firstTest.domain.Page;
import cc.firstTest.domain.ResourceInfo;
import cc.firstTest.domain.User;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by cheng on 2015/12/18 0018.
 */
@Controller
@RequestMapping("/user")
public class UserCtr {

    public static Log log= LogFactory.getLog(UserCtr.class);

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

    @Resource
    ResourceSrv resourceSrv;


    @RequestMapping(value = "my.html")
    public  String myCenter(){
        return "my";
    }





    @RequestMapping(value = "uploadFiles.html")
    @ResponseBody
    public void uploadFiles(HttpServletResponse response, HttpServletRequest request,
                              @RequestParam (value = "file")MultipartFile file, ModelMap model)throws  Exception{
        String fileName=request.getParameter("fileName");
        String isPublic=request.getParameter("isPublic");
        User user=(User) request.getSession().getAttribute("user");
        PrintWriter out ;
        FileUpload fileUpload=new FileUpload();
        fileUpload.setProgressListener(new FileUploadListener(request));
        try {
            FTPClient ftp= FTPUtils.ftpConnect(ftpPath, ftpAddr, Integer.valueOf(ftpPort), ftpUsername, ftpPassword);
            if(ftp==null){
                out = response.getWriter();
                out.println("<script type='text/javascript'>alert('连接服务器失败');</script>");
                return ;
            }
            InputStream is= file.getInputStream();
            String name =file.getOriginalFilename();
            name=name.substring(name.lastIndexOf("."),name.length());
            fileName=(fileName==null||fileName.equals("")||fileName.equals("fileName"))?file.getOriginalFilename():fileName+name;
            FTPFile[] ftpFiles=ftp.listFiles(new String(fileName.getBytes("utf-8"),"iso-8859-1"));
           /* for (FTPFile ftpFile:ftpFiles){
                String ftpFileName=ftpFile.getName();
                ftpFileName=new String(ftpFileName.getBytes("iso-8859-1"),"utf-8");
                if(ftpFileName.equals(fileName)){
                    out = response.getWriter();
                    out.println("<script type='text/javascript'>alert('文件已存在或文件名重复');</script>");
                    return ;
                }
            }*/
            if(ftpFiles==null||ftpFiles.length>0){
                out = response.getWriter();
                out.println("<script type='text/javascript'>alert('file is exist');</script>");
                return ;
            }
            ftp.getCopyStreamListener();
            String dir=ftp.printWorkingDirectory();
            ResourceInfo resourceInfo=new ResourceInfo();
            resourceInfo.setName(fileName);
            resourceInfo.setPath(dir);
            resourceInfo.setType(file.getContentType());
            resourceInfo.setSize(file.getSize());
            resourceInfo.setUploadUser(user.getName());
            resourceInfo.setUserId(user.getId());
            if(ftp.storeFile(new String(fileName.getBytes("utf-8"),"iso-8859-1"),is)){
                resourceSrv.saveReourceInfo(resourceInfo);
            }
            is.close();
            out = response.getWriter();
            //out.println("<script type='text/javascript'>alert('上传成功');</script>");
            response.getOutputStream().write(file.getBytes());
        }catch (Exception e){
            log.error("upload error",e);
            out = response.getWriter();
//            out.println("<script type='text/javascript'>alert('上传失败');</script>");
        }

    }

    @RequestMapping("resources_list.do")
    public String getResources(HttpServletRequest request,HttpServletResponse response,ModelMap model){
        Integer no=Integer.valueOf(request.getParameter("no"));
        Integer pageSize=Integer.valueOf(request.getParameter("pageSize"));
        Page page = new Page();
        Integer totalSize=resourceSrv.getTotalSize();
        Integer totalPage=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        if(no==-1){
            no=totalPage;
        }
        page.setNo(no);
        page.setSize(pageSize);
        List<ResourceInfo> resourceInfoList=resourceSrv.getResources(page);
        page.setTotal(totalSize);
        page.setTotalPage(totalPage);
        model.put("resources",resourceInfoList);
        model.put("pagefn",page);
        return "/resource/resource_list";
    }

    @RequestMapping("getProcess.html")
    @ResponseBody
    public FileUploadInfo getProcess(HttpServletRequest request,HttpServletResponse response,ModelMap model)
    {
        return (FileUploadInfo)request.getSession().getAttribute("fileUploadInfo");
    }

    @RequestMapping(value = "downLoadFile.html")
    public ResponseEntity<byte[]> downLoadFile(HttpServletRequest request,HttpServletResponse response,ModelMap model){
        String fileName=request.getParameter("fileName");
        try {
            FTPClient ftp = FTPUtils.ftpConnect(ftpPath, ftpAddr, Integer.valueOf(ftpPort), ftpUsername, ftpPassword);
            if (ftp == null) {
                model.put("failed","连接服务器失败");
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            String realName=new String(fileName.getBytes("utf-8"),"iso-8859-1");
            FTPFile[] ftpFiles=ftp.listFiles(realName);
            if (ftpFiles==null||ftpFiles.length<=0){
                model.put("failed","文件不存在或已删除");
                return null;
            }
            String ftpFileName=ftpFiles[0].getName();

            InputStream in=ftp.retrieveFileStream(new String(realName.getBytes("utf-8"),"iso-8859-1"));

            ByteArrayOutputStream  out =new ByteArrayOutputStream();

            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                    out.write(buff, 0, rc);
                }
            byte[] in2b = out.toByteArray();

            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment",ftpFileName);
            return new ResponseEntity<byte[]>(in2b,headers, HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    /* public  static  void  main(String[] args) throws  Exception{
         HttpPost httpPost=new HttpPost("http://127.0.0.1:8080/knowledge/portal/knowledge/resource/ispublic");
         List<String> strings=new ArrayList<String>();
         strings.add("ads5-56asd");
         HttpClient httpClient=new DefaultHttpClient();
         httpClient.getParams().setParameter("resIds",strings);
         HttpResponse httpResponse=httpClient.execute(httpPost);
         String result=EntityUtils.toString(httpResponse.getEntity());
     }*/


}
