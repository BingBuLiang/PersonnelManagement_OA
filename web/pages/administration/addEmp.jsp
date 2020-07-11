<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/9
  Time: 22:13
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
  <title>人事管理~添加员工</title>
  <base href="<%=basePath%>">
<jsp:include page="/pages/include/link.jsp"/>
  <script>
    function deleteEmp(empId){
      var flag = window.confirm("您确认要删除该员工吗？");//bat flag
      if(flag){
        location.href="servlet/EmployeeServlet?method=delete&empId2="+empId;
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
            <h1>员工管理</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">人事管理</a></li>
              <li class="breadcrumb-item active">添加员工</li>
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
                每个同志的加入，都是一次进步
                <small style="color:red;">${error}</small>
              </h3>
            </div>


            <!-- /.card-header -->
            <div class="card-body pad">
              <form action="EmployeeServlet?method=add" method="post">

                <div class="form-group col-sm-4 ">
                  <label>花名</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="花名" name="empId">
                  </div>
                </div>

                <div class="form-group col-sm-5">
                  <label>真实姓名</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="真实姓名" name="realName">
                  </div>
                </div>
                <div class="form-group  col-sm-4 ">
                  <label>性别&nbsp; &nbsp;</label>
                  <div class="form-check  d-inline">
                    <input class="form-check-input" type="radio" name="sex" checked="checked" value="男">
                    <label class="form-check-label">男</label>
                  </div>
                  <div class="form-check d-inline">
                    <input class="form-check-input" type="radio" name="sex" value="女">
                    <label class="form-check-label">女</label>
                  </div>
                </div>


                <div class="form-group  col-sm-4">
                  <label>出生日期</label>
                  <div class="input-group date " id="birthDate" data-target-input="nearest">
                    <input type="text" class="form-control" data-inputmask-alias="datetime"
                           data-inputmask-inputformat="yyyy-mm-dd" data-mask="" name="birthDate">
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
                           data-inputmask-inputformat="yyyy-mm-dd" data-mask="" name="hireDate">
                    <!--  <input type="text" class="form-control datetimepicker-input" data-target="#reservationdate" data-inputmask-alias="datetime"  data-inputmask-inputformat="YYYY-MM-DD"    inputmode="numeric"> -->
                    <div class="input-group-append" data-target="#hireDate" data-toggle="datetimepicker">
                      <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                  </div>
                </div>


                <div class="form-group  col-sm-4">
                  <label>离职时间</label>
                  <div class="input-group date  " id="leaveDate" data-target-input="nearest">
                    <input type="text" class="form-control" data-inputmask-alias="datetime"
                           data-inputmask-inputformat="yyyy-mm-dd" data-mask="" name="leaveDate" disabled>
                    <!--  <input type="text" class="form-control datetimepicker-input" data-target="#reservationdate" data-inputmask-alias="datetime"  data-inputmask-inputformat="YYYY-MM-DD"    inputmode="numeric"> -->
                    <div class="input-group-append" data-target="#leaveDate" data-toggle="datetimepicker">
                      <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                  </div>
                </div>
                <div class="form-group  col-sm-4 ">
                  <label>是否在职
                  </label>
                  <div class="form-check  d-inline">
                    <input class="form-check-input" type="radio" name="onDuty" checked="checked" value="1">
                    <label class="form-check-label">是</label>
                  </div>
                  <div class="form-check d-inline">
                    <input class="form-check-input" type="radio" name="onDuty" disabled value="0">
                    <label class="form-check-label">否</label>
                  </div>
                </div>

                <div class="form-group  col-sm-6 ">
                  <label>员工类型
                  </label>
                  <div class="form-check  d-inline">
                    <input class="form-check-input" type="radio" name="empType" checked="checked" value="1">
                    <label class="form-check-label">基层员工</label>
                  </div>
                  <div class="form-check d-inline">
                    <input class="form-check-input" type="radio" name="empType" value="2">
                    <label class="form-check-label">各级管理人员</label>
                  </div>
                </div>
                <div class="form-group  col-sm-4  ">
                  <label>所属部门<b>*</b></label>
                  <select class="form-control  " style="width: 70%;display: initial;" name="deptno">
                    <c:forEach items="${deptList }" var="dept">
                      <option value="${dept.deptno }">${dept.deptName }</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="form-group  col-sm-4  ">
                  <label>从事岗位<b>*</b></label>
                  <select class="form-control  " style="width: 70%;display: initial;" name="posId">
                    <option value="1">总裁</option>
                    <option value="2">总裁助理</option>
                    <option value="3">人力资源总监</option>
                    <option value="4">销售总监</option>
                    <option value="5">技术总监</option>
                  </select>
                </div>
                <div class="form-group  col-sm-4  ">
                  <label>直接上级<b>*</b></label>
                  <select class="form-control  " style="width: 70%;display: initial;" name="mgrId">
                    <option value="">没有上级</option>
                    <c:forEach items="${mgrList }"  var="mgr">
                      <option value="${mgr.empId }">${mgr.realName }</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="form-group col-sm-5 ">
                  <label>联系方式</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="联系方式" name="phone">
                  </div>
                </div>

                <div class="form-group col-sm-5 ">
                  <label>QQ号</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="QQ号" name="qq">
                  </div>
                </div>
                <div class="form-group col-sm-5 ">
                  <label>身份证号</label>
                  <div class="form-inline  d-inline">
                    <input type="text" class="form-control " placeholder="身份证号" name="idCard">
                  </div>
                </div>

                <div class="form-group d-inline-block">
                  <label>紧急联系人信息</label>
                  <div class="">
                    <textarea name="emerContactPerson" class="textarea" placeholder="Place some text here" style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                  </div>

                </div>
                <div class="form-group col-sm-2 ">
                  <button type="submit" class="btn btn-block btn-outline-success">提交</button> </div>
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
  $(function() {
    // Summernote
    $('.textarea').summernote()
  })
</script>

<!-- Page script -->
<script>
  $(function() {
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
</body>
</html>

