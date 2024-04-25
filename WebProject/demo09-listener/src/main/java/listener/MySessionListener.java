package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //会话域对象创建时调用
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //会话域对象销毁时调用
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //监听会话域中数据的增加
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        //监听会话域中数据的移除
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        //监听会话域中数据的替换
    }
}
