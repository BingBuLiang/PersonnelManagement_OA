package com.hu.dao.impl;

import com.hu.dao.EmployeeDao;
import com.hu.entity.Department;
import com.hu.entity.Employee;
import com.hu.entity.Position;
import com.hu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 8:32
 * @decription
 **/
public class EmployeeDaoImpl   implements EmployeeDao {
    @Override
    public int save(Employee emp) {
        String sql = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.Date leaveDate2 = null;
        Date leaveDate = emp.getLeaveDate();
        if(leaveDate != null){
            leaveDate2 = new java.sql.Date(leaveDate.getTime());
        }

        Object [] params ={
                emp.getEmpId(),
                emp.getPassword(),
                //?
                emp.getDept().getDeptno(),
                //?
                emp.getPosition().getPosId(),
                //?
                emp.getMgr().getEmpId(),
                emp.getRealName(),
                emp.getSex(),
                new java.sql.Date(emp.getBirthDate().getTime()),
                new java.sql.Date(emp.getHireDate().getTime()),
                leaveDate2,
                emp.getOnDuty(),
                emp.getEmpType(),
                emp.getPhone(),
                emp.getQq(),
                emp.getEmerContactPerson(),
                emp.getIdCard()
        };
        return JdbcUtil.executeUpdate(sql,params);
    }

    @Override
    public int update(Employee emp) {
        String sql = "update employee set password=?,deptno=?,posid=?, "
                + " mgrid=?,realname=?,sex=?,birthdate=?,hiredate=?,leavedate=?, "
                + " onduty=?,emptype=?,phone=?,qq=?,emercontactperson=?,idcard=? "
                + " where empid=?";
        java.sql.Date leaveDate2 = null;
        Date leaveDate = emp.getLeaveDate();
        if(leaveDate != null){
            leaveDate2 = new java.sql.Date(leaveDate.getTime());
        }

        Object [] params ={
                emp.getPassword(),
                emp.getDept().getDeptno(),
                emp.getPosition().getPosId(),
                emp.getMgr().getEmpId(),
                emp.getRealName(),
                emp.getSex(),
                new java.sql.Date(emp.getBirthDate().getTime()),
                new java.sql.Date(emp.getHireDate().getTime()),
                //???
                leaveDate2,
                emp.getOnDuty(),
                emp.getEmpType(),
                emp.getPhone(),
                emp.getQq(),
                emp.getEmerContactPerson(),
                emp.getIdCard(),
                emp.getEmpId()
        };
        return JdbcUtil.executeUpdate(sql, params);
    }

