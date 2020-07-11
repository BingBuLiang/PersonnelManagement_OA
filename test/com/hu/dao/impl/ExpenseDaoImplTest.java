package com.hu.dao.impl;

import com.hu.dao.ExpenseDao;
import com.hu.entity.Expense;
import com.hu.entity.ExpenseItem;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-13 22:57
 * @decription
 **/
class ExpenseDaoImplTest {

    @Ignore
    @Test
    void findExpId() {
        ExpenseDao expenseDao = new ExpenseDaoImpl();
        int expId = expenseDao.findExpId();
        System.out.println(expId);

    }

    @Test
    void findExp() {
        ExpenseDao expenseDao = new ExpenseDaoImpl();
        List<Expense> expenseList = expenseDao.findExp("张三丰", "", null);

        /*for(Expense expense:expenseList){
//            System.out.println(expense.getStatus());
            for(ExpenseItem item:expense.getItemList()){
                System.out.println(item.getAmount());
            }
        }*/
        System.out.println(expenseList.get(0));

    }
    /**
     * Expense [expId=1, empId=张三丰, totalAmount=1110.0, expTime=2019-01-01, expDesc=总备注信息,
     * nextAuditorId=hu, lastResult=处理完, status=5, emp=null, nextAuditor=null]
     *
     *
     * Expense [expId=1, empId=张三丰, totalAmount=1110.0, expTime=2019-01-01, expDesc=总备注信息,
     * nextAuditorId=hu, lastResult=处理完, status=5,
     * emp=Employee [empId=张三丰, password=null, realName=张三, sex=null, birthDate=null, hireDate=null,
     * leaveDate=null, onDuty=0, empType=0, phone=null, qq=null,
     * emerContactPerson=null, idCard=null, dept=null,
     * position=null, mgr=null, empList=[]], nextAuditor=null]
     */
    @Test
    void findByAuditorId() {
        ExpenseDao expenseDao = new ExpenseDaoImpl();
        List<Expense> expenseList = expenseDao.findByAuditorId("hu");
        System.out.println(expenseList.get(0));
    }

    @Test
    void findById() {
        ExpenseDao expenseDao = new ExpenseDaoImpl();
        Expense expense = expenseDao.findById(1);
        System.out.println(expense);
    }
}