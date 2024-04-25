package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode()+"应用域被初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode()+"应用域被销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode()+"应用域新增了"+name+":"+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode()+"应用域减少了"+name+":"+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue(); //拿到的是旧的值
        Object newValue = application.getAttribute(name);
        System.out.println(application.hashCode()+"应用域"+name+"键值由"+value+"替换为"+newValue);
    }
}
