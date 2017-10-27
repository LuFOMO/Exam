<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>上机考试系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
	<s:head/>
	<sj:head/>

<!-- le styles -->
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/exam.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- le html5 shim, for ie6-8 support of html5 elements -->
<!--[if lt ie 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<span class="brand"><strong>上机考试系统</strong></span>

				<ul class="nav navbar-nav">
					<li><a href="student_main"><i class="icon-home icon-white"></i>首页</a></li>
					<li><a href="student_exam_listdir"><i class="icon-eye-open icon-white"></i>查看提交</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><span class="brand"><small>欢迎，<s:property
							value="#session.student" /></small></span></li>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<h1>
			<img src="assets/img/exam-student.png" /> <s:property value="#application.exam" /> 上机考试中...
		</h1>
