package DAO.impl;

import DAO.BaseDao;
import DAO.SysUserDao;
import pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        int rows = baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
        return rows;
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username=?";
        List<SysUser> userList = baseQuery(SysUser.class, sql, username);
        return userList!=null && userList.size()>0 ? userList.get(0):null;
    }
}
