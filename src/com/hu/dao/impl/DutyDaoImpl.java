package com.hu.dao.impl;

import com.hu.dao.DutyDao;
import com.hu.entity.Department;
import com.hu.entity.Duty;
import com.hu.entity.Employee;
import com.hu.util.JdbcUtil;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 16:59
 * @decription
 **/
public class DutyDaoImpl implements DutyDao {
    @Override
    public List<Duty> find(String empId, int deptno, Date dtDate) {
        StringBuilder sql=new StringBuilder(
                " select dt.*,e.deptno,e.realname,d.deptname  " +
                " from duty dt ,employee e,dept d  " +
                " where  dt.empid = e.empid  " +
                " and e.deptno = d.deptno ");

        if(empId != null & !"".equals(empId)){
            sql.append(" and  dt.empid= '"+empId+"'");
        }
        if(deptno !=0){
            sql.append(" and e.deptno ="+ deptno);

        }
        if(dtDate != null){
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sdtDate = sdf.format(dtDate);
            sql.append(" and dt.dtdate >='"+sdtDate+"'");
        }


        Object [] params = {empId,deptno,dtDate};
        List<Map<String, Object>> maps = JdbcUtil.executeQuery(sql.toString(), params);
        if(maps.size()==0) {
            return null;
        }
        List<Duty> dutyList=new ArrayList<Duty >();
        for (Map<String, Object> map:maps){
            Duty duty=new Duty();
            Department dept = new Department();
            Employee emp = new Employee();
            map.forEach((key, value) -> {
                if ("dtid".equalsIgnoreCase(key)) {
                    duty.setDtID((Integer) value);
                }
                if ("dtDate".equalsIgnoreCase(key)) {
                    duty.setDtDate((java.util.Date) value);
                }
                if ("signinTime".equalsIgnoreCase(key)) {
                    duty.setSigninTime((String) value);
                }
                if ("signinTime".equalsIgnoreCase(key)) {
                    duty.setSignoutTime((String) value);
                }

                if ("deptno".equalsIgnoreCase(key)) {
                    dept.setDeptno((Integer) value);
                }
                if ("deptName".equalsIgnoreCase(key)) {
                    dept.setDeptName((String) value);
                }


                if ("empId".equalsIgnoreCase(key)) {
                    emp.setEmpId((String) value);
                }
                if ("realName".equalsIgnoreCase(key)) {
                    emp.setRealName((String) value);
                }
                emp.setDept(dept);
                duty.setEmp(emp);
            });
            dutyList.add(duty);
        }
        return dutyList;
    }

    @Override
    public boolean find(String empId, Date today) {
        String sql="select * from duty  where empid = ? and dtdate = ?";
        Object [] params = {empId,today};
        //没有签到
        boolean flag = false;
        List<Map<String, Object>> maps = JdbcUtil.executeQuery(sql, params);
        if (maps.size()>=1){
            flag=true;
        }

        //7.返回数据
        return flag;
    }

    @Override
    public int singin(Duty duty) {
        String sql="insert into duty values(default,?,?,?,null)";
        Object [] params = {duty.getEmpId(),duty.getDtDate(),duty.getSigninTime()};
        return JdbcUtil.executeUpdate(sql, params);
    }

    @Override
    public int singout(Duty duty) {
        String sql = "update duty set signouttime = ? where empid = ? and dtdate = ?";
        Object [] params = {duty.getSignoutTime(),duty.getEmpId(),duty.getDtDate()};
        return JdbcUtil.executeUpdate(sql, params);
    }
}
