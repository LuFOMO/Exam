<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- placed at the end of the document so the pages load faster -->

<div style="background-image: url('/img/exam/bg.png');padding-top:500px"></div>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>

	<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/bootstrap/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/bootstrap/bootstrap-datetimepicker.min.js"></script>
	<script src="<%=basePath %>/js/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
</body>
</html>