<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>上机考试系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="css/exam/exam.css" rel="stylesheet">
<link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet">

<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>

</head>

<body>
	<div class="container">
		<ul id="loginTab" class="nav nav-tabs">
			<li class="active"><a href="#student" data-toggle="tab">学生登录</a>
			</li>
			<li><a href="#teacher" data-toggle="tab">教师登录</a></li>
			<li><a href="#admin" data-toggle="tab">管理员登录</a></li>
		</ul>

		<div id="loginTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="teacher">
				<div class="container">
					<div class="row vertical-center">
						<div class="exam-login">
							<h3>
								<img class="img-circle" src="/img/exam/exam-teacher.png" />
								教师登录
							</h3>

							<form class="exam-form" action="/teacher/login" method="post">
								<p>
									<input type="text" name="name" placeholder="用户名" /> <br />
									<input type="password" name="pass" placeholder="口令" />
								</p>
								<p>
									<input type="submit" class="btn btn-primary" value="登录"
										style="width: 100%" />
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade in active" id="admin">
				<div class="container">
					<div class="row vertical-center">
						<div class="exam-login">
							<h3>
								<img class="img-circle" src="/img/exam/exam-admin.png" />
								管理员登录
							</h3>

							<form class="exam-form" action="/admin/login" method="post">
								<p>
									<input type="text" name="name" placeholder="用户名" /> <br /> <input
										type="password" name="pass" placeholder="口令" />
								</p>
								<p>
									<input type="submit" class="btn btn-primary" value="登录"
										style="width: 100%" />
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade in active" id="student">
				<div class="container">
					<div class="exam-info">
							<h4 id="notLogin">当前没有进行中的考试，不能登录。</h4>
							<h4 id="login">考试正在进行，请输入学号和姓名登录。</h4>
					</div>
					<div class="row vertical-center">
						<div class="exam-login">
							<h3>
								<img class="img-circle" src="/img/exam/exam-student.png" />
								学生登录
							</h3>

							<form class="exam-form" action="/student/login" method="post">
								<p>
									<input type="text" name="sid" placeholder="学号" />
									<br />
									<input type="text" name="name" placeholder="姓名" />
								</p>
								<p>
									<input type="submit" id="studentLogin" class="btn" value="登录" 
										style="width: 100%" />
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery/jquery.min.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
	
	<!-- 判断学生是否可以登录 -->
	<script type="text/javascript">
		$.post("/exam/get", function(data){
			if(data.status==200){
				$("#notLogin").hide();
				$("#studentLogin").addClass("btn-primary");
			}else{
				$("#login").hide();
				$("#studentLogin").addClass("btn-disabled");
				$("#studentLogin").attr("disabled", true); 
			}
		})
	</script>
	
</body>
</html>