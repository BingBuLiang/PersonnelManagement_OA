package com.hu.service;

import com.hu.entity.Auditing;
import com.hu.entity.Expense;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-13 23:37
 * @decription
 **/
public interface ExpenseService {
    void  add(Expense expense);

    List<Expense> findExp(String empId, String status, java.sql.Date expTime);

    /**
     * 获取指定审核人要审核的报销单列表
     */
    List<Expense> getToAudit(String auditorId);


    /**
     * 审核报销单
     */
    void audit(Auditing auditing);

}
