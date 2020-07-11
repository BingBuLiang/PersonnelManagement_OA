package com.hu.dao.impl;

import com.hu.dao.ExpImageDao;
import com.hu.entity.ExpImage;
import com.hu.util.JdbcUtil;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-13 8:04
 * @decription
 **/
public class ExpImageDaoImpl implements ExpImageDao {

    @Override
    public void save(ExpImage expImage) {
        String sql = "insert into expimage  values(default,?,?,?,?)";
        Object [] params ={expImage.expId,expImage.realName,expImage.fileName,expImage.fileType};
        JdbcUtil.executeUpdate(sql, params);
    }
}
