<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 exam-info">
			<p class="exam-info">
				<a class="btn btn-primary" href="manage_summary"><i class="icon-share-alt"></i> 返回</a>
			</p>
			<h4>已登录未提交学生数量：<strong>${studentMsg.unsubmitNum } </strong></h4>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
