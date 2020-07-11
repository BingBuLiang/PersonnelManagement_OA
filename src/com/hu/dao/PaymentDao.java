package com.hu.dao;

import com.hu.entity.Payment;

import java.util.List;


public interface PaymentDao {
    /**
     * 添加支付记录
     */
    public void save(Payment pm);
    /**
     * 查询支出统计数据
     */
    public List<Object[]> findStaticsData(int i);
}
