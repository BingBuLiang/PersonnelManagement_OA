package com.hu.dao.impl;

import com.hu.entity.Duty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 18:20
 * @decription
 **/
class DutyDaoImplTest {
    @Ignore
    @Test
    void find() {
        java.sql.Date date=new  java.sql.Date(2019,12,13);
        boolean flag=new DutyDaoImpl().find("yue",date);
        System.out.println(flag);
    }

    @Test
    void testFind() {
        List<Duty> dutyList = new DutyDaoImpl().find(null, 0, null);
        System.out.println(dutyList);
    }
}