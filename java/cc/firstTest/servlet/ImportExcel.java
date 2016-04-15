package cc.firstTest.servlet;

import cc.firstTest.Service.LoginSrv;
import cc.firstTest.Utils.DateTool;
import cc.firstTest.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by cheng on 2016/4/15 0015.
 */
@Controller
public class ImportExcel {

    @Resource
    LoginSrv loginSrv;


    public  static Logger log= LoggerFactory.getLogger(ImportExcel.class);



    @RequestMapping(value = "/importUser.do",method = RequestMethod.POST)
    protected void importUser(
            @RequestParam(value = "file")MultipartFile file,
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet=workbook.getSheetAt(0);
        List<User> users= new ArrayList<>();
        for (int i=1;i<sheet.getLastRowNum();i++){
            XSSFRow row=sheet.getRow(i);
            User user=new User();
            if(row!=null){
                user=createUserInfos(row);
            }

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

    private User createUserInfos(XSSFRow row) {
        User user=new User();
        String[] values=new String[3];
        if (row==null){
            return null;
        }
        for (int i=0;i<row.getLastCellNum();i++){
            XSSFCell cell=row.getCell(i);
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


}
