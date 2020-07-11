package com.hu.dao;

import com.hu.entity.Expense;

import java.sql.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:42
 * @decription
 **/
public interface ExpenseDao {
    /**
     * 保存报销单
     */
    void save(Expense expense);

    /**
     * 查询指定审核人要审核的报销单
     */
    List<Expense> findByAuditorId(String auditorId);

    /**
     * 修改报销单
     */
    void update(Expense expense);
    /**
     * 按照编号查询报销单
     */
    Expense findById(int expId);

    /**
     *获取自增的 expId
     */
    int findExpId();

    /**
     * 查询指定审核人要审核的报销单
     */
    List<Expense> findExp(String empId, String status, Date expTime);
}
