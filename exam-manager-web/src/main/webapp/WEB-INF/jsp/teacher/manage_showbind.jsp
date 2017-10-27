<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 exam-info">
			<p class="exam-info">
				<a class="btn btn-primary" href="teacher_manage_summary"><i class="icon-share-alt"></i> 返回</a>
			</p>
			<h4>已登录学生数量：<s:property value="bindlist.size()" /></h4>
			<p>
				<s:iterator value="bindlist">
					<span class="span2">
						<s:property value="student.sno" />(<s:property value="student.sname" />)&nbsp;
					</span>
				</s:iterator>
			</p>
		</div>
	</div>
</div>

<%@ include file="footer.jsp" %>
