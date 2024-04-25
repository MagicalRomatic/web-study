package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志的过滤    将记录打印在控制台
 *
 * 1 实现Filter接口
 * 2 重写过滤方法
 * 3 配置过滤器
 *  web.xml
 *  注解
 */
public class LoggingFilter implements Filter {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //在到达请求资源之前做的检验
        //打印***在yyyy-MM-dd HH:mm:ss被过滤
        String requestURI = request.getRequestURI();
        String dateTime = dateFormat.format(new Date());
        String beforeLogging = requestURI+"在"+dateTime+"被过滤";
        System.out.println(beforeLogging);
        long t1 = System.currentTimeMillis();

        //放行目标文件
        filterChain.doFilter(servletRequest,servletResponse);
        long t2 = System.currentTimeMillis();

        //在响应之前进行过滤 转化为响应报文之前的
        //打印 ***资源在 date 请求耗费 --- 毫秒
        String afterLogging = requestURI+"资源在"+dateTime+"请求耗费"+(t2-t1)+"毫秒";
        System.out.println(afterLogging);
    }
}
