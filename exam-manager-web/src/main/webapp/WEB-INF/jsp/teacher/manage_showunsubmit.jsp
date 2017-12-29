<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div class="container">
	<div class="row">
		<div class="col-md-12 exam-info">
			<p class="exam-info">
				<a class="btn btn-primary" href="manage_summary">
				<span class="glyphicon glyphicon-share-alt"></span> 返回</a>
			</p>
			<h4>
				已登录未提交学生数量：<strong>${studentMsg.unsumbitNum } </strong>
			</h4>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
