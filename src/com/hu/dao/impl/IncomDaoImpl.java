package com.hu.dao.impl;

import com.hu.dao.IncomeDao;
import com.hu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-07-09 14:46
 * @decription
 **/
public class IncomDaoImpl implements IncomeDao {

    @Override
    public List<Object[]> findStaticsData() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement("select ictype,sum(amount) from income  group by ictype");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String icType = rs.getString(1);
                double amount = rs.getDouble(2);
                Object[] arr = {icType, amount};
                list.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(conn,pstmt, rs);
        }
        return list;
    }

    public static void main(String[] args) {
        IncomeDao icDao = new IncomDaoImpl();
        List<Object[]> list = icDao.findStaticsData();
        System.out.println(list.size());
    }

}


