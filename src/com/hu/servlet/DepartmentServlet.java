package com.hu.servlet;

import com.hu.entity.Department;
import com.hu.service.DepartmentService;
import com.hu.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 15:52
 * @decription 部门管理
 **/

@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends BaseServlet{
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收视图层的表单数据
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String deptName = request.getParameter("deptName");
        String location = request.getParameter("location");

        //调用业务层完成添加操作
        DepartmentService deptService = new DepartmentServiceImpl();
        Department dept = new Department(deptno, deptName, location);
        int n = deptService.add(dept);

        //根据结果跳转到不同的页面
        if(n>0){

            response.sendRedirect(request.getContextPath()+"/DepartmentServlet?method=findAll");
        }else{
            request.setAttribute("error", "添加失败");
            request.getRequestDispatcher("/pages/administration/addDepa.jsp").forward(request, response);
        }
    }
    public void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收视图层的表单数据

        //调用业务层完成添加操作
        DepartmentService  deptService = new DepartmentServiceImpl();
        List<Department> deptList = deptService.findAll();

        //跳转到system/deptList.jsp
        request.setAttribute("deptList", deptList);
        request.getRequestDispatcher("/pages/administration/depaList.jsp").forward(request, response);


    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收视图层的表单数据
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String deptName = request.getParameter("deptName");
        String location = request.getParameter("location");

        //调用业务层完成添加操作
        DepartmentService  deptService = new DepartmentServiceImpl();
        Department dept = new Department(deptno, deptName, location);
        int n = deptService.update(dept);

        //根据结果跳转到不同的页面
        if(n>0){
            //request.getRequestDispatcher("/deptList.html").forward(request, response)
            response.sendRedirect(request.getContextPath()+"/DepartmentServlet?method=findAll");
        }else{
            request.setAttribute("error", "更新失败");
            //使用转发，因为要复用保存在request中的数据
            request.getRequestDispatcher("/pages/administration/depaUpdate.jsp").forward(request, response);

        }
    }

    public void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收要更新的部门的编号
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        //调用业务层完成查询操作
        DepartmentService  deptService = new DepartmentServiceImpl();
        Department dept = deptService.findById(deptno);

        //跳转到
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("/pages/administration/depaUpdate.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        DepartmentService  deptService = new DepartmentServiceImpl();
        deptService.delete(deptno);

        request.getRequestDispatcher("/DepartmentServlet?method=findAll").forward(request, response);

    }
}
