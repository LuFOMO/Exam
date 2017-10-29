<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<form class="exam-form form-inline" action="/teacher/manage/binding/search"
	method="post">
	<h4>按学生查找已登录信息</h4>
	<input type="text" name="sid" placeholder="学号" size="20" />
	<input type="text" name="name" placeholder="姓名" size="20" />
	<input type="text" name="clazz" placeholder="班级" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

<form class="exam-form form-inline" action="/teacher/manage/binding/searchip"
	method="post">
	<h4>按ip地址查找已登录信息</h4>
	<input type="text" name="ip" placeholder="ip地址" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

<div class="container-fluid">
	<div class="row-fluid">
		<h4>查找结果</h4>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="span3">学号</th>
					<th class="span2">姓名</th>
					<th class="span3">班级</th>
					<th class="span3">ip地址</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${student.sid }</td>
					<td>${student.name }</td>
					<td>${student.clazz }</td>
					<td>${student.ip }</td>
					<td>
						<a class="btn" href="/teacher/manage/binding/delete?id=${student.id }"><i class="icon-remove"></i> 解锁</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="footer.jsp"%>
