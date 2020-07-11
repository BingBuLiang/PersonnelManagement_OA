package com.hu.service.impl;

import com.hu.dao.DutyDao;
import com.hu.dao.impl.DutyDaoImpl;
import com.hu.entity.Duty;
import com.hu.service.DutyService;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 19:09
 * @decription
 **/
public class DutyServiceImpl implements DutyService {
    private DutyDao dutyDao = new DutyDaoImpl();
    @Override
    public int signin(String empId) {
        //判断用户是否已经签到
        Date now = new Date();
        java.sql.Date today = new java.sql.Date(now.getTime());
        boolean flag = dutyDao.find(empId,today);

        //如果已经签到，返回2；如果没有签到，进行签到
        int n=0;
        //已经签到
        if(flag){
            return  2;
        }else{
            //完成签到
            Duty duty = new Duty();
            //员工编号
            duty.setEmpId(empId);
            duty.setDtDate(today);
            DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String signinTime = sdf.format(now);
            duty.setSigninTime(signinTime);
            n = dutyDao.singin(duty);
            return n;
        }
    }

    @Override
    public int signout(String empId) {
        //判断用户是否已经签到
        Date now = new Date();
        java.sql.Date today = new java.sql.Date(now.getTime());
        boolean flag = dutyDao.find(empId,today);

        //如果已经签到，返回2；如果没有签到，进行签到
        int n=0;
        //尚未签到
        if(!flag){
            return  2;
        }else{
            //完成签退
            Duty duty = new Duty();
            //员工编号
            duty.setEmpId(empId);
            duty.setDtDate(today);
            DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String signoutTime = sdf.format(now);
            duty.setSignoutTime(signoutTime);

            n = dutyDao.singout(duty);
            return n;
        }
    }

    @Override
    public List<Duty> findDuty(String empId, int deptno, java.sql.Date  dtDate) {
        return this.dutyDao.find(empId, deptno,dtDate);
    }
}
