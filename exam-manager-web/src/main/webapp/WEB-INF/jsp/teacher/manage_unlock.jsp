<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div style="background-image: url('/img/exam/bg.png');padding-top:70px;" >
<div class="container">
	<div class="panel panel-default"  style="width:700px">
		<div class="panel-heading">
			<h2 class="panel-title">按学生查找已登录信息</h2>
		</div>
		<div class="panel-body">
			<form class="form-inline" action="/teacher/manage/binding/search" method="post">
			<div class="form-group">
			<input class="form-control" type="text" name="sid" placeholder="学号" size="20" />
			</div>
			<div class="form-group">
			<input class="form-control" type="text" name="name" placeholder="姓名" size="20" /> 
			</div>
			<div class="form-group">
			 <input class="form-control" type="text" name="clazz" placeholder="班级" size="20" />
			</div>			
			<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i> 查找
			</button>
			</form>
		</div>
	</div>
	<div class="panel panel-default"  style="width:700px">
		<div class="panel-heading">
			<h2 class="panel-title">按ip地址查找已登录信息</h2>
		</div>
		<div class="panel-body">
			<form class="form-inline" action="/teacher/manage/binding/searchip" method="post">
			<div class="form-group">
			<input class="form-control" type="text" name="ip" placeholder="ip地址" size="20" />
			</div>
			<button type="submit" class="btn btn-primary">
				<i class="icon-search"></i> 查找
			</button>
			</form>
		</div>
	</div>
<div class="container" style="padding-top:10px;">
	<div class="row">
		<h3>查找结果</h3>
		<div style="padding-top:25px;">
			<table class="table table-hover table-striped  table-condensed">
			<thead>
				<tr>
					<th class="col-md-3">学号</th>
					<th class="col-md-3">姓名</th>
					<th class="col-md-3">班级</th>
					<th class="col-md-3">ip地址</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${stu2.sid }</td>
					<td>${stu2.name }</td>
					<td>${stu2.clazz }</td>
					<td>${stu2.ip }</td>
					<td><a class="btn" onclick="editIP()">
					<i class="icon-remove"></i> 解锁</a></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
</div>
</div>
</div>
<script type="text/javascript">
	function editIP(){
		$.post("/teacher/manage/binding/delete/${stu2.id }",function(data){
			if(data.status == 200){
				$.messager.alert('提示','解除IP绑定成功!', undefined, function(){
					 location.reload();
				});
			}else{
				$.messager.alert('提示','解除IP绑定失败!');
			}
		});
	}
</script>
<jsp:include page="footer.jsp" />
