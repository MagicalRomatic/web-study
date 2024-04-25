package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务端接收客户端发送请求其中携带的cookie
        Cookie[] cookies = req.getCookies();

        if(null != cookies){
            for (Cookie cookie:
                 cookies) {
                System.out.println(cookie.getName()+"="+cookie.getValue());
            }
        }

    }
}
