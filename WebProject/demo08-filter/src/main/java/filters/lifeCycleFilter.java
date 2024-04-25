package filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filter的生命周期
 * 1 构造
 * 2 初始化
 * 3 过滤
 * 4 销毁
 */
public class lifeCycleFilter implements Filter {
    public lifeCycleFilter(){
        System.out.println("构造");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
        System.out.println(filterConfig.getInitParameter("dateTimeParameter"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
