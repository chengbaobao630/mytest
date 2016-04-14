package cc.firstTest.myInterceptor;

import cc.firstTest.domain.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cheng on 2016/4/13 0013.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User) request.getSession().getAttribute("user");
        String uri= request.getRequestURI();
        if (user==null&&
                !request.getRequestURI().endsWith("index.html")&&
                !request.getRequestURI().endsWith("login.html")){
            request.getRemoteUser();
            uri= request.getRequestURI();
            String query=request.getQueryString();
            response.sendRedirect(request.getContextPath()+"/index.html");
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
