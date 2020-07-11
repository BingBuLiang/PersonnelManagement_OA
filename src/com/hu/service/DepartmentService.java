package com.hu.service;

import com.hu.entity.Department;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 15:55
 * @decription
 **/
public interface DepartmentService {
    /**
     * 更新部门
     */
    public int update(Department dept);

    /**
     * 添加部门
     */
    public int add(Department dept);

    /**
     * 查询所有部门信息
     */
    public List<Department> findAll();

    /**
     * 删除指定编号的部门
     */
    public int delete(int deptno);

    /**
     * 查询指定编号的部门信息
     */
    public Department findById(int deptno);
}
