<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<!-- placed at the end of the document so the pages load faster -->
<div style="background-image: url('/img/exam/bg.png');padding-top:500px"></div>
	<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
</body>
</html>