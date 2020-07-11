package com.hu.dao.impl;

import com.hu.dao.DepartmentDao;
import com.hu.entity.Department;
import com.hu.util.JdbcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 16:01
 * @decription
 **/
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public Department findById(int deptno) {
        String sql = "select * from dept  where deptno = ?";
        Object[] params = {deptno};
        List<Map<String, Object>> maps = JdbcUtil.executeQuery(sql, params);
        Department department = new Department();
        if (maps.size() != 0) {
            Map<String, Object> map = maps.get(0);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                if ("deptname".equalsIgnoreCase(key)) {
                    department.setDeptName(value);
                }
                if ("deptno".equalsIgnoreCase(key)) {
                    department.setDeptno(Integer.parseInt(value));
                }
                if ("location".equalsIgnoreCase(key)) {
                    department.setLocation(value);
                }

            }

        }

        return department;
    }

    @Override
    public List<Department> findAll() {
        String sql = "select * from dept";
        List<Map<String, Object>> maps = JdbcUtil.executeQuery(sql, null);
        if (maps.size() == 0) {
            return null;
        }
        List<Department> departmentList = new ArrayList<Department>();
        for (Map<String, Object> map : maps) {
            Department department = new Department();
            map.forEach((key, value) -> {
                if ("deptname".equalsIgnoreCase(key)) {
                    department.setDeptName((String) value);
                }
                if ("deptno".equalsIgnoreCase(key)) {
                    department.setDeptno((Integer)value);
                }
                if ("location".equalsIgnoreCase(key)) {
                    department.setLocation((String) value);
                }
            });
            departmentList.add(department);
        }
        return departmentList;
    }

    @Override
    public int save(Department dept) {
        String sql = "insert into dept values(?,?,?)";
        Object [] params = {dept.getDeptno(),dept.getDeptName(),dept.getLocation()};

        return JdbcUtil.executeUpdate(sql, params);
    }

    @Override
    public int delete(int deptno) {
        String sql = "delete from dept where deptno = ?";
        Object [] params = {deptno};

        return JdbcUtil.executeUpdate(sql, params);
    }

    @Override
    public int update(Department dept) {
        String sql = "update dept set deptname=?,location=? where deptno= ?";
        Object [] params = {dept.getDeptName(),dept.getLocation(),dept.getDeptno()};

        return JdbcUtil.executeUpdate(sql, params);
    }
}
