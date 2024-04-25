package DAO;

import pojo.SysUser;

public interface SysUserDao {
    /**
     * 增加一条sys_user表中的记录
     * @param sysUser 要增加的username,userPwd封装的对象
     * @return 影响数据库的记录数
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 输入用户名
     * @return 用户名对应封装的SysUser对象，没有为空
     */
    SysUser findByUsername(String username);
}
