package com.hu.filter;

import com.hu.entity.Employee;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-11 9:03
 * @decription authorized
 * 授权过滤器
 **/

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤路径是   *.jsp
     * 某些jsp应该排除在外   login.jsp   register.jsp   index.jsp  random.jpg
     * 某些servlet应该排除在外  EmployeeServlet?method=login
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpresponse = (HttpServletResponse) servletResponse;
        //1.请求到达目标资源之前的预处理操作
        String uri = httprequest.getRequestURI();
        // 如果 没有查询字符串，就是null
        String qs = httprequest.getQueryString();

        //>=0 存在
        int n1 = uri.indexOf("login.jsp");
        int n2 = uri.indexOf("random.jpg");
        int n3 = -1;
        int n4 = -1;
        if (qs != null) {
            n3 = qs.indexOf("login");
            n4 = qs.indexOf("logout");
        }

        int n5= uri.indexOf("assets");
        int n6= uri.indexOf("build");
        int n7= uri.indexOf("dist");
        int n8= uri.indexOf("docs");
        int n9=uri.indexOf("plugins");

        if (n1 >= 0 || n2 >= 0 || n3 >= 0 || n4 >= 0  || n5>=0 || n6>=0 || n7>=0 || n8>=0 || n9>=0 )  {
            //需要排除在外的资源
            //放行
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            //判断用户是否登录，如果登录，就允许访问，如果没有登录，就重定向到登录页面
            Employee user = (Employee) httprequest.getSession().getAttribute("emp");

            if (user != null) {

                //普通员工
                if (user.getEmpType() == 1) {

                    int empE1 = uri.indexOf("EmployeeServlet");
                    int empE2 = uri.indexOf("DepartmentServlet");
                    System.out.println("--------empE1   " + empE1 + "--------empE2   " + empE2);
                    if (empE1 < 0 && empE2 < 0) {
                        //就允许访问,调用下一个过滤器或者目标资源
                        filterChain.doFilter(servletRequest, servletResponse);

                    } else {
                        //3.响应离开目标资源后的后处理操作
                        //不放行
                        System.out.println("不放行");
                        //就重定向到登录页面
                        httpresponse.sendRedirect(httprequest.getContextPath() + "/index.jsp");

                    }
                }
                if (user.getEmpType() != 1) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                //就重定向到登录页面
                httpresponse.sendRedirect(httprequest.getContextPath() + "/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
