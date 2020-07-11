package com.hu.dao;

import com.hu.entity.ExpenseItem;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:41
 * @decription
 **/
public interface ExpenseItemDao {
    /**
     * 保存报销单明细
     */
    void save(ExpenseItem item);
}
