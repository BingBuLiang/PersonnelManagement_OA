package com.hu.service.impl;

import com.hu.dao.*;
import com.hu.dao.impl.*;
import com.hu.entity.*;
import com.hu.service.ExpenseService;
import com.hu.util.Constants;
import com.hu.util.JdbcUtil;
import com.hu.util.MyException;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-13 23:41
 * @decription
 **/
public class ExpenseServiceImpl implements ExpenseService {
    /**
     * 只提交了部分数据，数据不完整
     * 解决：将多个操作视为一个事务
     */
    @Override
    public void add(Expense expense) {
        //获取序列的下一个值，
        ExpenseDao expDao = new ExpenseDaoImpl();
        int expId = expDao.findExpId();
        //开启事务
        Connection conn = JdbcUtil.getConnection();
        try {
            //事务不再自动结束（提交，回滚），事务并没有在此开始
            conn.setAutoCommit(false);
            //添加一条报销单（主单）信息
            expense.setExpId(expId);
            //执行第一个DML操作，事务自动开始
            expDao.save(expense);

            //添加多条报销单所属的明细的信息
            ExpenseItemDao itemDao = new ExpenseItemDaoImpl();
            List<ExpenseItem> itemList = expense.getItemList();
            for(int i=0;i<itemList.size();i++){
                ExpenseItem item = itemList.get(i);
                item.setExpId(expId);
                itemDao.save(item);
            }

            ExpImageDao expImageDao=new ExpImageDaoImpl();
            ExpImage expImage=expense.getExpImage();
            expImage.setExpId(expId);
            expImageDao.save(expImage);

            //结束事务（提交或回滚）
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚数据
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new MyException(e1.toString());
            }
            //向上一层抛出异常信息
            throw new MyException(e.toString());

        }finally{
            JdbcUtil.closeAll(conn , null, null);

        }

    }

    @Override
    public List<Expense> findExp(String empId, String status, java.sql.Date expTime) {
        ExpenseDao expDao = new ExpenseDaoImpl();
        return expDao.findExp(empId,status,expTime);
    }

    @Override
    public List<Expense> getToAudit(String auditorId) {
        ExpenseDao expDao = new ExpenseDaoImpl();
        return expDao.findByAuditorId(auditorId);
    }

    @Override
    public void audit(Auditing auditing) {
        AuditingDao auditingDao = new AuditingDaoImpl();
        ExpenseDao expDao = new ExpenseDaoImpl();
        //开启事务
        Connection conn = JdbcUtil.getConnection();
        try {
            //事务不再自动结束（提交，回滚），事务并没有在此开始
            conn.setAutoCommit(false);
            //审核通过吗
            String result = auditing.getResult();

            Expense exp = new Expense();
            exp.setExpId(auditing.getExpId());
            exp.setLastResult(auditing.getResult());
//审核通过
            if("通过".equals(result)){
                //是财务吗
                //是财务
                if(auditing.getAuditor().getPosition().getPosId()==6){
                    //添加支出记录
                    Payment pm = new Payment();
                    Expense exp2 = expDao.findById(auditing.getExpId());
                    pm.setAmount(exp2.getTotalAmount());
                    pm.setExpEmpId(exp2.getEmpId());
                    pm.setExpId(auditing.getExpId());
                    //审核人  支出人
                    pm.setPayEmpId(auditing.getAuditor().getEmpId());
                    pm.setPayTime(new Date());

                    PaymentDao pmDao = new PaymentDaoImpl();
                    pmDao.save(pm);

                    //修改报销单状态
                    exp.setStatus(Constants.EXPENSE_STATUS_CASHED);
                    //审核结束
                    exp.setNextAuditorId(null);

                }else{

                    //金额大于2500吗  auditing.getExp().getTotalAmount()>2500  空指针异常
                    //获取报销单的金额
                    int expId = auditing.getExpId();
                    Expense exp2 = expDao.findById(expId);
                    //大于2500
                    if(exp2.getTotalAmount()>2500){
                        //当前审核人是总裁吗
                        if(Constants.POSITION_CEOID.equals(auditing.getAuditor().getEmpId())){
                            //添加审核记录
                            auditingDao.save(auditing);
                            //修改报销单状态
                            exp.setStatus(Constants.EXPENSE_STATUS_PASS);
                            //财务
                            exp.setNextAuditorId(Constants.POSITION_CFOID);
                        }else{
                            //添加审核记录
                            auditingDao.save(auditing);
                            //修改报销单状态
                            exp.setStatus(Constants.EXPENSE_STATUS_AUDITING);
                            //总裁
                            exp.setNextAuditorId(Constants.POSITION_CEOID);
                            //exp.setNextAuditorId(auditing.getAuditor().getMgr().getEmpId());

                        }
                    }else{//小于等于2500
                        //添加审核记录
                        auditingDao.save(auditing);
                        //修改报销单状态  下个处理人：财务  状态：审核通过
                        exp.setStatus(Constants.EXPENSE_STATUS_PASS);
                        //财务
                        exp.setNextAuditorId(Constants.POSITION_CFOID);
                    }
                }

            }else{//不通过，拒绝或者打回
                //添加审核记录
                auditingDao.save(auditing);
                //修改报销单状态
                if("打回".equals(auditing.getResult())){
                    exp.setStatus(Constants.EXPENSE_STATUS_BACK);
                }else{
                    exp.setStatus(Constants.EXPENSE_STATUS_REJECT);
                }
                //拒绝 打回 没有下个审核人
                exp.setNextAuditorId(null);

            }

            expDao.update(exp);
            //结束事务（提交或回滚）
            conn.commit();
        } catch (Exception e) {//!!! 所有异常，保存运行时异常，SQLSyntaxErrorException
            e.printStackTrace();
            try {
                conn.rollback(); //回滚数据
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new MyException(e1.toString());
            }
            throw new MyException(e.toString());//向上一层抛出异常信息

        }finally{
            JdbcUtil.closeAll(conn, null,null );
        }

    }


}
