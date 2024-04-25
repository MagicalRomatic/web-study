package service;

import pojo.SysUser;

//没法登录与注册

/**
 * 以sys_user表格为核心的相关业务逻辑
 */
public interface SysUserService {
    /**
     * 注册新用户的业务
     * @param sysUser 对用户名和明文密码进行封装的SysUser对象
     * @return 影响数据库的行数
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 输入用户名
     * @return 用户名对应封装的SysUser对象，没有为空
     */
    SysUser findByUsername(String username);
}
