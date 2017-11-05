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

<!-- le styles -->
<link href="../css/bootstrap/bootstrap.css" rel="stylesheet">
<link href="../css/exam/exam.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css" />
<link href="../css/bootstrap/bootstrap-responsive.css" rel="stylesheet">
<link href="css/bootstrap/bootstrap-theme.min.css"  rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://static.bootcss.com/www/assets/css/site.min.css?1509529436504" rel="stylesheet">
</head>

<body>

</div>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">				
				<ul class="nav navbar-nav">
					<li><a href="main"><i class="icon-home icon-white"></i>首页</a></li>
					<li><a href="teacher"><i class="icon-user icon-white"></i>教师管理</a></li>
					<li><a href="exam"><i class="icon-remove-circle icon-white"></i>考试清理</a></li>
					<li><a href="/admin/system/config"><i class="icon-wrench icon-white"></i>系统配置</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><h4><b>欢迎，${name }</b></h4></li>
					<li><a href="#" data-toggle="modal"
		data-target=".bs-example-modal-sm"><i class="icon-pencil icon-white"></i>修改口令</a></li>
					<li><a href="/admin/logout"><i class="icon-share icon-white"></i>退出</a></li>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="modal fade bs-example-modal-sm span3" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">
				<form id="editPass" class="exam-form" method="post" action="/admin/password/edit">
					<p>
						<input type="hidden" name="name" value=${name } style="width:100%"/>
						<br/>
						<input type="password" name="oldpass" placeholder="原密码" style="width:100%"/>
						<br/>
						<input type="password" id="pass1" name="newpass1" placeholder="新密码" style="width:100%"/>
						<br/>
						<input type="password" id="pass2" name="newpass2" placeholder="重输新密码" style="width:100%"/>
						<br/>
						<input type="submit" class="btn btn-primary" value="修改" style="width:100%" onclick="editPassword"/>
						<span id="span1"></span>
					</p>
				</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">

		
			<!-- <div class="exam-alert">没有设置管理员帐号，默认管理员帐号存在安全风险，请尽快处理！</div>
			<br /> -->
	</div>
<script src="../js/jquery/jquery.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#pass2").blur(function(){
			var $pass1 = $("#pass1").val();
			var $pass2 = $("#pass2").val();
			if($pass1!=$pass2){
				$("#span1").html("<font color='red'>两次密码不一致</font>");
			}
		});
	});
</script>
