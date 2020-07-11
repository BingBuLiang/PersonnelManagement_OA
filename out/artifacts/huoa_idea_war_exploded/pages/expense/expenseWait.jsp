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
  <title>报销管理~我的报销</title>
  <base href="<%=basePath%>">
  <jsp:include page="/pages/include/link.jsp"/>


</head>
<div class="hold-transition sidebar-mini">
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
              <h1>我的报销</h1>
            </div>
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="#">报销管理</a></li>
                <li class="breadcrumb-item active">我的报销</li>
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
                  <form action="ExpenseServlet?method=findExpMe" method="post">
                    <input type="text" name="empId" value="${sessionScope.emp.empId}" style="display: none;">
                    <div class="form-group  col-sm-4  d-inline-block">
                      <label>报销类型</label>
                      <select class="form-control  " style="width: 70%;display: initial;" name="type">
                        <option value="1">通信费用</option>
                        <option value="2">办公室耗材</option>
                        <option value="3">住宿费用</option>
                        <option value="4">房租水电</option>
                        <option value="5">其他</option>
                      </select>
                    </div>
                    <div class="form-group  col-sm-2 d-inline-block">
                      <label>是否通过</label>
                      <div class="form-check  d-inline">
                        <input class="form-check-input" type="radio" name="status" value="5" checked="checked">
                        <label class="form-check-label">是</label>
                      </div>
                      <div class="form-check d-inline">
                        <input class="form-check-input" type="radio" name="status" value="">
                        <label class="form-check-label">否</label>
                      </div>
                    </div>
                    <label>报销时间</label>
                    <div class="form-group d-inline-block">

                      <div class="input-group date" id="reservationdate" data-target-input="nearest">
                        <input type="text" class="form-control" data-inputmask-alias="datetime"
                               data-inputmask-inputformat="yyyy-mm-dd" data-mask="" name="expTime">
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
                      <th></th>
                      <th>报销总额</th>
                      <th>报销时间</th>
                      <th>总备注信息</th>
                      <th>查看具体报销项</th>
                      <th>查看所附图片</th>
                      <th>状态</th>
                      <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${expenseList }" var="exp" varStatus="idx">
                      <tr>
                        <th>${idx.index+1}</th>
                        <td>${exp.totalAmount }</td>
                        <td>${exp.expTime }</td>
                        <td>${exp.expDesc }</td>
                        <td>
                          <a href="javascript:;" class="seeItems" data-toggle="modal"
                             data-target="#seeItems">查看具体报销项</a>
                        </td>
                        <td>
                          <a href="javascript:;" class="seeImg" data-toggle="modal" data-target="#seeImg">查看所附图片</a>
                          <img src="upload/${exp.expImage.fileName}" style="display: none;">
                        </td>
                        <td>
                          <c:if test="${exp.status=='0'}">
                            新创建
                          </c:if>
                          <c:if test="${exp.status=='1'}">
                            审核中
                          </c:if>

                          <c:if test="${exp.status=='2'}">
                            审核结束通过
                          </c:if>

                          <c:if test="${exp.status =='3'}">
                            审核拒绝
                          </c:if>

                          <c:if test="${exp.status =='4'}">
                            审核打回
                          </c:if>

                          <c:if test="${exp.status =='5'}">
                            已打款
                          </c:if>

                        </td>

                        <td>
                          <a href="javascript:;" class="findAudit" data-toggle="modal"
                             data-target="#audit">审核</a> &nbsp; &nbsp;
                          <span style="display: none">${exp.expId}</span>
                          <a href="javascript:;" class="findInfo" data-toggle="modal"
                             data-target="#seeRecord">查看审核记录</a>

                        </td>
                      </tr>
                    </c:forEach>


                    </tbody>
                    <tfoot>
                    <tr>
                      <th></th>
                      <th>报销总额</th>
                      <th>报销时间</th>
                      <th>总备注信息</th>
                      <th>查看具体报销项</th>
                      <th>查看所附图片</th>
                      <th>状态</th>
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


  <div class="content">
    <c:forEach items="${expenseList }" var="exp">

      <!-- 模态框（Modal） 查看具体报销项-->
      <div class="modal fade" id="seeItems${exp.expId}" tabindex="-1" role="dialog"
           aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                &times;
              </button>
              <h4 class="modal-title">
                查看具体报销项
              </h4>
            </div>
            <div class="modal-body">
              <c:forEach items="${exp.itemList }" var="expItem" varStatus="idx">
                <div class="card card-success">
                  <div class="card-header">
                    <h3 class="card-title">第--${idx.index+1}--项</h3>
                  </div>
                  <div class="card-body">
                    <label>费用：</label>

                    <br>
                    <label>描述：</label>
                    <sapn>${expItem.itemDesc}</sapn>
                    <br>
                  </div>
                  <!-- /.card-body -->

                </div>
              </c:forEach>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">关闭
              </button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal -->

      </div>


      <!-- 模态框（Modal）结束 -->

    </c:forEach>
  </div>


