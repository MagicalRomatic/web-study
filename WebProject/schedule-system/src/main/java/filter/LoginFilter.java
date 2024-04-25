package filter;

import pojo.SysUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * bug
 * .html 404
 */
//@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获得session对象
        HttpSession session = request.getSession();
        //从session中查看对象
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");

        //如果对象为空，未登录，转到登录页
        if(null == sysUser){
            response.sendRedirect("/login.html");
        }else {
            //不为空，放行
            filterChain.doFilter(request,response);
        }

    }
}
