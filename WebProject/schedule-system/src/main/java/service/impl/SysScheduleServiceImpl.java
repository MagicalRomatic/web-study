package service.impl;

import DAO.SysScheduleDao;
import DAO.impl.SysScheduleDaoImpl;
import pojo.SysSchedule;
import service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao scheduleDao = new SysScheduleDaoImpl();

    @Override
    public List<SysSchedule> getScheduleById(int uid) {
        return scheduleDao.getScheduleById(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return scheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return scheduleDao.removeSchedule(sid);
    }
}
