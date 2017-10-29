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

<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/bootstrap/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css" />
<link href="../css/exam/exam.css" rel="stylesheet">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<span class="brand"><strong>上机考试系统</strong></span>

				<ul class="nav navbar-nav">
					<li><a href="main"><i class="icon-home icon-white"></i>首页</a></li>
					<li><a href="listdir"><i class="icon-eye-open icon-white"></i>查看提交</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><span class="brand"><small>欢迎，${name }</small></span></li>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<h1>
			<img src="../img/exam/exam-student.png" /> 上机考试中...
		</h1>
	</div>
