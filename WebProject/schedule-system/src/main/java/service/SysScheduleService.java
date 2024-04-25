package service;

import pojo.SysSchedule;

import java.util.List;

public interface SysScheduleService {
    List<SysSchedule> getScheduleById(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
