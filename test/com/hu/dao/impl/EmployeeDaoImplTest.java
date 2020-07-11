package com.hu.dao.impl;

import com.hu.entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:34
 * @decription
 **/
class EmployeeDaoImplTest {

    @org.junit.jupiter.api.Test
    void findById() {
        Employee employee=new  EmployeeDaoImpl().findById("yue");
        System.out.println(employee);
    }
}