package com.hu.servlet;

import com.hu.service.IncomeService;
import com.hu.service.impl.IncomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 胡冰
 * @version 1.0
 **/
@WebServlet("/IncomeServlet")

public class IncomeServlet extends BaseServlet {
    /**
     * 返回支出的饼图数据
     */
    public void getPieData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stype = request.getParameter("type");
        int type = 0;
        try {
            type = Integer.parseInt(stype);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用业务层获取jsonStr
        IncomeService ioService = new IncomeServiceImpl();
        //0代表查询所有时间段  1  2  3
        String jsonStr = ioService.getPieData(type);
        //返回JsonStr
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(jsonStr);

    }
    /**
     * 返回收入的柱状图数据
     */
    public void getBarData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IncomeService ioService = new IncomeServiceImpl();
        String jsonStr = ioService.getBarData();
        //返回JsonStr
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(jsonStr);
    }
}
