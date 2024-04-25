package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取username的参数
        //在URI栏上传参，不要加空格
        String username = req.getParameter("username");
        //获取session对象
        //服务端根据name = JSESSIONID的cookie获得session
        HttpSession session = req.getSession();
        //将username传入session中
        session.setAttribute("username",username);
        System.out.println(session.getId());
        System.out.println(session.isNew());
        //存入成功
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
