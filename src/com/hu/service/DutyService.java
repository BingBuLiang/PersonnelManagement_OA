package com.hu.service;

import com.hu.entity.Duty;

import java.sql.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 19:07
 * @decription
 **/
public interface DutyService {
    /**
     * 完成签到操作
     */
    int signin(String empId);
    /**
     * 完成签退操作
     */
    int signout(String empId);
    /**
     * 查询符合条件的考勤信息
     */
    List<Duty> findDuty(String empId, int deptno, Date dtDate);
}
