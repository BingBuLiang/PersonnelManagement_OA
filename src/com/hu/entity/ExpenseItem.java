package com.hu.entity;

import java.io.Serializable;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:07
 * @decription 报销单明细
 **/
public class ExpenseItem implements Serializable {
    /**
     * 自增
     */
    private int itemId;
    /**
     * 所属报销单的编号
     */
    private int expId;
    private String type;
    private double amount;
    /**
     * 明细说明
     */
    private String itemDesc;

    /**
     * 报销单
     */
    private Expense expense;

    public ExpenseItem() {
        super();
    }


    public ExpenseItem(String type, double amount, String itemDesc) {
        super();
        this.type = type;
        this.amount = amount;
        this.itemDesc = itemDesc;
    }


    public ExpenseItem(int expId, String type, double amount, String itemDesc) {
        super();
        this.expId = expId;
        this.type = type;
        this.amount = amount;
        this.itemDesc = itemDesc;
    }


    public ExpenseItem(int itemId, int expId, String type, double amount,
                       String itemDesc, Expense expense) {
        super();
        this.itemId = itemId;
        this.expId = expId;
        this.type = type;
        this.amount = amount;
        this.itemDesc = itemDesc;
        this.expense = expense;
    }





    public int getItemId() {
        return itemId;
    }


    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public int getExpId() {
        return expId;
    }


    public void setExpId(int expId) {
        this.expId = expId;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getItemDesc() {
        return itemDesc;
    }


    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }


    public Expense getExpense() {
        return expense;
    }


    public void setExpense(Expense expense) {
        this.expense = expense;
    }


    @Override
    public String toString() {
        return "ExpenseItem [itemId=" + itemId + ", expId=" + expId + ", type="
                + type + ", amount=" + amount + ", itemDesc=" + itemDesc
                + ", expense=" + expense + "]";
    }

}
