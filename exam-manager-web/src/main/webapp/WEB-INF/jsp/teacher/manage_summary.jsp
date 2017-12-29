<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div style="background-image: url('/img/exam/bg.png');padding-top:70px">
	<div class="container" >
		<div>
	
			<h2>进行情况：</h2><br>
			<h4>
				参加考试学生总数：<strong>${studentMsg.totalNum } </strong>
			</h4>
			<br>
		</div>
		<div class="row" style="padding-top:150px;padding-left:-5px">
			<div class="col-md-3 text-left">
			<p>
				已登录学生数量： 
				<a class="btn btn-info" href="manage_showbind">
				<i class="icon-search icon-white"></i>
				<strong>${studentMsg.loginNum }</strong>
				</a>
				</p>
			</div>
			<div class="col-md-3 text-left ">
			<p>
			 未登录学生数量： 
				<a class="btn btn-info" href="manage_showunbind">
				<i class="icon-search icon-white"></i>
				<strong>${studentMsg.unloginNum }</strong></a>
			</p>
			</div>
			
			<div class="col-md-3 text-left">
			<p>
				提交文件学生数量：
				<a class="btn btn-primary" href="manage_showsubmit">
				<i class="icon-search icon-white"></i><strong>${studentMsg.submitNum }
				</strong></a>
			</p>
			</div>
			<div class="col-md-3 text-left">
			<p>
				未提交文件学生数量： 
				<a class="btn btn-primary" href="manage_showunsubmit">
				<i class="icon-search icon-white"></i>
				<strong>${studentMsg.unsumbitNum }</strong></a>
			</p>
			</div>
			</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
