<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/10
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
  <title>考勤管理~考勤管理</title>
  <base href="<%=basePath%>">
  <jsp:include page="/pages/include/link.jsp"/>
  <script>
    function deleteEmp(empId) {
      var flag = window.confirm("您确认要删除该员工吗？");
      if (flag) {
        location.href = "EmployeeServlet?method=delete&empId2=" + empId;
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
            <h1>考勤管理</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">人事管理</a></li>
              <li class="breadcrumb-item active">考勤管理</li>
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
                <form action="DutyServlet?method=findDuty" method="post">

                  <div class="form-group  col-sm-4  d-inline-block">
                    <label>所属部门</label>
                    <select class="form-control  " style="width: 70%;display: initial;" name="deptno">
                      <option value="0">--全部--</option>
                      <c:forEach items="${deptList }" var="dept">
                        <c:if test="${dept.deptno == deptno}">
                          <option value="${dept.deptno }" selected="selected">${dept.deptName }</option>
                        </c:if>
                        <c:if test="${dept.deptno != deptno}">
                          <option value="${dept.deptno }">${dept.deptName }</option>
                        </c:if>
                      </c:forEach>
                    </select>
                  </div>

                  <label>考勤时间</label>
                  <div class="form-group d-inline-block">

                    <div class="input-group date" id="reservationdate" data-target-input="nearest">
                      <input type="text" class="form-control" data-inputmask-alias="datetime"
                             data-inputmask-inputformat="yyyy-mm-dd" data-mask="" value="${dtDate}" name="dtDate">
                      <%--  <input type="text" class="form-control datetimepicker-input" data-target="#reservationdate" >--%>
                      <div class="input-group-append" data-target="#reservationdate" data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                      </div>
                    </div>
                  </div>
                  <div class="form-group d-inline-block">
                    <div class="input-group-append">
                      <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>

                </form>
              </div>


              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>

                    <th>花名</th>
                    <th>真实姓名</th>
                    <th>所属部门</th>
                    <th>出勤日期</th>
                    <th>签到时间</th>
                    <th>签退时间</th>
                  </tr>

                  </thead>
                  <tbody>

                  <c:forEach items="${dutyList }" var="duty">
                    <tr>
                      <td>${duty.emp.empId }</td>
                      <td>${duty.emp.realName }</td>
                      <td>${duty.emp.dept.deptName }</td>
                      <td>${duty.dtDate }</td>
                      <td>${duty.signinTime }</td>
                      <td>${duty.signoutTime }</td>
                    </tr>
                  </c:forEach>


                  </tbody>
                  <tfoot>
                  <tr>
                    <th>花名</th>
                    <th>真实姓名</th>
                    <th>所属部门</th>
                    <th>出勤日期</th>
                    <th>签到时间</th>
                    <th>签退时间</th>
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


  })
</script>


</body>
</html>

