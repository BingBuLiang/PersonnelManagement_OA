package com.hu.dao;

import com.hu.entity.Duty;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:31
 * @decription 考勤管理
 **/
public interface DutyDao {
    /**
     * 查询考勤信息
     * @param empId 员工编号
     * @param deptno 部门编号
     * @param dtDate 考勤日期
     * @return 考勤列表
     */
    List<Duty> find(String empId, int deptno, java.sql.Date dtDate);
    /**
     * 查询考勤信息
     * @param empId 员工编号
     * @param today  考勤日期
     * @return find
     */
    boolean find(String empId, java.sql.Date today);
    /**
     * 添加考勤信息
     * 签到
     */
    int singin(Duty duty);
    /**
     * 更新考勤数据
     * 签退
     */
    int singout(Duty duty);

}
