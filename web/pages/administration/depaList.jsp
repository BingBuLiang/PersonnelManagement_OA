<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/9
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>人事管理~部门管理</title>
  <base href="<%=basePath%>">
  <jsp:include page="/pages/include/link.jsp"/>

  <script>
    function deleteDept(deptno){
      var flag = window.confirm("您确定要删除该部门吗");
      if(flag){
        location.href="DepartmentServlet?method=delete&deptno="+deptno;
      }

    }
  </script>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- 导航栏 -->
  <jsp:include page="/pages/include/menu.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>部门管理</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">人事管理</a></li>
              <li class="breadcrumb-item active">部门管理</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">

            <div class="card">
              <div class="card-header">
                <h3 class="card-title">信息提示：</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>编号</th>
                    <th>部门名称</th>
                    <th>办公地点</th>
                    <th>操作</th>

                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${deptList }" var="dept">
                    <tr>

                      <td>${dept.deptno }</td>
                      <td>${dept.deptName }</td>
                      <td>${dept.location }</td>
                      <td>
                        <a href="DepartmentServlet?method=findById&deptno=${dept.deptno  }">修改</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:deleteDept(${dept.deptno })" > 删除</a>
                      </td>
                    </tr>
                  </c:forEach>


                  </tbody>
                  <tfoot>
                  <tr>
                    <th>编号</th>
                    <th>部门名称</th>
                    <th>办公地点</th>
                    <th>操作</th>

                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="/pages/include/footer.jsp"/>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<jsp:include page="/pages/include/jQuary.jsp"/>


<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
    });
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
</body>
</html>
