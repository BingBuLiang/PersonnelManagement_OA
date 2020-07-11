<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/9
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <base href="<%=basePath%>">
  <title>人事管理~添加部门</title>

 <jsp:include page="/pages/include/link.jsp"/>
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
            <h1>修改部门</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">人事管理</a></li>
              <li class="breadcrumb-item active">修改部门</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">

            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">修改部门</h3>
                <span style="color:red;font-weight: bold;font-size: 18px;">${error}</span>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form class="form-horizontal" action="DepartmentServlet?method=update" method="post" >
                <div class="card-body">
                  <div class="form-group row">
                    <label for="deptno" class="col-sm-2 col-form-label">部门编号</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="deptno" placeholder="部门编号" name="deptno" value="${dept.deptno }" readonly="readonly" >
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="deptName" class="col-sm-2 col-form-label">部门名称</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="deptName" placeholder="部门名称" name="deptName" value="${dept.deptName }">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="location" class="col-sm-2 col-form-label">办公地点</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="location" placeholder="办公地点" name="location" value="${dept.location }">
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-info">确认保存</button>
                  <button type="reset" class="btn btn-default float-right">清除</button>
                </div>
                <!-- /.card-footer -->
              </form>
            </div>
            <!-- /.card -->

          </div>
          <!--/.col (left) -->

        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2020-2020 <a href="https://bingbuliang.github.io">冰不良</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- bs-custom-file-input -->
<script src="plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script src="plugins/bootstrap/js/sakura.js"></script>
<script>
  $(function() {
    bsCustomFileInput.init();
  });
</script>
</body>
</html>

