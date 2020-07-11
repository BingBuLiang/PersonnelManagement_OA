package com.hu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-09 15:53
 * @decription
 **/
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String methodName=req.getParameter("method");
        //调用方法处理请求（动态根据方法名调用方法--->反射）method
        try {
            //反射获取方法所在的类的类对象
            Class cla=this.getClass();
            //反射获取要被调用的方法对象
            Method m=cla.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //反射执行方法
            m.invoke(this, req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

