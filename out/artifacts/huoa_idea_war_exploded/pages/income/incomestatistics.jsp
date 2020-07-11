

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

  <title>收入统计</title>
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
            <h1 class="m-0 text-dark">收入统计</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">收支管理</a></li>
              <li class="breadcrumb-item active">收入统计</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">

      <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
      <div id="container" style="height: 500px;"></div><!-- /.container-fluid -->

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
<script src="plugins/bootstrap/js/sakura.js"></script>

<script type="text/javascript" src="plugins/chart.js/echarts.min.js"></script>
<script type="text/javascript">
  $(function(){
    $.ajax({
      url:"IncomeServlet?method=getBarData",
      success:function(data){
        //json string----json object
        eval("var arr = "+data);
        //
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        //
        var option = {
          color: ['#3398DB'],
          title: {
            text: '收入统计图表'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
              type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          xAxis: {
            type: 'category',
            data: arr[0]
          },
          yAxis: {
            type: 'value'
          },
          series: [{
            data: arr[1],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
              color: 'rgba(220, 220, 220, 0.8)'
            }
          }]
        };
        //
        if (option && typeof option === "object") {
          myChart.setOption(option, true);
        }

      }
    });

  });

</script>
</body>
</html>
