<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<form class="exam-form form-horizontal" action="admin_teacher_update"
	method="post">
	<h4>修改教师帐号</h4>
	<input type="hidden" name="id" value="<s:property value="id"/>">
	<div class="control-group">
		<label class="control-label" for="name">用户名</label>
		<div class="controls">
			<input type="text" name="name" value="<s:property value="name"/>" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="pass">密码</label>
		<div class="controls">
			<input type="text" name="pass" placeholder="重置密码" /> <span>如不需要重新设定密码请留空</span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="fullname">全名</label>
		<div class="controls">
			<input type="text" name="fullname"
				value="<s:property value="fullname"/>" />
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<label class="checkbox"> <input type="checkbox" name="admin"
				value="true" <s:if test="admin">checked</s:if> /> 管理员&nbsp;
			</label>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<input type="submit" name="action" class="btn btn-primary" value="修改" />
		</div>
	</div>
</form>

<%@ include file="footer.jsp"%>
