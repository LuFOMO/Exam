<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="<%=basePath %>/img/mat/mat.ico">

<!-- Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--  Bootstrap 主题文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<title>404page</title>
</head>
<body>
<div class="container"  >
<div align="center" style="padding-top:100px;">
	
	<img src="<%=basePath %>/img/error/404.jpg" style="width:1000px;" alt="">	
	
</div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
	<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>