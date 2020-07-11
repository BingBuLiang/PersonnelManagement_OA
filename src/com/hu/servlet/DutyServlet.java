package com.hu.servlet;

import com.hu.entity.Department;
import com.hu.entity.Duty;
import com.hu.entity.Employee;
import com.hu.service.DepartmentService;
import com.hu.service.DutyService;
import com.hu.service.impl.DepartmentServiceImpl;
import com.hu.service.impl.DutyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 16:53
 * @decription 考勤管理
 **/
@WebServlet("/DutyServlet")
public class DutyServlet extends BaseServlet {

    /**
     * 签到
     */
    public void signin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        Employee emp = (Employee)request.getSession().getAttribute("emp");
        String empId = emp.getEmpId();
        //调用业务层完成签到操作
        DutyService dutyService = new DutyServiceImpl();
        //1  成功  0 失败   2 已经签到
        int n = dutyService.signin(empId);

        //返回内容
        response.getWriter().println(n);
    }
    /**
     * 签退
     */
    public void signout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取当前用户的empId
        Employee emp = (Employee)request.getSession().getAttribute("emp");
        String empId = emp.getEmpId();
        //调用业务层完成签退操作
        DutyService dutyService = new DutyServiceImpl();
        //1  成功  0 失败   2 没有签到
        int n = dutyService.signout(empId);

        //返回内容
        response.getWriter().println(n);

    }



    public void findDuty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取三个查询条件
        String empId = null;
        try {
            empId = request.getParameter("empId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //null  ""
        String sdeptno = null;
        try {
            sdeptno = request.getParameter("deptno");
        } catch (Exception e) {
            e.printStackTrace();
        }

        int deptno = 0;
        try{
            deptno = Integer.parseInt(sdeptno);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }

        String sdtDate = null;
        try {
            sdtDate = request.getParameter("dtDate");
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date dtDate = null;
        try{
            dtDate = java.sql.Date.valueOf(sdtDate);
        }catch(RuntimeException e){
            e.printStackTrace();
        }

        //调用业务层完成查询操作
        DutyService dutyService = new DutyServiceImpl();
        List<Duty> dutyList = dutyService.findDuty(empId,deptno,dtDate);


        request.setAttribute("dutyList", dutyList);
        //获取上级员工  1  基层员工  2 各级管理人员
        //调用业务层获取所有的部门
        DepartmentService deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();

        request.setAttribute("deptList",deptList);

        request.getRequestDispatcher("pages/attendance/attendList.jsp").forward(request, response);


    }



    public void findDutyMe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取三个查询条件
        String empId = null;
        try {
            empId = request.getParameter("empId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //null  ""
        String sdeptno = null;
        try {
            sdeptno = request.getParameter("deptno");
        } catch (Exception e) {
            e.printStackTrace();
        }

        int deptno = 0;
        try{
            deptno = Integer.parseInt(sdeptno);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }

        String sdtDate = null;
        try {
            sdtDate = request.getParameter("dtDate");
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date dtDate = null;
        try{
            dtDate = java.sql.Date.valueOf(sdtDate);
        }catch(RuntimeException e){

        }

        //调用业务层完成查询操作
        DutyService dutyService = new DutyServiceImpl();
        List<Duty> dutyList = dutyService.findDuty(empId,deptno,dtDate);


        request.setAttribute("dutyList", dutyList);
        //获取上级员工  1  基层员工  2 各级管理人员
        //调用业务层获取所有的部门
        DepartmentService deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();

        request.setAttribute("deptList",deptList);

        request.getRequestDispatcher("pages/attendance/attendListMe.jsp").forward(request, response);


    }
}
