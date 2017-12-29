<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div style="background-image: url('/img/exam/bg.png');padding-top:70px;" >
<div class="container">
	<form id="notifyAdd" class="form-inline" method="post">
		<h4>新增通知消息</h4>
		<input class="form-control" type="text" name="notice" placeholder="通知消息内容" />
		<button type="button" class="btn btn-primary" onclick="addNotify()">
			<span class="glyphicon glyphicon-plus"></span> 添加
		</button>
	</form>
</div>
<div class="container" style="padding-top:40px;">
	<div class="row">
		<h4>已有通知消息</h4>
		<div style="padding-top:25px;">
			<table class="table table-hover table-striped  table-condensed ">
				<thead>
					<tr>
						<th class="col-md-7">通知内容</th>
						<th class="col-md-1">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notify }" var="notify" varStatus="vs">
						<input type="hidden" id="index" value="${vs.index }" />
						<tr>
							<td class="col-md-7">
								${notify }
							</td>
							<td class="col-md-1">
								<a class="btn" onclick="deleteNotify()">
								<span class="glyphicon glyphicon-remove"></span> 删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
	function addNotify(){
		$.post("/teacher/manage/notify/add", $("#notifyAdd").serialize(), function(data){
			if(data.status == 200){
				location.href="/teacher/manage/notify";
			}
			if(data.status==500){
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function deleteNotify(){
		var $index = $("#index").val();
		$.post("/teacher/manage/notify/delete?id="+$index, function(data){
			if(data.status == 200){
				location.href="/teacher/manage/notify";
			}
			if(data.status==500){
				$.messager.alert('提示',data.msg);
			}
		});
	}
</script>
<jsp:include page="footer.jsp" />
