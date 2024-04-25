package DAO;

import pojo.SysSchedule;

import java.util.List;

/**
 * dao包封装CRUD的具体功能
 */
public interface SysScheduleDao {
    /**
     * 用于向数据中增加一条记录
     * @param schedule 日程实体类对象
     * @return 返回影响数据库的记录数，大于0则修改成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 用于找出所有的日程
     * @return 用户的所有日程
     */
    List<SysSchedule> findAll();

    List<SysSchedule> getScheduleById(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
