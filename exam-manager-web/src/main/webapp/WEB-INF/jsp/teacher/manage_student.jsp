<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<form class="exam-form form-inline" action="/teacher/manage/student/add"
	method="post">
	<h4>添加单个学生</h4>
	<input type="text" name="sid" placeholder="学号*" size="20" />
	<input type="text" name="name" placeholder="姓名*" size="20" />
	<input type="text" name="clazz" placeholder="班级" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-plus"></i> 添加</button>
</form>

<form class="exam-form form-inline" action="/teacher/manage/student/search"
	method="post">
	<h4>查找学生信息</h4>
	<input type="text" name="sid" placeholder="学号" size="20" />
	<input type="text" name="name" placeholder="姓名" size="20" />
	<input type="text" name="clazz" placeholder="班级" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

<div class="container-fluid">
	<div class="row-fluid">
		<h4>查找结果</h4>
		<table class="easyui-datagrid" id="studentList"
			data-options="singleSelect:false,collapsible:true,url:'/student/list',method:'get'">
			<thead>
				<tr>
					<th data-options="field:'sid', width:420">学号</th>
					<th data-options="field:'name', width:420">姓名</th>
					<th data-options="field:'clazz', width:420">班级</th>
				</tr>
			</thead>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp" />
