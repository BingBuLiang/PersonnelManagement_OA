<%--
  Created by IntelliJ IDEA.
  User: 23301
  Date: 2020/6/10
  Time: 7:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>登录页</title>

  <!-- begin::global styles -->
  <link rel="stylesheet" href="assets/vendors/bundle.css" type="text/css">
  <!-- end::global styles -->

  <!-- begin::custom styles -->
  <link rel="stylesheet" href="assets/css/app.css" type="text/css">
  <!-- end::custom styles -->
  <script>
    function changeRandom() {
      //alert("ok");
      //获取图片
      //修改图片的地址
      $("#randImg").attr("src", "random.jpg?time=" + new Date().toLocaleString());

    }
  </script>
</head>
<body class="bg-white h-100-vh p-t-0">

<!-- begin::page loader-->
<div class="page-loader">
  <div class="spinner-border"></div>
  <span>Loading ...</span>
</div>
<!-- end::page loader -->

<div class="p-b-50 d-block d-lg-none"></div>

<div class="container h-100-vh">
  <div class="row align-items-md-center h-100-vh">
    <div class="col-lg-6 d-none d-lg-block">
      <img class="img-fluid" src="assets/media/svg/login.svg" alt="...">
    </div>
    <div class="col-lg-4 offset-lg-1">
      <div class="d-flex align-items-center m-b-20">
        <img src="assets/media/image/dark-logo.png" class="m-r-15" width="40" alt="">
        <h3 class="m-0">新的一天保持开心</h3>
      </div>
      <p>来一起开黑</p><span style="color: red;">${error}</span>
      <form action="EmployeeServlet?method=login" method="post">
        <div class="form-group mb-4">
          <input name="empId" type="text" class="form-control form-control-lg"  autofocus
                 placeholder="输入你的花名吧!">
        </div>
        <div class="form-group mb-4">
          <input name="password"  type="password" class="form-control form-control-lg" id="exampleInputPassword1"
                 placeholder="除了我,密码可不能告诉别人">
        </div>

        <div class="form-row mb-4">
          <div class="col-7">
            <input name="verifyCode" type="text" class="form-control " placeholder="验证码" onclick="JavaScript:this.value=''"/>
          </div>
          <div class="col">
            <cite><img src="random.jpg" alt="" id="randImg" onclick="changeRandom()"/></cite>

            <!-- <img src="random.jpg" alt="" id="randImg" onclick="changeRandom()" /> -->
            <!-- <cite><img src="random.jpg" alt="" id="randImg" onclick="changeRandom()" /> </cite>-->
          </div>
        </div>

        <!--提交按钮-->
        <button  type="submit"  class="btn btn-primary btn-lg btn-block btn-uppercase mb-4">开始工作</button>
        <div class="d-flex justify-content-between align-items-center mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck">
            <label class="custom-control-label" for="customCheck">保持身材</label>
          </div>
          <a href="#" class="auth-link text-black">忘记密码？</a>
        </div>

      </form>
    </div>
  </div>
</div>

<!-- begin::global scripts -->
<script src="assets/vendors/bundle.js"></script>
<!-- end::global scripts -->

<!-- begin::custom scripts -->
<script src="assets/js/app.js"></script>
<!-- end::custom scripts -->

</body>
</html>
