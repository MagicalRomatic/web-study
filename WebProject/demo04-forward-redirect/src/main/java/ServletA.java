import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//目标资源不能是项目以外的资源
//请求转发可以请求静态资源
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletA 执行了");

        //请求转发的req,resp为同一个对象
        String money = req.getParameter("money");
        System.out.println("获得参数money=" + money);

        //请求转发给ServletB
        //获得请求转发器
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
        //让请求转发器做出动作
        //requestDispatcher.forward(req, resp);

        //一个实例 利用请求转发访问WEB-INF里的b.html,之后b.html引用图片
        req.getRequestDispatcher("/WEB-INF/b.html").forward(req,resp);
    }
}
