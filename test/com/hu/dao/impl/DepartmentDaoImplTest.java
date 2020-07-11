package com.hu.dao.impl;

import com.hu.entity.Department;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 16:06
 * @decription
 **/
class DepartmentDaoImplTest {
    @Ignore
    @Test
    void findById() {
        Department department=new DepartmentDaoImpl().findById(1);
        System.out.println(department);
    }

    @Test
    void findAll() {
        List<Department> departmentList = new DepartmentDaoImpl().findAll();
        System.out.println(departmentList);
    }
}