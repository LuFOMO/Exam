<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container-fluid">
	<div class="row-fluid">
		<h4>已上传文件列表</h4>
		<s:actionerror cssClass="exam-alert" />
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="span4">文件名</th>
					<th class="span4">文件大小</th>
					<th class="span4">上传时间</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="dirlist" var="o">
					<tr>
						<td><s:property value="#o[0]"/></td>
						<td><s:property value="#o[1]"/></td>
						<td><s:property value="#o[2]"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="row-fluid">
		<h4>答案上传</h4>
		<form class="form-inline" action="student_exam_upload" enctype="multipart/form-data" method="post">
			<input type="file" name="answer" />
			<input type="submit" class="btn btn-primary" value="上传" />
		</form>
	</div>
</div>

<%@ include file="footer.jsp" %>
