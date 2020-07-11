package com.hu.util;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-07-11 10:20
 * @decription
 **/
public class Constants {
    //报销单的状态
    // 新创建
    public static final String EXPENSE_STATUS_NEW = "0";
    //审核中
    public static final String EXPENSE_STATUS_AUDITING = "1";
    //审核通过
    public static final String EXPENSE_STATUS_PASS = "2";
    //审核拒绝
    public static final String EXPENSE_STATUS_REJECT = "3";
    //审核打回
    public static final String EXPENSE_STATUS_BACK = "4";
    //已打款
    public static final String EXPENSE_STATUS_CASHED = "5";

    //特殊岗位的员工编号
    //CEO
    public static final String POSITION_CEOID= "yue";
    //CFO
    public static final String POSITION_CFOID= "hu";

}
