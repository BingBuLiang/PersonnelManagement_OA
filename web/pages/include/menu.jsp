<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/9
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 导航栏 -->
<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
  <!-- Left navbar links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
    </li>
    <li class="nav-item d-none d-sm-inline-block">
      <a href="index3.html" class="nav-link">主页</a>
    </li>
    <li class="nav-item d-none d-sm-inline-block">
      <a href="#" class="nav-link">联络</a>
    </li>
  </ul>

  <!-- SEARCH FORM -->
  <form class="form-inline ml-3">
    <div class="input-group input-group-sm">
      <input class="form-control form-control-navbar" type="search" placeholder="搜索" aria-label="Search">
      <div class="input-group-append">
        <button class="btn btn-navbar" type="submit">
          <i class="fas fa-search"></i>
        </button>
      </div>
    </div>
  </form>

  <!-- Right navbar links -->
  <ul class="navbar-nav ml-auto">
    <!-- Messages Dropdown Menu -->
    <li class="nav-item dropdown">
      <a class="nav-link" data-toggle="dropdown" href="#">
        <i class="far fa-comments"></i>
        <span class="badge badge-danger navbar-badge">3</span>
      </a>


    </li>
    <!-- Notifications Dropdown Menu -->
    <li class="nav-item dropdown">
      <a class="nav-link" data-toggle="dropdown" href="#">
        <i class="far fa-bell"></i>
        <span class="badge badge-warning navbar-badge">15</span>
      </a>

    </li>
    <!--退出-->
    <li class="nav-item">
      <a class="nav-link" href="EmployeeServlet?method=logout" role="button">
        <i class="fas  fa-power-off" style="color: red;">退出</i>
      </a>
    </li>
  </ul>
</nav>
<!-- /.navbar -->

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
  <!-- Brand Logo -->
  <a href="index3.html" class="brand-link">
    <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
         style="opacity: .8;background: #fff">
    <span class="brand-text font-weight-light">开心每一天</span>
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
      <div class="image">
        <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
      </div>
      <div class="info">
        <a href="#" class="d-block">${sessionScope.emp.realName }</a>
      </div>
    </div>


    <!--导航栏菜单-->
    <!-- Sidebar Menu -->
    <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <!-- Add icons to the links using the .nav-icon class
         with font-awesome or any other icon font library -->
        <c:if test="${sessionScope.emp.empType == 2 }">
          <!-- 人事管理 -->
          <li class="nav-item ">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-child"></i>
              <p>
                人事管理
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="pages/administration/addDepa.jsp" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>添加部門</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="DepartmentServlet?method=findAll" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>部門管理</p>
                </a>
              </li>

              <li class="nav-item">
                <a href="#" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>岗位管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="EmployeeServlet?method=toAdd" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>添加员工</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="EmployeeServlet?method=findAll" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>員工管理</p>
                </a>
              </li>
            </ul>
          </li>
          <!-- 考勤管理 --->
          <li class="nav-item">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-calculator"></i>
              <p>
                考勤管理
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item ">
                <a href="pages/attendance/attendSign.jsp" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>签到签退</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="DutyServlet?method=findDuty" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>考勤管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="DutyServlet?method=findDutyMe&empId=${sessionScope.emp.empId}" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>我的考勤</p>
                </a>
              </li>
            </ul>
          </li>
          <!-- 报销管理 --->
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-edit"></i>

              <p>
                报销管理
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="pages/expense/expenseAdd.jsp" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>添加报销</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="ExpenseServlet?method=toAudit" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>待审报销</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="ExpenseServlet?method=findExpMe&empId=${sessionScope.emp.empId}" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>我的报销</p>
                </a>
              </li>
            </ul>
          </li>
          <!-- 收支管理 --->
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-registered"></i>
              <p>
                收支管理
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>添加收入</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>查看收入</p>
                </a>
              </li>

              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>查看支出</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="pages/income/incomestatistics.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>收入统计</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="pages/income/paystatistics.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>支出统计</p>
                </a>
              </li>
            </ul>
          </li>
        </c:if>>


        <c:if test="${sessionScope.emp.empType ==1 }">
          <!-- 考勤管理 --->
          <li class="nav-item">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-calculator"></i>
              <p>
                考勤管理
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item ">
                <a href="pages/attendance/attendSign.jsp" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>签到签退</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="DutyServlet?method=findDutyMe&empId=${sessionScope.emp.empId}" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>我的考勤</p>
                </a>
              </li>
            </ul>
          </li>
          <!-- 报销管理 --->
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-edit"></i>

              <p>
                报销管理
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="pages/expense/expenseAdd.jsp" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>添加报销</p>
                </a>
              </li>

              <li class="nav-item">
                <a href="ExpenseServlet?method=findExpMe&empId=${sessionScope.emp.empId}" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>我的报销</p>
                </a>
              </li>
            </ul>
          </li>
        </c:if>


        <!-- 个人平台 --->
        <li class="nav-item">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-user"></i>
            <p>
              个人平台
              <i class="right fas fa-angle-left"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="pages/personal/MyInfo.jsp" class="nav-link ">
                <i class="far fa-circle nav-icon"></i>
                <p>我的信息</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="pages/personal/setPassword.jsp" class="nav-link">
                <i class="fas fa-key nav-icon"></i>
                <p>修改密码</p>
              </a>
            </li>

          </ul>
        </li>
      </ul>
    </nav>
    <!-- /.sidebar-menu -->
  </div>
  <!-- /.sidebar -->
</aside>

