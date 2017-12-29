<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div style="background-image: url('../img/exam/bg.png');padding-top:70px;" >
<div class="container">
	<div class="panel panel-default"  style="width:700px">
		<div class="panel-heading">
			<h2 class="panel-title">添加单个学生</h2>
		</div>
		<div class="panel-body">
			<form id="studentAdd" class="form-inline" method="post">
			<div class="form-group">
			<input class="form-control" type="text" name="sid" placeholder="学号*" size="20" /> 
			</div>
			<div class="form-group">
			<input class="form-control" type="text" name="name" placeholder="姓名*" size="20" /> 
			</div>
			<div class="form-group">
			<input class="form-control"  type="text" name="clazz" placeholder="班级" size="20" />
			</div>
			<button type="submit" class="btn btn-primary" onclick="addStudent()">
				<i class="icon-plus"></i> 添加
			</button>
			</form>
		</div>
	</div>
	
	<div class="panel panel-default"  style="width:700px">
		<div class="panel-heading">
			<h2 class="panel-title">查找学生信息</h2>
		</div>
		<div class="panel-body">
			<form class="form-inline" action="/teacher/manage/student/search" method="post">
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
						<th class="col-md-3">IP</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${stu1.sid }</td>
						<td>${stu1.name }</td>
						<td>${stu1.clazz }</td>
						<td>${stu1.ip }</td>
					</tr>
				</tbody>
			</table>
			</div>
</div>
</div>
</div>
<script type="text/javascript">
	//新增学生信息
	function submitForm() {
		$.post("/teacher/manage/student/add", $("#studentAdd").serialize(),
				function(data) {
					if (data.status == 200) {
						$.messager.alert('提示', '新增学生成功!');
					}
				});
	}
</script>


<jsp:include page="footer.jsp" />
