package com.hu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 21:53
 * @decription 报销单
 **/
public class Expense implements Serializable {
    /**
     * 报销单编号  序列自增
     */

    private int expId;
    private String empId;
    private double totalAmount;
    private Date expTime;
    /**
     * 报销单总备注信息
     */
    private String expDesc;
    /**
     * 下一个审核人的编号
     */
    private String nextAuditorId;
    /**
     * 最新的审核结果
     */
    private String lastResult;
    /**
     * 报销单的状态     0：新创建  1：审核中   2 审核结束通过  3 审核拒绝  4 审核打回   5.已打款
     * }
     */
    private String status;
    /**
     * 该报销单的所有明细信息
     */
    private List<ExpenseItem> itemList = new ArrayList<ExpenseItem>();
    /**
     * 该报销单的图片明细
     */
    private ExpImage expImage;


    /**
     * 报销人  查询时使用
     */
    private Employee emp;
    /**
     * 下一个审核人
     */
    private Employee nextAuditor;


    public Expense() {
        super();
    }


    public Expense(String empId, double totalAmount, Date expTime,
                   String expDesc, String nextAuditorId, String lastResult,
                   String status) {
        super();
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditorId = nextAuditorId;
        this.lastResult = lastResult;
        this.status = status;
    }

    public Expense(int expId, String empId, double totalAmount,
                   Date expTime, String expDesc, String nextAuditorId,
                   String lastResult, String status) {
        this.expId = expId;
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditorId = nextAuditorId;
        this.lastResult = lastResult;
        this.status = status;
    }

    public Expense(int expId, String empId, double totalAmount, Date expTime,
                   String expDesc, String nextAuditorId, String lastResult,
                   String status, Employee emp, Employee nextAuditor) {
        super();
        this.expId = expId;
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditorId = nextAuditorId;
        this.lastResult = lastResult;
        this.status = status;
        this.emp = emp;
        this.nextAuditor = nextAuditor;
    }

    public Expense(String empId, double totalAmount, Date expTime, String expDesc,
                   String nextAuditorId, String lastResult, String status,
                   List<ExpenseItem> itemList, ExpImage expImage) {
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditorId = nextAuditorId;
        this.lastResult = lastResult;
        this.status = status;
        this.itemList = itemList;
        this.expImage = expImage;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }

    public String getNextAuditorId() {
        return nextAuditorId;
    }

    public void setNextAuditorId(String nextAuditorId) {
        this.nextAuditorId = nextAuditorId;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Employee getNextAuditor() {
        return nextAuditor;
    }

    public void setNextAuditor(Employee nextAuditor) {
        this.nextAuditor = nextAuditor;
    }

    public ExpImage getExpImage() {
        return expImage;
    }

    public void setExpImage(ExpImage expImage) {
        this.expImage = expImage;
    }

    public List<ExpenseItem> getItemList() {
        return itemList;
    }


    public void setItemList(List<ExpenseItem> itemList) {
        this.itemList = itemList;
    }


    @Override
    public String toString() {
        return "Expense [expId=" + expId + ", empId=" + empId
                + ", totalAmount=" + totalAmount + ", expTime=" + expTime
                + ", expDesc=" + expDesc + ", nextAuditorId=" + nextAuditorId
                + ", lastResult=" + lastResult + ", status=" + status
                + ", emp=" + emp + ", nextAuditor=" + nextAuditor + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Expense)) {
            return false;
        }
        Expense expense = (Expense) o;
        return getExpId() == expense.getExpId() &&
                Double.compare(expense.getTotalAmount(), getTotalAmount()) == 0 &&
                Objects.equals(getEmpId(), expense.getEmpId()) &&
                Objects.equals(getExpTime(), expense.getExpTime()) &&
                Objects.equals(getExpDesc(), expense.getExpDesc()) &&
                Objects.equals(getNextAuditorId(), expense.getNextAuditorId()) &&
                Objects.equals(getLastResult(), expense.getLastResult()) &&
                Objects.equals(getStatus(), expense.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExpId(), getEmpId(), getTotalAmount(), getExpTime(), getExpDesc(), getNextAuditorId(), getLastResult(), getStatus());
    }
}