<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 exam-info">
			<h4>进行情况：</h4>
			<p>参加考试学生总数：<strong>${studentMsg.totalNum } </strong></p>
			<p>已登录学生数量： <a class="btn-primary" href="manage_showbind"><i class="icon-search icon-white"></i><strong>${studentMsg.loginNum } </strong></a>，
			未登录学生数量： <a class="btn-primary" href="manage_showunbind"><i class="icon-search icon-white"></i><strong>${studentMsg.unloginNum } </strong></a>
			</p>
			<p>已登录学生中，提交文件学生数量：<a class="btn-primary" href="manage_showsubmit"><i class="icon-search icon-white"></i><strong>${studentMsg.submitNum } </strong></a>，
			未提交文件学生数量： <a class="btn-primary" href="manage_showunsubmit"><i class="icon-search icon-white"></i><strong>${studentMsg.unsubmitNum } </strong></a>
			</p>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
