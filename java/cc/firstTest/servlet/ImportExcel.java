package cc.firstTest.servlet;

import cc.firstTest.Service.LoginSrv;
import cc.firstTest.Utils.DateTool;
import cc.firstTest.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by cheng on 2016/4/15 0015.
 */
@WebServlet(name = "importExcel" , urlPatterns = "importUser.do")
@MultipartConfig()
public class ImportExcel extends HttpServlet {

    @Resource
    LoginSrv loginSrv;


    public  static Logger log= LoggerFactory.getLogger(ImportExcel.class);



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Part part=req.getPart("file");
        HSSFWorkbook workbook=new HSSFWorkbook(part.getInputStream());
        HSSFSheet sheet=workbook.getSheetAt(0);
        List<User> users= Arrays.asList();
        for (int i=1;i<sheet.getLastRowNum();i++){
            HSSFRow row=sheet.getRow(i);
            User user=createUserInfos(row);
            if (user!=null){
                users.add(user);
            }
        }
        try {
            loginSrv.addUsers(users);
        }catch (Exception e){
            log.error("import user error",e);
        }
        resp.sendRedirect("/myTest/welcome.html");
    }

    private User createUserInfos(HSSFRow row) {
        User user=new User();
        String[] values=null;
        for (int i=0;i<row.getLastCellNum();i++){
            HSSFCell cell=row.getCell(i);
            switch (cell.getCellType()){
                case HSSFCell.CELL_TYPE_STRING:
                    values[i]=cell.getStringCellValue().toString();
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        values[i] = DateTool.getDate(date);
                    } else {
                        values[i] = String.valueOf(cell.getNumericCellValue());
                    }
                    values[i]=String.valueOf(cell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    values[i]=String.valueOf(cell.getBooleanCellValue());
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    values[i]=cell.getCellFormula().toString();
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    values[i]="";
                    break;
                default:
                    values[i]=cell.toString();
            }
        }
        user.setId(UUID.randomUUID().toString());
        user.setName(values[0]);
        user.setAccount(values[1]);
        if (StringUtils.isNotBlank(values[1])){
            user.setPwd(values[1]);
        }else {
            return null;
        }
        if (StringUtils.isNotBlank(values[2])){
            user.setPwd(values[2]);
        }else{
            user.setPwd(values[1]);
        }
        user.setCreateDate(new Date());
        return user;

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
