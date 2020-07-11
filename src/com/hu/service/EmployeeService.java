package com.hu.service;

import com.hu.entity.Employee;

import java.util.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-10 8:41
 * @decription
 **/
public interface EmployeeService {
    /**
     * 添加员工
     */
    int add(Employee emp);

    /**
     * 更新员工
     */
    int update(Employee emp);

    /**
     * 查询指定类型的员工
     */
    List<Employee> findEmpByType(int i);

    /**
     * 查询所有员工
     */
    List<Employee> findAll();

    /**
     * 多条件查询员工，不带分页
     */
    List<Employee> findEmp(int deptno, int onDuty, Date hireDate);

    /**
     * 删除指定编号的员工
     *
     * @param empId
     */
    void delete(String empId);

    /**
     * 查询指定编号的员工
     */
    Employee findById(String empId);

    /**
     * 实现登录操作
     */
    Employee login(String empId, String password);

    int updatePwd(String empId, String password);
}
