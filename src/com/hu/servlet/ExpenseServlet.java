package com.hu.servlet;

import com.hu.entity.*;
import com.hu.service.ExpenseService;
import com.hu.service.impl.ExpenseServiceImpl;
import com.hu.util.MyException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 胡冰
 * @version 1.0
 * @create 2020-06-12 23:32
 * @decription
 **/
@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends BaseServlet {
    /**
     * 预更新操作  涉及文件操作 小心啊
     */
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.创建FileItemFactory对象
        FileItemFactory factory = new DiskFileItemFactory();
        //2.创建ServletFileUpload对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");//解决file表单项的文件名中文乱码问题
        //完善5：限制上传的单个和所有文件的大小。建议使用该方式
        upload.setFileSizeMax(16 * 1024 * 1024);//单个文件的上限
        upload.setSizeMax(5 * 16 * 1024 * 1024);//一次上传的所有文件的总大小的上限

        //3.通过ServletFileUpload对象实现上传操作，将客户端一个个表单项封装到一个个FileItem中
        List<FileItem> itemList = null;
        try {
            itemList = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
            request.setAttribute("error", "文件不能超过16MB....");
            request.getRequestDispatcher("/pages/expense/expenseAdd.jsp").forward(request, response);
            return;
        }
        //4.遍历各个FileItem（相当于对各个表单项进行处理）
        //System.out.println(itemList.size());
        //花名
        String empId = null;
        //报销总额
        double totalAmount = 0.0;
        //报销时间
        String sexpTime = null;
        Date expTime = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //描述
        String expDesc = null;


        //报销类型
        String strArr = "";
        List<String> typeArr = new ArrayList<String>();
        List<Double> amountArr = new ArrayList<Double>();
        List<String> itemDescArr = new ArrayList<String>();


        List<ExpenseItem> expenseItemList = new ArrayList<ExpenseItem>();

        String nextAuditorId = null;
        String lastResult = "新创建的";
        //状态  新建的为0
        String status = "0";


        //图片参数处理
        String realName = null;
        String fileName = null;
        String fileType = null;


        for (int i = 0; i < itemList.size(); i++) {
            //取出第i个表单项
            FileItem item = itemList.get(i);
            String fieldName = item.getFieldName();
            //对各个表单项进行处理（普通表单项和文件表单项要分开处理）
            if (item.isFormField()) {//普通表单项
                //empId
                if ("empId".equals(fieldName)) {
                    empId = item.getString("utf-8");
                }
                //totalAmount
                if ("totalAmount".equals(fieldName)) {
                    totalAmount = Double.parseDouble(item.getString());
                }
                // expTime
                if ("expTime".equals(fieldName)) {
                    sexpTime = item.getString("utf-8");
                    try {
                        expTime = sdf.parse(sexpTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                //type amountArr itemDescArr
                if ("type".equals(fieldName)) {
                    strArr = item.getString("utf-8");
                    typeArr.add(strArr);
                }
                if ("amount".equals(fieldName)) {
                    strArr = item.getString("utf-8");
                    amountArr.add(Double.parseDouble(strArr));
                }
                if ("itemDesc".equals(fieldName)) {
                    strArr = item.getString("utf-8");
                    itemDescArr.add(strArr);
                }

                //nextAuditorId
                if ("nextAuditorId".equals(fieldName)) {
                    nextAuditorId = item.getString("utf-8");
                }

                //expDesc
                if ("expDesc".equals(fieldName)) {
                    expDesc = item.getString("utf-8");
                }

            } else {//文件表单项
                //photo
                if ("photo".equals(fieldName)) {

                    long size = item.getSize();
                    if (size > 16 * 1024 * 1024) {
                        request.setAttribute("error", "文件不能超过16MB");
                        request.getRequestDispatcher("/pages/expense/expenseAdd.jsp").forward(request, response);
                        return;
                    }

                    //完善4：只上传jpg、jpeg和gif文件
                    String contentType = item.getContentType();//images/*
                    fileType = item.getContentType();
                    if (!"image/jpeg".equals(contentType) && !"image/gif".equals(contentType) && !"image/png".equals(contentType)) {
                        request.setAttribute("error", "只能上传jpg,gif,png文件");
                        request.getRequestDispatcher("/pages/expense/expenseAdd.jsp").forward(request, response);
                        return;
                    }

                    String realPath = this.getServletContext().getRealPath("/upload");
                    File dir = new File(realPath);
                    //完善1：如果文件夹不存在，就创建
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    //指定上传的文件名
                    realName = item.getName(); //adfad.fadf.yi.jpg
                    //指定长传的文件夹和文件名
                    //完善2：为了防止文件的同名覆盖，上传到服务器端的文件重新命名
                    UUID uuid = UUID.randomUUID();
                    String extName = realName.substring(realName.lastIndexOf("."));

                    fileName = uuid.toString() + extName; //535bc231-935a-427b-a1d7-b3e6d8b8293e.jpg
                    /*System.out.println("realname:\t"+realName+"\tfileName\t"+fileName);
                    System.out.println(dir);*/

                    File file = new File(dir, fileName);
                    //上传该照片到指定位置
                    try {
                        item.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //other
            }

        }
//大头戏来了
        //实例化 报销
        Expense expense = new Expense(empId, totalAmount, expTime, expDesc, nextAuditorId, lastResult, status);
        //实例化 报销项目
        for (int i = 0; i < typeArr.size(); i++) {
            ExpenseItem item = new ExpenseItem(typeArr.get(i), amountArr.get(i), itemDescArr.get(i));
            expenseItemList.add(item);

        }


        //实例化 图片
        ExpImage expImage = new ExpImage(realName, fileName, fileType);

        expense.setItemList(expenseItemList);
        expense.setExpImage(expImage);


        ExpenseService expenseService = new ExpenseServiceImpl();


        try {
            expenseService.add(expense);
            //成功页面跳转
            Employee user = (Employee) request.getSession().getAttribute("emp");
            String empid=user.getEmpId();
            response.sendRedirect(request.getContextPath() + "/ExpenseServlet?method=findExpMe&empId="+empid);
        } catch (Exception e) {
            e.printStackTrace();
            //失败 页面跳转
            request.setAttribute("error", "添加报销单失败");
            request.getRequestDispatcher("/pages/expense/expenseAdd.jsp").forward(request, response);

        }

    }

    public void findExpMe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取三个查询条件
        String empId = null;
        try {
            empId = request.getParameter("empId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //null  ""
        String status = null;
        try {
            status = request.getParameter("status");
        } catch (Exception e) {
            e.printStackTrace();
        }



        String strExpTime = null;
        try {
            strExpTime = request.getParameter("expTime");
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date expTime = null;
        try{
            expTime = java.sql.Date.valueOf(strExpTime);
        }catch(RuntimeException e){

        }

        ExpenseService expenseService=new ExpenseServiceImpl();
        List<Expense> expenseList = expenseService.findExp(empId, status, expTime);

        request.setAttribute("expenseList", expenseList);
        request.getRequestDispatcher("pages/expense/expenseMe.jsp").forward(request, response);
    }

    /**
     * 待审报销
     */
    public void toAudit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Employee emp = (Employee)request.getSession().getAttribute("emp");
        String auditorId = emp.getEmpId();

        ExpenseService  expService = new ExpenseServiceImpl();
        List<Expense> expenseList = expService.getToAudit(auditorId);

        request.setAttribute("expenseList", expenseList);
        request.getRequestDispatcher("pages/expense/expenseWait.jsp").forward(request, response);

    }
    /**
     * 审核报销单
     */
    public void audit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取审核表单的值
        System.out.println("进入审核");
        //expId:expId,result:result,auditDesc:auditDesc
        int expId = Integer.parseInt(request.getParameter("expId"));
        String result = request.getParameter("result");
        String auditDesc = request.getParameter("auditDesc");
        Employee auditor = (Employee)request.getSession().getAttribute("emp");
        Date auditTime = new Date();
        //调用业务层完成审核操作、
        Auditing auditing = new Auditing(expId, result, auditDesc, auditor, auditTime);
        ExpenseService  expService = new ExpenseServiceImpl();

        try{
            expService.audit(auditing);
            //成功
            //response.getWriter().print("success");
            response.sendRedirect(request.getContextPath() + "/ExpenseServlet?method=toAudit");
        }catch(MyException e){
            e.printStackTrace();
            //失败
            //response.getWriter().print("error");
            request.setAttribute("error", "审核报销失败");
            request.getRequestDispatcher("/ExpenseServlet?method=toAudit").forward(request, response);
        }


        //输出结果ajax

    }
}


