<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>上机考试系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="<%=basePath %>/img/mat/mat.ico">

<!-- Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--  Bootstrap 主题文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<style type="text/css">
.img-index {
	background-image: url('../img/exam/bg-index.png');
}
.exam-info {

    padding: 10px;
    background-color: #ccc;
    color: #FFF;
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
}
</style>


<!-- 判断学生是否可以登录 -->
<script type="text/javascript">
window.onpageshow=function(){
	$.post("/exam/get", function(data){
		if(data.status==200){
			$("#notLogin").hide();
			$("#studentLogin").addClass("btn-primary");
		}else{
			$("#login").hide();
			$("#studentLogin").addClass("btn-disabled");
			$("#studentLogin").attr("disabled", true); 
		}
	});
}
</script>
</head>
<body>
	<section class="img-index">
	<div class="jumbotron img-index">
		<div class="container">
			<div class="row">
				<div class="col-md-1 center-block:right">
					<img src="/img/mat/matternet.svg" style="with: 80px; height: 80px">
				</div>
				<div class="col-md-11 text-left">
					<h1>上机考试系统</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container ">
		<ul id="loginTab" class="nav nav-pills">
			<li class="active"><a href="index">学生登录</a></li>
			<li><a href="login/teacher_login">教师登录</a></li>
			<li><a href="login/admin_login">管理员登录</a></li>
		</ul>
		<br>
		<div class="exam-info">
			<h4 id="notLogin">当前没有进行中的考试，不能登录。</h4>
			<h4 id="login">考试正在进行，请输入学号和姓名登录。</h4>
		</div>
		<div class="container text-center "
			style="width: 300px; height: 300px;">
			<form class="form-signin" action="/student/login" method="post">
				<br>
				 <input class="form-control" type="text" name="sid" placeholder="请输入学号" required autofocus /> <br />
				  <input class="form-control" type="text" name="name" placeholder="请输入姓名" required autofocus /> <br /> 
				  <input type="submit" class="btn btn-lg  btn-block" id="studentLogin" value="登录" />
			</form>
		</div>
	</div>
	</section>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>