</div>
<!-- 模态框（Modal） 查看审核图片-->
<div class="modal fade" id="seeImg" tabindex="-1" role="dialog" aria-labelledby="imgModalLabel"
     aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="imgModalLabel">
          查看所附图片
        </h4>
      </div>
      <div class="modal-body" style="width: 100%;">
        <img src="" class="showImg" width="450px" height="300px"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->

</div>
<!-- 模态框（Modal）结束 -->


<!-- 模态框（Modal） 审核-->
<div class="modal fade" id="audit" tabindex="-1" role="dialog" aria-labelledby="auditLabel"
     aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="auditLabel">
          审核
        </h4>
      </div>
      <div class="modal-body" style="width: 100%;">
        <%-- 这里考虑js 验证使用 onsubmit="return 函数" --%>
        <form action="ExpenseServlet?method=audit"  method="post" >
          <input name="expId" type="hidden" id="auditExpId" value="" />
          <ul class="forminfo">
            <li>
              <label>审核结果：&nbsp;</label>
              <input name="result" type="radio" value="通过"/>通过
              <input name="result" type="radio" value="拒绝"/>拒绝
              <input name="result" type="radio" value="打回"/>打回
            </li>
            <li>
              <label>审核意见：&nbsp;</label>
              <textarea  id="auditDesc"  class="form-control" rows="5" placeholder="Enter ..." name="auditDesc"></textarea>
            </li>
            <li>
              <label>&nbsp;</label>
              <input name="" id="auditSure" type="submit" class="btn btn-block btn-success col-3" value="确认保存">
            </li>
          </ul>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->

</div>
<!-- 模态框（Modal）审核 结束 -->


<!-- 模态框（Modal） 查看审核记录-->
<div class="modal fade" id="seeRecord" tabindex="-1" role="dialog" aria-labelledby="recordModalLabel"
     aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="recordModalLabel">
          查看审核记录
        </h4>
      </div>
      <div class="modal-body">
        <h3>查看审核记录</h3>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->

</div>


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


<!-- 模态框（Modal）结束 -->
<script>
  $(function () {

    $(".seeItems").click(function () {
      $("#seeItems").modal("show");
    })


    $(".seeImg").click(function () {
      $("#seeImg").modal("show");
    })


    $(".seeRecord").click(function () {
      $("#seeRecord").modal("show");
    })

    /**
     * 触发查看图片操作
     */
    $(".seeImg").bind("click", function () {
      //获取要展示的的图片src
      var src = $(this).next("img").attr("src");
      //写入地址
      $(".showImg").attr("src", src);
    })
    /**
     * 触发审核操作
     */
    $(".findAudit").bind("click",function () {
        var expId=$(this).next("span").text();
        $("#auditExpId").val(expId);
    });
/*
    $("#auditSure").click(function () {
//获取表单项的值

      var expId = $("#auditExpId").val();
      var result = "";
      var resultArr = $("input[name=result]");
      for(var i=0;i<resultArr.length;i++){
        var flag = $(resultArr[i]).prop("checked");//1.4使用attr，1.6之后使用prop
        //var flag = resultArr[i].checked;
        if(flag){
          result = $(resultArr[i]).val();
          //result = resultArr[i].value;
          break;
        }
      }
      var auditDesc = $("#auditDesc").val();

      //通过Ajax提交表单，根据结果调用回调函数
    alert("expId"+expId+"\t result"+result+"\t auditDesc"+auditDesc);
      //var data="{expId:"+expId+",result:"+result+",auditDesc:"+auditDesc+"}";
      $.ajax({
        url:"ExpenseServlet?method=audit",
        type:"POST",
        data:{expId:expId,result:result,auditDesc:auditDesc},
        dataType:"text",
        success:function(data){
         //alert(data);
          if(data=="success"){
            alert("审核成功");
            //刷新父窗口
            //window.location.reload();//刷新当前窗口
            //window.opener.location.reload();
            //关闭当前窗口
           // window.close();

          }else{
            alert("审核失败");
          }
        }
      });
    /!*  $.post("ExpenseServlet?method=audit", data, function (emp) {
alert(data);
      });*!/
    });
  */
  })
</script>

</html>

