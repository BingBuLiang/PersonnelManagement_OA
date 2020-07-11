package com.hu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:23
 * @decription 考勤类
 **/
public class Duty implements Serializable {
    private int dtID;

    private Date dtDate;
    /**
     * 签到
     */
    private String signinTime;
    /**
     * 签退
     */
    private String signoutTime;
    /**
     * 可以同时提供id和对象属性
     */
    private String empId;
    /**
     * 员工的信息
     */
    private Employee emp;

    public Duty() {
        super();
    }


    public Duty(Date dtDate, String signinTime, String signoutTime, String empId) {
        super();
        this.dtDate = dtDate;
        this.signinTime = signinTime;
        this.signoutTime = signoutTime;
        this.empId = empId;
    }


    public Duty(int dtID, Date dtDate, String signinTime, String signoutTime,
                Employee emp) {
        super();
        this.dtID = dtID;
        this.dtDate = dtDate;
        this.signinTime = signinTime;
        this.signoutTime = signoutTime;
        this.emp = emp;
    }

    public int getDtID() {
        return dtID;
    }
    public void setDtID(int dtID) {
        this.dtID = dtID;
    }
    public Date getDtDate() {
        return dtDate;
    }
    public void setDtDate(Date dtDate) {
        this.dtDate = dtDate;
    }
    public String getSigninTime() {
        return signinTime;
    }
    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime;
    }
    public String getSignoutTime() {
        return signoutTime;
    }
    public void setSignoutTime(String signoutTime) {
        this.signoutTime = signoutTime;
    }
    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public Employee getEmp() {
        return emp;
    }
    public void setEmp(Employee emp) {
        this.emp = emp;
    }


    @Override
    public String toString() {
        return "Duty [dtID=" + dtID + ", dtDate=" + dtDate + ", signinTime="
                + signinTime + ", signoutTime=" + signoutTime + ", empId="
                + empId + ", emp=" + emp + "]";
    }

}
