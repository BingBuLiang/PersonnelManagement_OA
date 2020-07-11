package com.hu.dao.impl;

import com.hu.dao.ExpenseDao;
import com.hu.entity.Employee;
import com.hu.entity.ExpImage;
import com.hu.entity.Expense;
import com.hu.entity.ExpenseItem;
import com.hu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:55
 * @decription
 **/
public class ExpenseDaoImpl implements ExpenseDao {
    @Override
    public void save(Expense expense) {
        String sql = "insert into expense values(?,?,?,?,?,?,?,?)";
        Object[] params = {expense.getExpId(), expense.getEmpId(), expense.getTotalAmount(),
                new java.sql.Date(expense.getExpTime().getTime()), expense.getExpDesc(), expense.getNextAuditorId(),
                expense.getLastResult(), expense.getStatus()};
        JdbcUtil.executeUpdate(sql, params);

    }

    /**
     * 此处简写了，仅仅为审核功能而写
     * 如果具体点儿。可以结合 findExp() 方法
     */
    @Override
    public List<Expense> findByAuditorId(String auditorId) {
        String sql = " select exp.* ,emp.realName  " +
                " from expense exp , employee emp " +
                " where exp.empid = emp.empid  " +
                " and nextauditor = ? ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Expense> list = new ArrayList<Expense>();
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, auditorId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int expId = rs.getInt("expId");
                String empId = rs.getString("empId");
                double totalAmount = rs.getDouble("totalAmount");
                Date expTime = rs.getDate("expTime");
                String expDesc = rs.getString("expDesc");
                String nextAuditorId = auditorId;
                String lastResult = rs.getString("lastResult");
                String status = rs.getString("status");
                String realName = rs.getString("realName");
                Employee emp = new Employee();
                emp.setEmpId(empId);
                emp.setRealName(realName);
                Expense exp = new Expense(expId, empId, totalAmount, expTime, expDesc, nextAuditorId, lastResult, status, emp, null);
                list.add(exp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(conn, pstmt, rs);
        }

        return list;
    }

    @Override
    public void update(Expense expense) {
        String sql = "update expense set nextauditor = ?,lastresult=?,status =? where expid=?";
        Object params[] = {expense.getNextAuditorId(), expense.getLastResult(), expense.getStatus(), expense.getExpId()};
        JdbcUtil.executeUpdate(sql, params);

    }

    @Override
    public Expense findById(int expId) {
        String sql = "select * from expense where expId = ?";
        Object[] params = {expId};
        List<Map<String, Object>> maps = JdbcUtil.executeQuery(sql, params);
        if (maps.size() == 0) {
            return null;
        }
        Map<String, Object> map = maps.get(0);
        Expense exp = new Expense();
        exp.setExpId(expId);
        map.forEach((key, value) -> {
            if ("empId".equalsIgnoreCase(key)) {
                exp.setEmpId((String) value);
            }
            if ("totalAmount".equalsIgnoreCase(key)) {
                exp.setTotalAmount((Double)value);
            }
            if ("expTime".equalsIgnoreCase(key)) {
                exp.setExpTime((Date) value);
            }
            if ("expDesc".equalsIgnoreCase(key)) {
                exp.setExpDesc((String) value);
            }
            if ("nextAuditor".equalsIgnoreCase(key)) {
                exp.setNextAuditorId((String) value);
            }
            if ("lastResult".equalsIgnoreCase(key)) {
                exp.setLastResult((String) value);
            }
            if ("status".equalsIgnoreCase(key)) {
                exp.setStatus((String) value);
            }
        });

        return exp;
    }

    @Override
    public int findExpId() {
        String sql = " select max(expid) next from expense";
        List<Map<String, Object>> maps = JdbcUtil.executeQuery(sql, null);
        Map<String, Object> map = maps.get(0);
       int value=0;
        for (String key : map.keySet()) {
            value = (Integer) map.get(key);
        }

        int next =  value + 1;

        return next;
    }

    @Override
    public List<Expense> findExp(String empId2, String status2, java.sql.Date expTime2) {
        StringBuilder sql = new StringBuilder("select  exp.* ,item.type,item.amount,item.itemdesc,image.realname,image.filename,image.filetype " +
                "  from expense exp " +
                "  JOIN expenseitem item on exp.expid = item.expid " +
                "  join expimage image on exp.expid = image.expid " +
                "  where 1=1");
        if (empId2 != null & !"".equals(empId2)) {
            sql.append("  and  exp.empid = '" + empId2 + "'  ");
        }
        if (status2 != null & !"".equals(status2)) {
            sql.append("  and exp.`status`= '" + status2 + "'  ");
        }
        if (expTime2 != null) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sdtDate = sdf.format(expTime2);
            sql.append(" and exp.exptime >='" + expTime2 + "'");
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Expense> expenseList = new ArrayList<Expense>();

        List<ExpenseItem> expenseItemList = new ArrayList<ExpenseItem>();
        List<ExpImage> imageList = new ArrayList<ExpImage>();
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //expense 各个字段
                int expId = rs.getInt("expId");
                String empId = rs.getString("empId");
                double totalAmount = rs.getDouble("totalAmount");
                Date expTime = rs.getDate("expTime");
                String expDesc = rs.getString("expDesc");
                String nextAuditorId = rs.getString("nextAuditor");
                String lastResult = rs.getString("lastResult");
                String status = rs.getString("status");

                //expenseitem 各个字段
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                String itemDesc = rs.getString("itemDesc");

                //expimage 各个字段
                String realName = rs.getString("realName");
                String filename = rs.getString("filename");
                String filetype = rs.getString("filetype");

                //
                ExpImage expImage = new ExpImage(realName, filename, filetype);
                expImage.setExpId(expId);

                ExpenseItem expenseItem = new ExpenseItem(type, amount, itemDesc);
                expenseItem.setExpId(expId);


                Expense exp = new Expense(expId, empId, totalAmount, expTime, expDesc, nextAuditorId, lastResult, status);

                expenseList.add(exp);
                expenseItemList.add(expenseItem);
                imageList.add(expImage);
            }

            //去除重复
            for  ( int  i  =   0 ; i  <  expenseList.size()  -   1 ; i ++ )  {
                for  ( int  j  =  expenseList.size()  -   1 ; j  >  i; j -- )  {
                    if  (expenseList.get(j).equals(expenseList.get(i)))  {
                        expenseList.remove(j);
                    }
                }
            }
            //
         /*  for (ExpenseItem item: expenseItemList){
               System.out.println(item);
           }*/


            for (int i=0;i<expenseList.size();i++){
                List<ExpenseItem> itemList = new ArrayList<ExpenseItem>();
                for (int j=0;j<expenseItemList.size();j++){
                    if(expenseList.get(i).getExpId()==expenseItemList.get(j).getExpId()){
                        itemList.add(expenseItemList.get(j));
                    }
                }
                expenseList.get(i).setItemList(itemList);

                for (int k=0;k<imageList.size();k++){
                    if(expenseList.get(i).getExpId()==imageList.get(k).getExpId()){
                        expenseList.get(i).setExpImage(imageList.get(k));
                    }
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(conn, pstmt, rs);
        }

        return expenseList;
    }
}
