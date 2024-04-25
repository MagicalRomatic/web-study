package service.impl;

import DAO.SysUserDao;
import DAO.impl.SysUserDaoImpl;
import pojo.SysUser;
import service.SysUserService;
import util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        //将明文密码加密成密文
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        //在数据库上新增用户的信息
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
