<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/11
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/7
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>考勤管理~签到签退</title>
  <base href="<%=basePath%>">
  <jsp:include page="/pages/include/link.jsp"/>

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <jsp:include page="/pages/include/menu.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">签到签退</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">考勤管理</a></li>
              <li class="breadcrumb-item active">签到签退</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card card-primary card-outline">
              <div class="card-header">
                <h3 class="card-title">
                  <i class="fas fa-fw fa-calendar"></i>
                  签到签退
                </h3>
              </div>
              <div class="card-body pad table-responsive">
                <p class="text-lightblue">朝气蓬勃的一天！继续加油！</p><span class="text-red" id="result"></span>
                <div class="col-3">
                  <button type="button" class="btn btn-block btn-outline-primary btn-lg" id="signin">签到</button>
                  <p class="text-gray">每天签到一次，不可重复签到</p>
                  <hr/>
                  <hr/>
                  <hr/>
                  <button type="button" class="btn btn-block btn-outline-success btn-lg" id="signout">签退</button>
                  <p class="text-gray">可重复签退，以最后一次签退为准</p>

                </div>
              </div>
              <!-- /.card -->
            </div>
          </div>
          <!-- /.col -->
        </div>


        <!-- /.row -->
      </div><!-- /.container-fluid -->

    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <jsp:include page="/pages/include/footer.jsp"/>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

<script>

  $("#signin").click(function () {
    $.post("DutyServlet?method=signin", function (data) {
//显示签到的结果
      if (data == 0) {
        $("#result").html("签到失败");
      } else if (data == 1) {
        $("#result").html("签到成功");
      } else {
        $("#result").html("已经签到，不能重复签到");
      }
    }, "json")
  })

  $("#signout").click(function () {

    $.post("DutyServlet?method=signout", function (date) {
      if(date==1){
        $("#result").html("签退成功");
      }else if(date==0){
        $("#result").html("签退失败");
      }else{
        $("#result").html("尚未签到");
      }
    }, "json")

  })
</script>
</body>
</html>
