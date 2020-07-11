<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/15
  Time: 20:45
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
  <title>个人平台</title>
  <base href="<%=basePath%>">
  <jsp:include page="/pages/include/link.jsp"/>
  <script>
    function deleteEmp(empId) {
      var flag = window.confirm("您确认要删除该员工吗？");//bat flag
      if (flag) {
        location.href = "servlet/EmployeeServlet?method=delete&empId2=" + empId;
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
            <h1>我的信息</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">个人平台</a></li>
              <li class="breadcrumb-item active">我的信息</li>
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
                美丽的不是这个世界，而是接受了这个世界的你的眼睛
                <small style="color:red;">${error}</small>
              </h3>
            </div>


            <!-- /.card-header -->
            <div class="card-body pad">
              <form action="EmployeeServlet?method=update" method="post">

                <div class="form-group col-sm-4 ">
                  <label>花名</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="花名" name="empId"
                           value="${sessionScope.emp.empId}" readonly>
                  </div>
                </div>

                <div class="form-group col-sm-5">
                  <label>真实姓名</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="真实姓名" name="realName"
                           value="${sessionScope.emp.realName}" readonly>
                  </div>
                </div>
                <div class="form-group  col-sm-4 ">
                  <label>性别&nbsp; &nbsp;</label>
                  <c:if test="${sessionScope.emp.sex =='男'}">
                    <div class="form-check  d-inline">
                      <input class="form-check-input" type="radio" name="sex" checked="checked" value="男">
                      <label class="form-check-label">男</label>
                    </div>
                    <div class="form-check d-inline">
                      <input class="form-check-input" type="radio" name="sex" value="女">
                      <label class="form-check-label">女</label>
                    </div>
                  </c:if>

                  <c:if test="${sessionScope.emp.sex =='女'}">
                    <div class="form-check  d-inline">
                      <input class="form-check-input" type="radio" name="sex" value="男">
                      <label class="form-check-label">男</label>
                    </div>
                    <div class="form-check d-inline">
                      <input class="form-check-input" type="radio" name="sex" checked="checked" value="女">
                      <label class="form-check-label">女</label>
                    </div>
                  </c:if>
                </div>


                <div class="form-group  col-sm-4">
                  <label>出生日期</label>
                  <div class="input-group date " id="birthDate" data-target-input="nearest">
                    <input type="text" class="form-control" data-inputmask-alias="datetime"
                           data-inputmask-inputformat="yyyy-mm-dd" data-mask="" name="birthDate"
                           value="${sessionScope.emp.birthDate}">
                    <!--  <input type="text" class="form-control datetimepicker-input" data-target="#reservationdate" data-inputmask-alias="datetime"  data-inputmask-inputformat="YYYY-MM-DD"    inputmode="numeric"> -->
                    <div class="input-group-append" data-target="#birthDate" data-toggle="datetimepicker">
                      <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                  </div>
                </div>

                <div class="form-group  col-sm-4">
                  <label>入职时间</label>
                  <div class="input-group date  " id="hireDate" data-target-input="nearest">
                    <input type="text" class="form-control" data-inputmask-alias="datetime"
                           data-inputmask-inputformat="yyyy-mm-dd" data-mask="" name="hireDate"
                           value="${sessionScope.emp.hireDate}" readonly>
                    <!--  <input type="text" class="form-control datetimepicker-input" data-target="#reservationdate" data-inputmask-alias="datetime"  data-inputmask-inputformat="YYYY-MM-DD"    inputmode="numeric"> -->
                    <div class="input-group-append" data-target="#hireDate" data-toggle="datetimepicker">
                      <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                  </div>
                </div>


                <div class="form-group col-sm-5 ">
                  <label>联系方式</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="联系方式" name="phone"
                           value="${sessionScope.emp.phone}">
                  </div>
                </div>

                <div class="form-group col-sm-5 ">
                  <label>QQ号</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="QQ号" name="qq" value="${sessionScope.emp.qq}">
                  </div>
                </div>


                <div class="form-group d-inline-block">
                  <label>紧急联系人信息</label>
                  <div class="">
                    <textarea name="emerContactPerson" id="emerContactPerson" class="textarea"
                              placeholder="Place some text here"
                              style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>

                    <input type="text" id="contactPersonInfo" value="${sessionScope.emp.emerContactPerson}"
                           style="display: none;">
                  </div>

                </div>
                <div class="form-group col-sm-2 ">
                  <button type="submit" class="btn btn-block btn-outline-success">修改</button>
                </div>
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


<jsp:include page="/pages/include/jQuary.jsp"/>

<script>
  $(function () {
    // Summernote
    $('.textarea').summernote()
  })
</script>

<!-- Page script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

    //Initialize Select2 Elements
    $('.select2bs4').select2({
      theme: 'bootstrap4'
    })

    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('YYYY-MM-DD', {
      'placeholder': 'YYYY-MM-DD'
    })
    //Datemask2 mm/dd/yyyy
    $('#datemask2').inputmask('YYYY-MM-DD', {
      'placeholder': 'YYYY-MM-DD'
    })
    //Money Euro
    $('[data-mask]').inputmask()

    //Date range picker
    $('#reservationdate').datetimepicker({
      format: 'YYYY-MM-DD'
    });

    $('#birthDate').datetimepicker({
      format: 'YYYY-MM-DD'
    });

    $('#hireDate').datetimepicker({
      format: 'YYYY-MM-DD'
    });
    $('#leaveDate').datetimepicker({
      format: 'YYYY-MM-DD'
    });
  })
</script>

<script>

  /* $(function () {
     window.onload = function () {

       var t = $(".contactPersonInfo").val();
       alert(t);
       $("#emerContactPerson").val(t);
     }

   })*/

  window.onload = function () {
    var t = document.getElementById("contactPersonInfo").value;
    document.getElementById("emerContactPerson").value = t;

  }
</script>
</body>
</html>


