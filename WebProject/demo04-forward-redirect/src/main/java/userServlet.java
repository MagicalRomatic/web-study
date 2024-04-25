import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class userServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应体使用UTF-8编码
        resp.setCharacterEncoding("UTF-8");
        //设置Content-Type响应头，告诉客户端用UTF-8解码
        resp.setContentType("text/html;charset=UTF-8");

        //向客户端响应一些文字
        resp.getWriter().write("你好 hello");
    }
}
