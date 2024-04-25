import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/s1")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 从request对象中获取请求的任何信息
        String username = request.getParameter("username"); //根据参数名获取参数值

        //2 处理业务的代码
        String info = "YES";
        if("atguigu".equals(username)){
            info = "NO";
        }

        //3 将要响应的数据放入response
        //应该设置Content-Type响应头
        //response.setHeader("Content-Type", "text/html");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();  //该方法返回的是一个向响应体中打印字符串的打印流
        writer.write(info);



    }
}
