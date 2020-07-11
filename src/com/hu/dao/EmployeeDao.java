package com.hu.dao;

import com.hu.entity.Employee;

import java.util.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:27
 * @decription
 **/
public interface EmployeeDao {
    /**
     * 添加员工
     */
     int save(Employee emp);

    /**
     * 更新员工
     */
     int update(Employee emp);
    /**
     * 查询指定类型的员工
     */
     List<Employee> findByType(int type);

    /**
     * 查询所有员工
     */
     List<Employee> findAll();
    /**
     * 多条件查询员工信息，不带分页
     * @param deptno 部门编号
     * @param onDuty  是否在职
     * @param hireDate 入职时间
     */
     List<Employee> find(int deptno, int onDuty,
                               Date hireDate);
    /**
     * 删除指定编号的员工
     * @param empId
     */
     void delete(String empId);
    /**
     * 查询指定编号的员工
     */
     Employee findById(String empId);

    int updatePwd(String empId, String password);
}
