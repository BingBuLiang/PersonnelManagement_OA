package com.hu.service.impl;

import com.hu.dao.EmployeeDao;
import com.hu.dao.impl.EmployeeDaoImpl;
import com.hu.entity.Employee;
import com.hu.service.EmployeeService;

import java.util.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-10 8:44
 * @decription
 **/
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao empDao = new EmployeeDaoImpl();
    @Override
    public int add(Employee emp) {
        return this.empDao.save(emp);
    }

    @Override
    public int update(Employee emp) {
        return this.empDao.update(emp);
    }

    @Override
    public List<Employee> findEmpByType(int i) {
        return this.empDao.findByType(i);
    }

    @Override
    public List<Employee> findAll() {
        return this.empDao.findAll();
    }

    @Override
    public List<Employee> findEmp(int deptno, int onDuty, Date hireDate) {
        return this.empDao.find( deptno, onDuty, hireDate);
    }

    @Override
    public void delete(String empId) {
        this.empDao.delete(empId);
    }

    @Override
    public Employee findById(String empId) {
        return this.empDao.findById(empId);
    }

    @Override
    public Employee login(String empId, String password) {
        Employee emp = this.empDao.findById(empId);
        //用户名是错误的
        if(emp == null){
            return null;
        }else{
            if(password!=null & password.equals(emp.getPassword())){
                return emp;
            }else{//用户名正确，密码错误
                return null;
            }
        }
    }

    @Override
    public int updatePwd(String empId, String password) {

        return this.empDao.updatePwd(empId,password);
    }


}
