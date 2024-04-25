package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//出现bug,已改，tomcat server中Deployment directory最后应该是模块名，即demo06-cookie-session
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务端产生cookie,并返回给客户端
        //创建cookie
        Cookie cookie1 = new Cookie("keya","valuea");
        //设置cookie持久化时间5分钟
        //cookie1.setMaxAge(60*5);
        cookie1.setPath("/servletB");
        Cookie cookie2 = new Cookie("keyb","valueb");
        //将cookie放入响应报文
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
