
/*
* idea会从tomcat的安装目录(catalina_home)复制配置文件到工作目录(catalina_base)。
* tomcat在启动web应用时会在工作目录(catalina_base)读取需要的配置以及输出log日志信息。
* */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //获得一个指向项目部署的文件/目录的磁盘真实路径
        String path = servletContext.getRealPath("upload");
        System.out.println(path);

        //获取项目的上下文路径 项目的访问路径 /demo03
        String contextPath = servletContext.getContextPath();
    }
}
