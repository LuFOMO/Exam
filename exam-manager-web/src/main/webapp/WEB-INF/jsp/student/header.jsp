<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
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

<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://static.bootcss.com/www/assets/css/site.min.css?1509529436504" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/easyui/themes/default/easyui.css" />
<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
<style type="text/css">
.exam-info {

    padding: 10px;
    background-color: #ccc;
    color: #FFF;
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
}

</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav navbar-nav">
				<li><a href="/student/main"><span class="glyphicon glyphicon-home"></span>首页</a></li>
					<li><a href="/student/exam/paper/list"><span class="glyphicon glyphicon-eye-open"></span>查看提交</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><h4><p style="color:white">欢迎，${name }</p></h4></li>
					<li><a href="/student/logout"><span class="glyphicon glyphicon-share"></span>退出</a></li>
				</ul>
			</div>
		</div>
	</div>
