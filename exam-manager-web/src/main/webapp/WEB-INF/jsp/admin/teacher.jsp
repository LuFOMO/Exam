<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<form class="exam-form form-inline" action="admin_teacher_insert" method="post">
	<h4>添加教师</h4>
	<input type="text" name="name" placeholder="用户名*" size="20" />
	<input type="text" name="pass" placeholder="初始口令*" size="20" />
	<input type="text" name="fullname" placeholder="真实姓名" size="20" />
	<input type="checkbox" name="admin" value="true"/> 管理员&nbsp;
	<input type="submit" name="action" class="btn btn-primary" value="添加" />
</form>

<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th class="span4">用户名</th>
			<th class="span4">全名</th>
			<th class="span3">是否管理员</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="tlist">
		<tr>
			<td><s:property value="tname" /></td>
			<td><s:property value="tfullname" /></td>
			<td><s:if test="tadmin"><i class="icon-ok"></i></s:if></td>
			<td>
				<a href="admin_teacher_modify?id=<s:property value="id" />"><i class="icon-edit" title="编辑" ></i></a>&nbsp;
				<a href="admin_teacher_delete?id=<s:property value="id" />"><i class="icon-trash" title="删除" ></i></a>
			</td>
		</tr>
		</s:iterator>
	</tbody>
</table>

<%@ include file="footer.jsp" %>
