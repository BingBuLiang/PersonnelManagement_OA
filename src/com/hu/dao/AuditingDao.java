package com.hu.dao;

import com.hu.entity.Auditing;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 22:41
 * @decription
 **/
public interface AuditingDao {
    /**
     *  添加审核记录
     */
     void save(Auditing auditing);
}
