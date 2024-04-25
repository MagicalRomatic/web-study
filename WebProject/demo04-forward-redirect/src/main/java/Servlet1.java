import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*  重定向
        相对路径：与前端规则一致

        绝对路径 http://localhost:8080/
         */

        /*  请求转发
        相对路径写法一致
        req.getRequestDispatcher("servlet2").forward(req,resp);
        /d05/servlet2

        绝对路径不需要添加上下文路径
        /servlet2
*/


//客户端行为 地址栏变化 产生多次请求 多个request对象 目标资源可以是视图资源 不可以是WEB-INF 可以外部资源
//页面跳转优先重定向
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户请求
        System.out.println("Servlet1 执行了");

        //响应重定向     设置及状态码302 同时设置location响应头
        resp.sendRedirect("servlet2");


    }
}
