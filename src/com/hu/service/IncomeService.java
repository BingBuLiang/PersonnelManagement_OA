package com.hu.service;

/**
 * @author 胡冰
 * @version 1.0
 **/
public interface IncomeService {
    /**
     * 返回收入的柱状图数据
     */
    String getBarData();

    /**
     * 返回支出的饼图数据
     */
    String getPieData(int i);

}
