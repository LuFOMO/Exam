<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<section style="background-image: url('<%=basePath%>/img/exam/bg.png');">
<div class="container" style="padding-top:70px;">

<div class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title">添加考试</h2>
		</div>
		<div class="panel-body text-center">
		<br>
			<form id="examAdd" class="form-inline" method="post">
				<div class="form-group">
					<input class="form-control" type="hidden" name="teachname" value="${name }" />
					<input class="form-control" type="text" name="name" placeholder="考试名称" size="20" /><br>
				</div>
					<div class="form-group">		
						<div class="input-group date" id="datetimepicker">
	    					<input class="form-control" size="20" type="text" name="starttime" placeholder="考试时间" readonly>					
	   						 <span class="input-group-addon">  
	                    		<span class="glyphicon glyphicon-calendar"></span>  
	                		 </span>
	                		 <span class="input-group-addon">  
	                    		<span class="glyphicon glyphicon-remove"></span>  
	                		 </span>	 
						</div>
					</div>
				<div class="form-group">	
					<input type="checkbox" name="autostart" /> 自动开始&nbsp; 
					<input type="button" class="btn btn-md btn-primary" value="添加" onclick="addExam()" />
				</div>
			</form>
			<br>
		</div>
	</div>
	<br>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th class="col-md-3">考试名称</th>
				<th class="col-md-3">考试时间</th>
				<th>创建人</th>
				<th>上传试卷</th>
				<th>自动开始</th>
				<th>进行中</th>
				<th>已结束</th>
				<th>已归档</th>
				<th>已清理</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${examList }" var="exam">
			<tr>
				<td>${exam.name }</td>
				<td>${exam.starttime }</td>
				<td>${exam.teachname }</td>
				<td>${exam.exampaper }</td>
				<td>${exam.autostart }</td>
				<td>${exam.started }</td>
				<td>${exam.finished }</td>
				<td>${exam.archived }</td>
				<td>${exam.cleaned }</td>
				<td>
					<a class="btn" title="编辑" href="/teacher/exam/edit/${exam.id }"><span class="glyphicon glyphicon-edit"></span></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</section>

<script type="text/javascript" src="<%=basePath %>/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">

	$("#datetimepicker").datetimepicker({
			format: "yyyy-mm-dd hh:ii", //选择日期后，文本框显示的日期格式
			language: 'zh-CN', //汉化
			autoclose:true, //选择日期后自动关闭
     		pickerPosition: "bottom-right"
    });
    	
	function addExam() {
		$.post("/teacher/exam/add", $("#examAdd").serialize(), function(data) {
			if (data.status == 200) {
				$.messager.alert('提示', '新增考试成功!', undefined, function() {
					window.location.href="/teacher/exam/list";
				});
			}
			if(data.status==500){
				$.messager.alert('提示', '新增考试失败!');
			}
		});
	}
</script>
<jsp:include page="footer.jsp" />