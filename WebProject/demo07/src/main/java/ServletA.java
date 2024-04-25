import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向请求域存入数据
        req.setAttribute("request","requestMessage");
        //向会话域存入数据
        HttpSession session = req.getSession();
        session.setAttribute("session","sessionMessage");
        //向应用域域存入数据
        ServletContext application = getServletContext();
        application.setAttribute("application","applicationMessage");
    }
}
