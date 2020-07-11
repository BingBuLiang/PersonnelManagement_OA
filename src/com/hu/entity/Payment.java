package com.hu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 胡冰
 * @version 1.0
 * 支出类
 **/

public class Payment implements Serializable {
    /**
     *支付编号  序列自增
     */
    private int pmId; 
    /**
     *支付人编号  财务
     */
    private String payEmpId; 
    /**
     *报销人员工编号
     */
    private String expEmpId; 
    /**
     *支付金额
     */
    private double amount; 
    /**
     *支付时间
     */
    private Date payTime; 
    /**
     *报销单编号
     */
    private int expId;
    /**
     * 支付人
     */
    private Employee payEmp;
    /**
     * 报销人
     */
    private Employee expEmp;
    /**
     * 报销单
     */
    private Expense exp;

    public Payment() {
    }
    public Payment(String payEmpId, String expEmpId, double amount,
                   Date payTime, int expId) {
        super();
        this.payEmpId = payEmpId;
        this.expEmpId = expEmpId;
        this.amount = amount;
        this.payTime = payTime;
        this.expId = expId;
    }


    public Payment(int pmId, String payEmpId, String expEmpId, double amount,
                   Date payTime, int expId) {
        super();
        this.pmId = pmId;
        this.payEmpId = payEmpId;
        this.expEmpId = expEmpId;
        this.amount = amount;
        this.payTime = payTime;
        this.expId = expId;
    }
    public Payment(int pmId, String payEmpId, String expEmpId, double amount, Date payTime, int expId, Employee payEmp, Employee expEmp, Expense exp) {
        this.pmId = pmId;
        this.payEmpId = payEmpId;
        this.expEmpId = expEmpId;
        this.amount = amount;
        this.payTime = payTime;
        this.expId = expId;
        this.payEmp = payEmp;
        this.expEmp = expEmp;
        this.exp = exp;
    }

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    public String getPayEmpId() {
        return payEmpId;
    }

    public void setPayEmpId(String payEmpId) {
        this.payEmpId = payEmpId;
    }

    public String getExpEmpId() {
        return expEmpId;
    }

    public void setExpEmpId(String expEmpId) {
        this.expEmpId = expEmpId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public Employee getPayEmp() {
        return payEmp;
    }

    public void setPayEmp(Employee payEmp) {
        this.payEmp = payEmp;
    }

    public Employee getExpEmp() {
        return expEmp;
    }

    public void setExpEmp(Employee expEmp) {
        this.expEmp = expEmp;
    }

    public Expense getExp() {
        return exp;
    }

    public void setExp(Expense exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pmId=" + pmId +
                ", payEmpId='" + payEmpId + '\'' +
                ", expEmpId='" + expEmpId + '\'' +
                ", amount=" + amount +
                ", payTime=" + payTime +
                ", expId=" + expId +
                ", payEmp=" + payEmp +
                ", expEmp=" + expEmp +
                ", exp=" + exp +
                '}';
    }
}