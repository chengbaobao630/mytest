package cc.firstTest.myFilter;

import cc.firstTest.domain.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cheng on 2016/4/13 0013.
 */
@WebFilter(urlPatterns = "*.html")
public class CommonFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
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
        filterChain.doFilter(request,response);
    }
}
