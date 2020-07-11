package com.hu.dao.impl;

import com.hu.dao.ExpenseItemDao;
import com.hu.entity.ExpenseItem;
import com.hu.util.JdbcUtil;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:49
 * @decription
 **/
public class ExpenseItemDaoImpl  implements ExpenseItemDao {

    @Override
    public void save(ExpenseItem item) {
        String sql = "insert into expenseitem values(default,?,?,?,?)";
        Object [] params ={item.getExpId(),item.getType(),item.getAmount(),item.getItemDesc()};
        JdbcUtil.executeUpdate(sql, params);

    }

}
