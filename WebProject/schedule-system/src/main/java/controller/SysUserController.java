package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Result;
import common.ResultCodeEnum;
import pojo.SysUser;
import service.SysUserService;
import service.impl.SysUserServiceImpl;
import util.MD5Util;
import util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 以sys_user表为核心的业务逻辑
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController{
    private SysUserService userService = new SysUserServiceImpl();
    /**
     * 接受用户注册业务的处理方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取注册所用的参数
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        //实现注册的方法
        //将参数封装进SysUser对象，调用service方法
        int rows = userService.regist(sysUser);
        Result result = Result.ok(null);
        //注册成功或失败后进行页面的跳转
        if(rows<1){
            //失败了
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        //将最终的响应状态返回
        WebUtil.writeJson(resp,result);
    }

    /**
     * 接收输入的用户名，校验是否已经注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户名
        String username = req.getParameter("username");
        //调用服务层方法，查找是否已经占用
        SysUser sysUser = userService.findByUsername(username);

        //没有找到，返回可用
        Result result = Result.ok(null);
        if(null != sysUser){
            //已经注册，返回已占用
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 接受用户登录请求，完成登录的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户名和密码
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        //调用服务层方法，检查用户名是否相同
        SysUser user = userService.findByUsername(sysUser.getUsername());
        Result result = null;
        if(null == user){
            //没有找到用户名
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }else if(! MD5Util.encrypt(sysUser.getUserPwd()).equals(user.getUserPwd())){
            result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }else{
            //登录成功，需要将用户信息响应给客户端
            Map data = new HashMap();
            user.setUserPwd(" ");
            data.put("loginUser",user);
            result = Result.ok(data);
        }

        WebUtil.writeJson(resp,result);
    }
}
