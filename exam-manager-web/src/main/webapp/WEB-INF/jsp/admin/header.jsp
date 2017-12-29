<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
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

<link rel="stylesheet" type="text/css" href="<%=basePath %>js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/easyui/themes/icon.css" />

<!-- Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://static.bootcss.com/www/assets/css/site.min.css?1509529436504" rel="stylesheet">
<style type="text/css">
.exam-form {
    padding: 20px;
    background-color: #EEE;
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
					<li><a href="/admin/main">
					<span class="glyphicon glyphicon-home"></span>  首页</a></li>
					<li><a href="/admin/teacher">
					<span class="glyphicon glyphicon-user"></span>  教师管理</a></li>
					<li><a href="/admin/exam">
					<span class="glyphicon glyphicon-remove-circle"></span>  考试清理</a></li>
					<li><a href="/admin/system/config">
					<span class="glyphicon glyphicon-wrench"></span>  系统配置</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><h4><p style="color:white;">欢迎，${name }</p></h4></li>
					<li><a href="#" data-toggle="modal"	data-target=".bs-example-modal-sm">
					<i class="glyphicon glyphicon-pencil"></i>  修改口令</a></li>
					<li><a href="/admin/logout"><span class="glyphicon glyphicon-share"></span>  退出</a></li>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="modal fade bs-example-modal-sm span5" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body" align="right">
					<form id="editPass" class="exam-form" method="post" action="/admin/password/edit">
						<p>
							<input type="hidden" name="name" value=${name } style="width: 100%" /> <br />
							<input type="password"name="oldpass" placeholder="原密码" style="width: 100%" /> <br />
							 <input type="password" id="pass1" name="newpass1" placeholder="新密码"
								style="width: 100%" /> <br /> <input type="password" id="pass2"
								name="newpass2" placeholder="重输新密码" style="width: 100%" /> <br />
							<input type="submit" class="btn btn-primary" value="修改"style="width: 100%" /> 
							<span id="span1"></span>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
	<script type="text/javascript">
		$(function() {
			$("#pass2").blur(function() {
				var $pass1 = $("#pass1").val();
				var $pass2 = $("#pass2").val();
				if ($pass1 != $pass2) {
					$("#span1").html("<font color='red'>两次密码不一致</font>");
				}
			});
		}); 
	</script>