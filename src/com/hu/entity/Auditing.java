package com.hu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:10
 * @decription 审核类
 **/
public class Auditing implements Serializable {

    private int auditId;
    private int expId;
    private String empId;
    /**
     * 审核结果   通过   打回  拒绝
     */
    private String result;
    /**
     * 审核意见
     */
    private String auditDesc;
    /**
     * 审核人
     */
    private Employee auditor;
    /**
     * 报销单
     */
    private Expense exp;
    private Date auditTime;

    public Auditing() {
        super();
    }


    public Auditing(int expId, String result, String auditDesc,
                    Employee auditor, Date auditTime) {
        super();
        this.expId = expId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.auditor = auditor;
        this.auditTime = auditTime;
    }


    public Auditing(int auditId, int expId, String empId, String result,
                    String auditDesc, Employee auditor, Expense exp, Date auditTime) {
        super();
        this.auditId = auditId;
        this.expId = expId;
        this.empId = empId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.auditor = auditor;
        this.exp = exp;
        this.auditTime = auditTime;
    }


    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public Employee getAuditor() {
        return auditor;
    }

    public void setAuditor(Employee auditor) {
        this.auditor = auditor;
    }

    public Expense getExp() {
        return exp;
    }

    public void setExp(Expense exp) {
        this.exp = exp;
    }


    public Date getAuditTime() {
        return auditTime;
    }


    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "Auditing{" +
                "auditId=" + auditId +
                ", expId=" + expId +
                ", empId='" + empId + '\'' +
                ", result='" + result + '\'' +
                ", auditDesc='" + auditDesc + '\'' +
                ", auditor=" + auditor +
                ", exp=" + exp +
                ", auditTime=" + auditTime +
                '}';
    }
}
