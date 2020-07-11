

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

  <title>支出统计</title>
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
            <h1 class="m-0 text-dark">支出统计</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">收支管理</a></li>
              <li class="breadcrumb-item active">支出统计</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">

      <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
      <div style="height: 100px; width: 500px;  margin:0px auto;">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        请选择支出时间段：
        <select class="select1" id="select1" onchange="changePie(this.value)">
          <option value="0">不限</option>
          <option value="1">本月</option>
          <option value="2">今年上半年</option>
          <option value="3">去年全年</option>
        </select>
      </div>
      <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
      <div id="container" style="height: 300px;width: 50%;margin:0px auto;"></div><!-- /.container-fluid -->

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
  $(function(e) {
    $(".select1").uedSelect({
      width : 200
    });

  });

  $(function(){
    changePie(0);
  });

  function changePie(val){
    //发送Ajax请求
    $.ajax({
      url:"IncomeServlet?method=getPieData",
      data:{type:val},
      type:"POST",
      dataType:"text",
      success:function(data){
        eval("var arr="+data);
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var option = {
          title : {
            text: '支出信息统计',
            subtext: '报销统计',
            x:'center'
          },
          tooltip : {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: ['通信费用','办公室耗材','住宿费用','房租水电','其他']
          },
          series : [
            {
              name: '细节情况',
              type: 'pie',
              radius : '55%',
              center: ['50%', '60%'],
              data:arr,
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        };
        ;
        if (option && typeof option === "object") {
          myChart.setOption(option, true);
        }
      }
    });
  }
</script>


</body>
</html>
