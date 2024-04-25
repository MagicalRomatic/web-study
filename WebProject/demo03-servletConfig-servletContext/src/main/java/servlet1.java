import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---------ServletConfig参数----------");
        //获取servlet配置参数
        ServletConfig config = this.getServletConfig();
        //根据参数名获取参数值
        String keya = config.getInitParameter("keya");
        System.out.println("kaya:"+keya);

        //获取所有初始参数的名字 Enumeration相当于iterator
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //hasMoreElements 1.判断有没有下一个参数    有则返回true，没有返回false
        //nextElement     2.取出下一个元素         移动游标
        while(initParameterNames.hasMoreElements()){
            String pName = initParameterNames.nextElement();
            System.out.println("pValue=" + getInitParameter(pName));
        }

        System.out.println("-------ServletContext参数-------");
        //利用ServletConfig调用ServletContext,继承GenericServlet
        ServletContext context = config.getServletContext();

        String name = context.getInitParameter("encoding");
        System.out.println("encoding"+"="+name);

        Enumeration<String> pNames = context.getInitParameterNames();
        while (pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            System.out.println(pName +"="+ context.getInitParameter(pName));
        }
    }
}
