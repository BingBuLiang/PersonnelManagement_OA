<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/12
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>报销管理~添加报销</title>
  <base href="<%=basePath%>">
  <jsp:include page="/pages/include/link.jsp"/>

  <!-- bootstrap 文件上传-->
  <link href="plugins/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- 导航栏 -->
  <jsp:include page="/pages/include/menu.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="wrapper">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-6">
              <h1>添加报销</h1>
            </div>
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="#">报销管理</a></li>
                <li class="breadcrumb-item active">添加报销</li>
              </ol>
            </div>
          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card card-outline card-info">
              <div class="card-header">
                <h3 class="card-title">
                  每一次的报销都意味着一次付出
                  <small style="color: red;">${error}</small>
                </h3>
              </div>


              <!-- /.card-header -->
              <div class="card-body pad">
                <form action="ExpenseServlet?method=add" method="post" enctype="multipart/form-data">

                  <div class="form-group col-sm-5">
                    <label>报销人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <div class="form-inline  d-inline">
                      <input type="text" class="form-control " placeholder="花名" name="empId"
                             value="${sessionScope.emp.empId }" readonly="readonly"/>
                    </div>
                  </div>


                  <div class="form-group col-sm-5">
                    <label>真实姓名</label>
                    <div class="form-inline  d-inline">
                      <input type="text" class="form-control " placeholder="真实姓名" value="${sessionScope.emp.realName }"
                             readonly="readonly"/>
                    </div>
                  </div>

                  <div class="form-group col-sm-5">
                    <label>报销总额</label>
                    <div class="form-inline  d-inline">
                      <input type="text" class="form-control " placeholder=" total money 格式：xxx.00" name="totalAmount">
                    </div>
                  </div>


                  <div class="form-group  col-sm-5">
                    <label>报销时间</label>
                    <div class="form-inline  d-inline">
                      <input name="expTime" type="text" class="form-control"
                             onfocus="WdatePicker({skin:'whyGreen',lang:'en'})"/>
                    </div>
                  </div>


                  <div class="">
                    <label>具体报销项</label> <br>
                    <ul style=" list-style: none;">
                      <input type="button" class="add btn btn-block btn-default col-2" value="添加选项"/>
                      <li class="row">
                        <div class="col-3">
                          <span>报销类型</span><br>
                          <select class="form-control  " style="width: 70%;display: initial;" name="type">
                            <option value="1">通信费用</option>
                            <option value="2">办公室耗材</option>
                            <option value="3">住宿费用</option>
                            <option value="4">房租水电</option>
                            <option value="5">其他</option>
                          </select>
                        </div>

                        <div class="col-3">
                          <span>报销费用</span>

                          <input type="text" class="form-control " placeholder="格式：xxx.00" name="amount">

                        </div>

                        <div class="col-3">
                          <span>费用说明</span>
                          <div class="">
                            <textarea class="form-control" rows="3" placeholder="费用说明....." name="itemDesc"></textarea>
                          </div>
                        </div>


                      </li>
                      <hr/>
                    </ul>

                  </div>

                  <div class="form-group  col-sm-4 ">
                    <div class="controls">
                      <span>上传图片</span><br>
                      <div data-provides="fileupload" class="fileupload fileupload-new" style="margin-left: 50px;">
                        <div style="width: 250px; height: 250px;" class="fileupload-new thumbnail">
                          <img alt="" src="http://www.placehold.it/250x250/EFEFEF/AAAAAA&amp;text=no+image">
                        </div>
                        <div style="max-width: 200px; max-height: 200px; line-height: 20px;"
                             class="fileupload-preview fileupload-exists thumbnail"></div>
                        <div>
                            <span class="btn btn-file">
                              <button type="button" class="btn  btn-default btn-sm fileupload-new">选择照片</button>
                              <button type="button" class="btn  btn-default btn-sm fileupload-exists">更改</button>
                              <input type="file" name="photo" class="default" accept="image/*"></span>
                          <button type="button" data-dismiss="fileupload"
                                  class="btn  btn-default btn-sm fileupload-exists">去除
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>


                  <div class="form-group  col-sm-5">
                    <label>审批人*</label>
                    <div class="form-inline  d-inline" style="">
                      <input type="text" class="form-control " placeholder="name" name="nextAuditorId"
                             value="${sessionScope.emp.mgr.empId }"/>
                    </div>
                  </div>

                  <div class="form-group  col-sm-4">
                    <label>总备注信息</label>
                    <div class="">
                      <textarea class="form-control" rows="5" placeholder="Enter ..." name="expDesc"></textarea>
                    </div>
                  </div>

                  <!-- /.card-body -->
                  <div class="form-group col-sm-6 ">
                    <div class="row-cols-3 " style="">
                      <button type="submit" class="btn btn-block btn-outline-success">确认保存</button>
                    </div>
                    <div class="row-cols-3" style="">
                      <button type="reset" class="btn btn-default float-right">清除</button>
                    </div>
                  </div>
                  <!-- /.card-footer -->
                </form>
              </div>
            </div>
            <!-- /.col-->
          </div>
          <!-- ./row -->
        </div>
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


</div>
<!-- ./wrapper -->


<jsp:include page="/pages/include/jQuary.jsp"/>

<script src="plugins/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="plugins/My97DatePicker/WdatePicker.js"></script>

<script>
  $(function () {


    $(".remove").live("click", function () {
      $(this).parents("li").next().remove();
      $(this).parents("li").remove();
    })

    $(".add").live("click", function () {
      var htmlStr = $(this).next("li").html();

      htmlStr = htmlStr.substring(0, htmlStr.length - 7);
      htmlStr +=
        '<div class="col-2"> <input type="button" class="remove btn btn-block btn-outline-secondary" value="删除选项" />  </div><li>';
      htmlStr = ' <li class="row">' + htmlStr + "<hr />";

      $(this).parent().append(htmlStr);
    })

  })
</script>


</body>
</html>

