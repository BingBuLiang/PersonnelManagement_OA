package com.hu.servlet;

import com.google.gson.Gson;
import com.hu.entity.Department;
import com.hu.entity.Employee;
import com.hu.entity.Position;
import com.hu.service.DepartmentService;
import com.hu.service.EmployeeService;
import com.hu.service.impl.DepartmentServiceImpl;
import com.hu.service.impl.EmployeeServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-10 7:32
 * @decription 员工管理
 **/
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends BaseServlet {
    /**
     * 注销操作
     */
    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //结束当前的session
        request.getSession().invalidate();
        //跳转到登录页面
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    /**
     * 登录操作
     */
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取登录信息
        String empId = request.getParameter("empId");
        String password = request.getParameter("password");
        //md5 加盐 hu     迭代2
        Md5Hash md5Hash = new Md5Hash(password, "hu", 2);
//验证码
        //用户输入的验证码
        String verifyCode = request.getParameter("verifyCode");
        //正确的验证码
        String randStr = (String) request.getSession().getAttribute("randStr");
        if (verifyCode == null || !verifyCode.equals(randStr)) {
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //调用业务层完成登录操作
        EmployeeService empService = new EmployeeServiceImpl();
        Employee emp = empService.login(empId, md5Hash.toString());

        //页面跳转
        if (emp != null) {
            //将员工信息保存在session中
            request.getSession().setAttribute("emp", emp);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("error", "用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


    /**
     * 预更新操作
     */
    public void toUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //接收要修改的员工的编号
        String empId = request.getParameter("empId");


        //调用业务层获取该员工的信息
        EmployeeService empService = new EmployeeServiceImpl();
        Employee emp = empService.findById(empId);
        request.setAttribute("emp", emp);

        //获取所有的部门信息
        DepartmentService deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();
        request.setAttribute("deptList", deptList);
        //获取上级员工  1  基层员工  2 各级管理人员
        List<Employee> mgrList = empService.findEmpByType(2);
        request.setAttribute("mgrList", mgrList);

        request.getRequestDispatcher("/pages/administration/empUpdate.jsp").forward(request, response);
    }

    /**
     * 查看个人信息
     */
    public void findByIdInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收要修改的员工的编号
        String empId = request.getParameter("empId");

        //调用业务层获取该员工的信息
        EmployeeService empService = new EmployeeServiceImpl();
        Employee emp = empService.findById(empId);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(new Gson().toJson(emp));

    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取员工的信息
        String empId = request.getParameter("empId");
        String password = "123456";
        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");

        //日期类型的处理
        String sbirthDate = request.getParameter("birthDate");
        String shireDate = request.getParameter("hireDate");
        String sleaveDate = request.getParameter("leaveDate");

        Date birthDate = null;
        Date hireDate = null;
        Date leaveDate = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            birthDate = sdf.parse(sbirthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            hireDate = sdf.parse(shireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            leaveDate = sdf.parse(sleaveDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //整数的处理
        int onDuty = Integer.parseInt(request.getParameter("onDuty"));
        int empType = Integer.parseInt(request.getParameter("empType"));

        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String emerContactPerson = request.getParameter("emerContactPerson");
        String idCard = request.getParameter("idCard");

        //对象的处理
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        Department dept = new Department();
        dept.setDeptno(deptno);

        int posId = Integer.parseInt(request.getParameter("posId"));
        Position position = new Position();
        position.setPosId(posId);
        String mgrId = request.getParameter("mgrId");
        Employee mgr = new Employee();
        mgr.setEmpId(mgrId);//!!!

        //调用业务层完成添加操作
        Employee emp = new Employee(empId, password, realName, sex, birthDate, hireDate, leaveDate, onDuty, empType, phone, qq, emerContactPerson, idCard, dept, position, mgr);
        EmployeeService empService = new EmployeeServiceImpl();
        int n = empService.update(emp);

        //根据结果进行页面跳转
        if (n > 0) {
            response.sendRedirect(request.getContextPath() + "/EmployeeServlet?method=findAll");
            //request.getRequestDispatcher("/EmployeeServlet?method=findEmp").forward(request, response);
        } else {
            request.setAttribute("error", "更新员工失败");
            request.getRequestDispatcher("/pages/administration/empUpdate.jsp").forward(request, response);
        }

    }

    /**
     * 删除delete
     */
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empId = request.getParameter("empId2");

        EmployeeService empService = new EmployeeServiceImpl();
        empService.delete(empId);


        request.getRequestDispatcher("/EmployeeServlet?method=findAll").forward(request, response);
        //this.findAll(request, response);
    }

    public void findEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int deptno = 0;
        String sdeptno = request.getParameter("deptno"); //null
        try {
            deptno = Integer.parseInt(sdeptno);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int onDuty = 1;
        String sonDuty = request.getParameter("onDuty");//null
        try {
            onDuty = Integer.parseInt(sonDuty);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String shireDate = request.getParameter("hireDate");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        if (shireDate != null) {
            try {
                hireDate = sdf.parse(shireDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        EmployeeService empService = new EmployeeServiceImpl();

        List<Employee> empList = empService.findEmp(deptno, onDuty, hireDate);

        DepartmentService deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();
        request.setAttribute("deptList", deptList);

        request.setAttribute("deptno", deptno);
        request.setAttribute("onDuty", onDuty);
        request.setAttribute("hireDate", shireDate);
        request.setAttribute("empList", empList);
        request.getRequestDispatcher("/pages/administration/empList.jsp").forward(request, response);

    }


    public void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //调用业务层获取所有的员工信息
        EmployeeService empService = new EmployeeServiceImpl();
        List<Employee> empList = empService.findAll();
        //获取所有部门的信息
        DepartmentService deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();
        request.setAttribute("deptList", deptList);

        //跳转到
        request.setAttribute("empList", empList);
        request.getRequestDispatcher("/pages/administration/empList.jsp").forward(request, response);

    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取所有的部门信息
        DepartmentService deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();
        request.setAttribute("deptList", deptList);
        //获取所有的岗位信息

        //获取上级员工
        EmployeeService empService = new EmployeeServiceImpl();
        //1  基层员工  2 各级管理人员
        List<Employee> mgrList = empService.findEmpByType(2);
        request.setAttribute("mgrList", mgrList);
        //跳转到
        request.getRequestDispatcher("/pages/administration/addEmp.jsp").forward(request, response);
    }

    /**
     * 添加员工
     */
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取员工的信息
        String empId = request.getParameter("empId");
        String password = new Md5Hash("123456","hu",2).toString();
        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        //日期类型的处理
        String sbirthDate = request.getParameter("birthDate");
        String shireDate = request.getParameter("hireDate");
        /*String sleaveDate = request.getParameter("leaveDate");*/

        Date birthDate = null, hireDate = null, leaveDate = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = sdf.parse(sbirthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            hireDate = sdf.parse(shireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       /* try {
            leaveDate = sdf.parse(sleaveDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        //整数的处理
        int onDuty = Integer.parseInt(request.getParameter("onDuty"));
        int empType = Integer.parseInt(request.getParameter("empType"));

        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String emerContactPerson = request.getParameter("emerContactPerson");
        String idCard = request.getParameter("idCard");

        //对象的处理
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        Department dept = new Department();
        dept.setDeptno(deptno);

        int posId = Integer.parseInt(request.getParameter("posId"));
        Position position = new Position();
        position.setPosId(posId);
        String mgrId = request.getParameter("mgrId");
        Employee mgr = new Employee();
        mgr.setEmpId(mgrId);

        Employee emp = new Employee(empId, password, realName, sex, birthDate, hireDate, leaveDate, onDuty, empType, phone, qq, emerContactPerson, idCard, dept, position, mgr);
        EmployeeService empService = new EmployeeServiceImpl();
        int n = empService.add(emp);

        //根据结果进行页面跳转
        if (n > 0) {
            response.sendRedirect(request.getContextPath() + "/EmployeeServlet?method=findAll");
        } else {
            request.setAttribute("error", "添加员工失败");
            request.getRequestDispatcher("/pages/administration/addEmp.jsp").forward(request, response);
        }

    }

    /**
     * 更新密码
     */
    public void setPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //用户输入的验证码
        String verifyCode = request.getParameter("verifyCode");
        //正确的验证码
        String randStr = (String) request.getSession().getAttribute("randStr");
        if (verifyCode == null || !verifyCode.equals(randStr)) {
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("/pages/personal/setPassword.jsp").forward(request, response);
            return;
        }

        //获取登录信息
        String empId = request.getParameter("empId");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        //md5 加盐 hu     迭代2
        Md5Hash md5Hash = new Md5Hash(oldPassword, "hu", 2);

        //调用业务层完成登录操作
        EmployeeService empService = new EmployeeServiceImpl();

        //验证码
        String password=empService.findById(empId).getPassword();

        if (!password.equals(md5Hash.toString())) {
            request.setAttribute("error", "旧密码输入错误");
            request.getRequestDispatcher("/pages/personal/setPassword.jsp").forward(request, response);
            return;
        }
        md5Hash=new Md5Hash(newPassword, "hu", 2);
        int  n=empService.updatePwd(empId,newPassword);
        //页面跳转
        if (n > 0) {
            //从新登陆
            request.setAttribute("error", "密码修改成功，从新登陆！");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            request.setAttribute("error", "更新密码失败");
            request.getRequestDispatcher("/pages/personal/setPassword.jsp").forward(request, response);
        }

    }


}
