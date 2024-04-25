package controller;

import common.Result;
import pojo.SysSchedule;
import service.SysScheduleService;
import service.impl.SysScheduleServiceImpl;
import util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController{
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();


    //bug:NoSuchMethodException
    protected void finaAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求中的uid
        int uid = Integer.parseInt(req.getParameter("uid"));
        //通过uid获得对象
        List<SysSchedule> itemList = scheduleService.getScheduleById(uid);
        //将对象转为Result
        Map data = new HashMap();
        data.put("itemList",itemList);
        Result result = Result.ok(data);
        //Result以字符串的形式返回
        WebUtil.writeJson(resp,result);
    }

    /**
     * 新增日程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收传来的uid
        int uid = Integer.parseInt(req.getParameter("uid"));
        //向对应的用户中增加记录
        scheduleService.addDefault(uid);
        //以Result对象转化为JSON串的形式响应
        Result result = Result.ok(null);
        WebUtil.writeJson(resp,result);
    }

    /**
     * 保存修改后的日程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传来的JSON串
        SysSchedule schedule = WebUtil.readJson(req, SysSchedule.class);
        //调用服务端方法，更新数据库中的数据
        scheduleService.updateSchedule(schedule);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收sid
        int sid = Integer.parseInt(req.getParameter("sid"));
        //调用服务层方法，删除对应日程
        scheduleService.removeSchedule(sid);
        //响应成功
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
