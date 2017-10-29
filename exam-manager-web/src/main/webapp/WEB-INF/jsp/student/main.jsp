<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6">
			<h3>试卷下载</h3>
			<br/>
			<c:if test="${exam.exampaper }=='是'">
				<a class="btn" target="_blank" href="/student/file/download?id=${exam.paperUrl }"><i class="icon-download"></i>下载查看</a>
			</c:if>
			<c:if test="">
				<p class="exam-info">本次考试没有电子试卷。
				</p>
			</c:if>
		</div>
		<div class="span6">
			<h3>答案上传</h3>
			<br/>
			<p>请按照考试要求将答案文件打包，再次进行上传。同名文件多次上传将会覆盖。</p>
			<form class="form-inline" action="/student/file/upload" enctype="multipart/form-data" method="post">
				<input type="file" name="answer" />
				<input type="submit" class="btn btn-primary" value="上传" />
			</form>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />
