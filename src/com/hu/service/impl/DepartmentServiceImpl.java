package com.hu.service.impl;

import com.hu.dao.DepartmentDao;
import com.hu.dao.impl.DepartmentDaoImpl;
import com.hu.entity.Department;
import com.hu.service.DepartmentService;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 15:56
 * @decription
 **/
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao deptDao = new DepartmentDaoImpl();

    @Override
    public int update(Department dept) {
        return this.deptDao.update(dept);
    }

    @Override
    public int add(Department dept) {
        return this.deptDao.save(dept);
    }

    @Override
    public List<Department> findAll() {
        return this.deptDao.findAll();
    }

    @Override
    public int delete(int deptno) {
        return this.deptDao.delete(deptno);
    }

    @Override
    public Department findById(int deptno) {
        return this.deptDao.findById(deptno);
    }
}
