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
  <title>人事管理~添加员工</title>
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
            <h1>员工管理</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">人事管理</a></li>
              <li class="breadcrumb-item active">员工管理</li>
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
                <form action="EmployeeServlet?method=findEmp" method="post">
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
                  <div class="form-group  col-sm-2 d-inline-block">
                    <label>是否在职</label>
                    <c:if test="${onDuty ==1 }">
                      <div class="form-check  d-inline">
                        <input class="form-check-input" type="radio" name="onDuty" value="1" checked="checked">
                        <label class="form-check-label">是</label>
                      </div>
                      <div class="form-check d-inline">
                        <input class="form-check-input" type="radio" name="onDuty" value="0">
                        <label class="form-check-label">否</label>
                      </div>
                    </c:if>
                    <c:if test="${onDuty ==0 }">
                      <div class="form-check  d-inline">
                        <input class="form-check-input" type="radio" name="onDuty" value="1">
                        <label class="form-check-label">是</label>
                      </div>
                      <div class="form-check d-inline">
                        <input class="form-check-input" type="radio" name="onDuty" value="0" checked="checked">
                        <label class="form-check-label">否</label>
                      </div>
                    </c:if>
                    <c:if test="${empty onDuty }">
                      <div class="form-check  d-inline">
                        <input class="form-check-input" type="radio" name="onDuty" value="1" checked="checked">
                        <label class="form-check-label">是</label>
                      </div>
                      <div class="form-check d-inline">
                        <input class="form-check-input" type="radio" name="onDuty" value="0">
                        <label class="form-check-label">否</label>
                      </div>
                    </c:if>

                  </div>
                  <label>入职时间</label>
                  <div class="form-group d-inline-block">

                    <div class="input-group date" id="reservationdate" data-target-input="nearest">
                      <input type="text" class="form-control" data-inputmask-alias="datetime"
                             data-inputmask-inputformat="yyyy-mm-dd" data-mask="" value="${hireDate}" name="hireDate">
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
                    <th>所属岗位</th>
                    <th>上级编号</th>
                    <th>上级姓名</th>
                    <th>入职时间</th>
                    <th>联系方式</th>
                    <th>操作</th>
                  </tr>
                  </thead>
                  <tbody>
                  <%-- <tr>
                     <td>Trident</td>
                     <td>Internet
                       Explorer 4.0
                     </td>
                     <td>Win 95+</td>
                     <td> Win 95+</td>
                     <td>2007-10-1</td>
                     <td>12345678091</td>
                     <td>
                       <a href="#">查看</a>
                       <a href="#">修改</a>
                       <a href="#">删除</a>
                       <a href="#">重置密码</a>
                     </td>
                   </tr>--%>
                  <c:forEach items="${empList }" var="emp">
                    <tr>
                      <td>${emp.empId }</td>
                      <td>${emp.realName }</td>
                      <td>${emp.dept.deptName }</td>
                      <td>${emp.position.posName }</td>
                      <td>${emp.mgr.empId }</td>
                      <td>${emp.mgr.realName }</td>
                      <td>${emp.hireDate }</td>
                      <td>${emp.phone }</td>
                      <td>
                        <a href="javascript:;" class="findInfo" data-toggle="modal" data-target="#myModal">查看</a>

                        <a href="EmployeeServlet?method=toUpdate&empId=${emp.empId }">修改</a>
                        <a href="javascript:void(0)" onclick="deleteEmp('${emp.empId}')"> 删除</a>

                        <a href="javascript:;" class="resetpwd" data-toggle="modal" data-target="#resetpwd">重置密码</a>
                       <%-- <a href="EmployeeServlet?method=resetpwd&empId=${emp.empId }"> 重置密码</a>--%>
                      </td>
                    </tr>
                  </c:forEach>


                  </tbody>
                  <tfoot>
                  <tr>
                    <th>花名</th>
                    <th>真实姓名</th>
                    <th>所属部门</th>
                    <th>所属岗位</th>
                    <th>上级编号</th>
                    <th>上级姓名</th>
                    <th>入职时间</th>
                    <th>联系方式</th>
                    <th>操作</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->

              <!-- 模态框（Modal） -->
              <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                   aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                      </button>
                      <h4 class="modal-title" id="myModalLabel">
                        个人信息展示
                      </h4>
                    </div>
                    <div class="modal-body">
                      <h3>“‘’‘’‘’‘’</h3>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                      </button>
                    </div>
                  </div><!-- /.modal-content -->
                </div><!-- /.modal -->

              </div>
              <!-- 模态框（Modal）结束 -->

              <!-- 模态框（Modal） -->
              <div class="modal fade" id="resetpwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                   aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                      </button>
                      <h4 class="modal-title" id="resetpwdinfo">
                        个人信息展示
                      </h4>
                    </div>
                    <div class="modal-body">
                      <!-- form start -->
                      <form class="form-horizontal" action="EmployeeServlet" method="post" >
                        <input type="hidden" name="method" value="setPassword">
                        <input type="hidden" value=""  name="empId">
                        <div class="card-body">
                          <div class="form-group row">
                            <label for="oldPassword" class="col-sm-2 col-form-label">旧密码</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="oldPassword" placeholder="旧密码" name="oldPassword">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="newPassword" class="col-sm-2 col-form-label">新密码</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="newPassword" placeholder="新密码" name="newPassword">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-sm-2 col-form-label">验证码</label>
                            <div class="col-sm-5">
                              <input name="verifyCode" type="text" class="form-control " placeholder="验证码" onclick="JavaScript:this.value=''"/>
                            </div>
                            <div class="col-sm-5">
                              <cite><img src="random.jpg" alt="" id="randImg" onclick="changeRandom()"/></cite>
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
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                      </button>
                    </div>
                  </div><!-- /.modal-content -->
                </div><!-- /.modal -->

              </div>
              <!-- 模态框（Modal）结束 -->
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
  $(function() {
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


<script>

  $(".findInfo").click(function () {
    var empId = $(this).parents("tr").children(':first-child').text();

    $.post(" EmployeeServlet?method=findByIdInfo", "empId=" + empId, function (emp) {
    /*  var sexStr="";
      if(emp.sex==1){
        sexStr="男";
      }else{
        sexStr="女";
      }*/

      var strHtml = "<p>花名：" +emp.empId +"</p><br>" +
        "<p> 真实姓名：" +emp.realName + "</p><br>" +
        "<p> 性别：" +emp.sex + "</p><br>" +
        "<p> 就职日期：" + emp.hireDate+ "</p><br>" +
        "<p> 联系方式：" + emp.phone  + "</p><br>" +
        "<p> qq：" + emp.qq+ "</p><br>" +
        "<p>紧急联系人：" +emp.emerContactPerson + "</p><br>" ;

      $(".modal-body").html(strHtml);
    }, "json")


  })
</script>

</body>
</html>

