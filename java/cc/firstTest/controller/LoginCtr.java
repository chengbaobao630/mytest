package cc.firstTest.controller;

import cc.firstTest.Service.AccountCaptchaService;
import cc.firstTest.Service.LoginSrv;
import cc.firstTest.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 2015/12/2 0002.
 */
@Controller("/")
public class LoginCtr {
    public static Log log= LogFactory.getLog(LoginCtr.class);

    @Resource
    LoginSrv loginSrv;

    @Resource
    AccountCaptchaService captchaService;

    @RequestMapping(value = "index.html")
    public  String toIndex(){
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "login.html")
    public  String sslogin(HttpServletRequest request, HttpServletResponse response,ModelMap model){
       String name=request.getParameter("account");
        String pass=request.getParameter("password");
        User user=loginSrv.isExist(name,pass);
        if (user!=null) {
            request.getSession().setAttribute("user",user);
            return "redirect:/welcome.html";
        }else{
            return "forward:index.html?form=signUp&login=false";
        }
    }

    @RequestMapping(value = "logout.html")
    public  String logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().invalidate();
        return "redirect:/index.jsp";
    }


    @RequestMapping(value = "welcome.html")
    public  String welcome(HttpServletRequest request, HttpServletResponse response){
        return "welcome";
    }

    @RequestMapping(value = "verifyAccount.html")
    @ResponseBody
    public Map verifyAccount(HttpServletRequest request, HttpServletResponse response){
        String account=request.getParameter("account");
        Boolean countIsExist=!loginSrv.accountIsExist(account);
        Map<String,Boolean> result=new HashMap<>();
        result.put("valid",countIsExist);
        return result;
    }
    @RequestMapping(value = "verifyCaptcha.html")
    @ResponseBody
    public Map verifyCaptcha(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        String captchaValue=request.getParameter("captcha");
        String captchaKey="";
        for(Cookie cookie:request.getCookies()){
            if(cookie.getName().equals("captchaKey"))
                captchaKey=cookie.getValue();
        }
        Map<String,Boolean> result=new HashMap<>();
        result.put("valid", captchaService.vilidateCaptcha(captchaKey,captchaValue));
        return result;
    }

    @RequestMapping(value = "toSign.html")
    public String signUp(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String account=request.getParameter("account4sign");
        String pwd=request.getParameter("conform_password4sign");
        String name=request.getParameter("name4sign");
        User user=new User();
        user.setAccount(account);
        user.setName(name);
        user.setPwd(pwd);
        try {
            loginSrv.addUser(user);
            model.put("signSuc",true);

        }catch (Exception e){
            model.put("signSuc",false);
        }
        return "redirect:/index.html?form=signUp";
    }

    @RequestMapping(value = "index.html",params = "form=signUp")
    public String toSign(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String signSuc=request.getParameter("signSuc");
        String login=request.getParameter("login");
        if(signSuc!=null) {
            model.put("signSuc", signSuc);
        }
        if(login!=null){
            model.put("login", login);
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "getCaptchaImg.do")
    public void getCaptchaImg(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        try {
            String key = captchaService.generateCaptchaKey();
            Cookie cookie=new Cookie("captchaKey",key);
            response.addCookie(cookie);
            byte[] img= captchaService.generateCaptchaImage(key);
            response.getOutputStream().write(img);
        }catch (Exception e){
            log.error("getCaptchaImg error",e);
        }
    }


}
