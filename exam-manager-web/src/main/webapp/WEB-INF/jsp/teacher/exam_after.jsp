<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div style="background-image: url('/img/exam/bg.png');padding-top:70px;" >
<div class="container">
<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th class="col-md-3">考试名称</th>
				<th class="col-md-3">考试时间</th>
				<th>创建人</th>
				<th>上传试卷</th>
				<th>自动开始</th>
				<th>进行中</th>
				<th>已结束</th>
				<th>已归档</th>
				<th>已清理</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${examList }" var="exam">
			<tr>
				<td>${exam.name }</td>
				<td>${exam.starttime }</td>
				<td>${exam.teachname }</td>
				<td>${exam.exampaper }</td>
				<td>${exam.autostart }</td>
				<td>${exam.started }</td>
				<td>${exam.finished }</td>
				<td>${exam.archived }</td>
				<td>${exam.cleaned }</td>
				<td>
					<a class="btn" title="清理" href="/teacher/exam/clean/${exam.id }"><span class="glyphicon glyphicon-trash"></span></a>
				</td>
				<td>
					<a class="btn" title="删除" href="/teacher/exam/delete/${exam.id }"><span class="glyphicon glyphicon-remove"></span></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</div>
<jsp:include page="footer.jsp" />