    @Override
    public List<Employee> findByType(int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            conn =JdbcUtil.getConnection();
            pstmt = conn.prepareStatement("select * from employee where emptype=? order by empId desc");
            pstmt.setInt(1, type);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String empId = rs.getString("empId");
                String realName = rs.getString("realName");
                String sex = rs.getString("sex");
                String phone = rs.getString("phone");
                Employee emp = new Employee();
                emp.setEmpId(empId);
                emp.setRealName(realName);
                emp.setSex(sex);
                emp.setPhone(phone);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.closeAll( conn, pstmt, rs);
        }
        //7.返回数据
        return list;
    }

    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            conn =JdbcUtil.getConnection();

            String sql ="select e.empid,e.deptno,e.posid,e.mgrid,e.realname,e.sex,e.hiredate,"
                    + "  e.phone,d.deptname,p.pname,mgr.empid,mgr.realname "
                    + "  from employee  e "
                    + "  join dept d "
                    + "  on e.deptno = d.deptno "
                    + "  join position p "
                    + "  on e.posid = p.posid "
                    + "  join employee mgr "
                    + "  on e.mgrid = mgr.empid ";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String empId = rs.getString("empId");
                String realName = rs.getString("realName");
                String sex = rs.getString("sex");
                Date hireDate = rs.getDate("hireDate");
                String phone = rs.getString("phone");


                Employee emp = new Employee();
                emp.setEmpId(empId);
                emp.setRealName(realName);
                emp.setSex(sex);
                emp.setHireDate(hireDate);
                emp.setPhone(phone);

                int deptno = rs.getInt("deptno");
                String deptName = rs.getString("deptName");
                Department dept = new Department(deptno,deptName);
                emp.setDept(dept);

                int posId = rs.getInt("posid");
                String posName = rs.getString("pname");
                Position position = new Position(posId, posName);
                emp.setPosition(position);

                String mgrId = rs.getString(11);
                String mgrRealName= rs.getString(12);
                Employee mgr = new Employee();
                mgr.setEmpId(mgrId);
                mgr.setRealName(mgrRealName);
                emp.setMgr(mgr);

                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.closeAll(conn, pstmt,  rs);
        }


        return list;
    }

    @Override
    public List<Employee> find(int deptno2, int onDuty, Date hireDate2) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            conn =JdbcUtil.getConnection();

            StringBuilder sql =new StringBuilder("select e.empid,e.deptno,e.posid,e.mgrid,e.realname,e.sex,e.hiredate,"
                    + " e.phone,d.deptname,p.pname,mgr.empid,mgr.realname "
                    + " from employee  e "
                    + " join dept d "
                    + " on e.deptno = d.deptno "
                    + " join position p "
                    + " on e.posid = p.posid "
                    + " join employee mgr "
                    + " on e.mgrid = mgr.empid where 1=1  ");

            if(deptno2 != 0){
                sql.append(" and e.deptno="+deptno2);
            }
            //if(){
            sql.append(" and e.onDuty = "+onDuty);
            //}
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(hireDate2 !=null){
                String shireDate = sdf.format(hireDate2);
                sql.append(" and e.hiredate >= '"+shireDate+"'");
            }
            pstmt = conn.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();

            while(rs.next()){

                String empId = rs.getString("empId");
                String realName = rs.getString("realName");
                String sex = rs.getString("sex");
                Date hireDate = rs.getDate("hireDate");
                String phone = rs.getString("phone");


                Employee emp = new Employee();
                emp.setEmpId(empId);
                emp.setRealName(realName);
                emp.setSex(sex);
                emp.setHireDate(hireDate);
                emp.setPhone(phone);

                int deptno = rs.getInt("deptno");
                String deptName = rs.getString("deptName");
                Department dept = new Department(deptno,deptName);
                emp.setDept(dept);

                int posId = rs.getInt("posid");
                String posName = rs.getString("pname");
                Position position = new Position(posId, posName);
                emp.setPosition(position);

                String mgrId = rs.getString(11);
                String mgrRealName= rs.getString(12);
                Employee mgr = new Employee();
                mgr.setEmpId(mgrId);
                mgr.setRealName(mgrRealName);
                emp.setMgr(mgr);


                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.closeAll(conn ,pstmt, rs);
        }

        return list;
    }

    @Override
    public void delete(String empId) {
        String sql = "delete from employee where empid = ?";
        Object [] params = {empId};
        JdbcUtil.executeUpdate(sql, params);
    }

    @Override
    public Employee findById(String empId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee =  null;
        try {
            conn =JdbcUtil.getConnection();
            pstmt = conn.prepareStatement("select * from employee where empid= ?");
            pstmt.setString(1, empId);
            rs = pstmt.executeQuery();

            while(rs.next()){

                String realName = rs.getString("realName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                Date birthDate = rs.getDate("birthDate");
                Date hireDate = rs.getDate("hireDate");
                Date leaveDate = rs.getDate("leaveDate");
                int onDuty = rs.getInt("onduty");
                int empType = rs.getInt("emptype");
                String phone = rs.getString("phone");
                String qq = rs.getString("qq");
                String emerContactPerson = rs.getString("EMERCONTACTPERSON");
                String idCard = rs.getString("IDCARD");

                int deptno = rs.getInt("DEPTNO");
                Department dept = new Department();
                dept.setDeptno(deptno);

                int posId = rs.getInt("posid");
                Position position = new Position();
                position.setPosId(posId);


                String mgrId = rs.getString("mgrid");
                Employee mgr = new Employee();
                mgr.setEmpId(mgrId);
                employee = new Employee(empId, password, realName, sex, birthDate, hireDate, leaveDate, onDuty, empType, phone, qq, emerContactPerson, idCard, dept, position, mgr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{

            JdbcUtil.closeAll(conn,pstmt,rs);
        }

        return employee;
    }

    @Override
    public int updatePwd(String empId, String password) {
        String sql=" update employee set password=? where empId = ?";
        Object [] params = {password , empId};
        return JdbcUtil.executeUpdate(sql,params);
    }
}
