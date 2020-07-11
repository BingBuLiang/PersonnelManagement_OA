package com.hu.dao;

import com.hu.entity.Department;

import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:28
 * @decription
 **/
public interface DepartmentDao {


    /**
     * 查询指定编号的部门
     */
     Department findById(int deptno);

    /**
     * 查询所有部门信息
     */
     List<Department> findAll();

    /**
     * 添加部门
     */
     int save(Department dept);

    /**
     * 删除指定编号的部门
     */
     int delete(int deptno);

    /**
     * 更新部门
     */
     int update(Department dept);

}
