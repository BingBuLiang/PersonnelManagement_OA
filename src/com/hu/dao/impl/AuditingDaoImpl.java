package com.hu.dao.impl;

import com.hu.dao.AuditingDao;
import com.hu.entity.Auditing;
import com.hu.util.JdbcUtil;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:47
 * @decription
 **/
public class AuditingDaoImpl  implements AuditingDao  {

    @Override
    public void save(Auditing auditing) {
        //这里有考虑 使用替换词 replace  重覆盖
        String sql = "insert into  auditing values(default,?,?,?,?,?)";
        Object [] params = {auditing.getExpId(),auditing.getAuditor().getEmpId(),
                auditing.getResult(),auditing.getAuditDesc(),
                new  java.sql.Timestamp(auditing.getAuditTime().getTime())};
        JdbcUtil.executeUpdate(sql, params);
    }

}