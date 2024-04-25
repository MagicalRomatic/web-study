package test;

import DAO.BaseDao;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.SysUser;

import java.util.List;

public class TestBaseDao {

    private static BaseDao baseDao;

    @BeforeClass
    public static void  initBaseDao(){
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject(){
        //BaseQueryObject()查询单行 单列 一个数值的方法
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery(){
        String sql = "select uid,user_pwd as userPwd,username from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int row = baseDao.baseUpdate(sql, 1, "学习JAVA", 0);
        System.out.println(row);
    }



}
