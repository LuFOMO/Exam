<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师登录</title>
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
</style>
</head>
<body>
	<div class="img-index">
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
	<div class="container">
		<ul id="loginTab" class="nav nav-pills">
			<li><a href="/">学生登录</a></li>
			<li class="active"><a href="teacher_login">教师登录</a></li>
			<li><a href="admin_login">管理员登录</a></li>
		</ul>
	</div>
	<br>
	<div class="container  text-center "
		style="width: 300px; height: 300px;">
		<form class="form-signin" action="/teacher/login" method="post">
			<br /> 
			<input class="form-control" type="text" name="name" placeholder="请输入用户名" required autofocus /> <br /> 
			<input class="form-control" type="password" name="pass" placeholder="请输入密码" required autofocus /><br />
			 <input type="submit" class="btn btn-lg btn-primary btn-block" value="登录" />
		</form>
	</div>
	</div>
		<!-- Placed at the end of the document so the pages load faster -->
	<script src="http://code.jquery.com/jquery-3.2.1.js" defer></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</body>
</html>