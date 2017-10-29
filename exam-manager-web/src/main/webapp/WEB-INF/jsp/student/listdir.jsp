<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div class="container-fluid">
	<div class="row-fluid">
	<h4>已上传文件列表</h4>
		<table class="easyui-datagrid" id="paperList"
			data-options="singleSelect:false,collapsible:true,url:'/student/file/list',method:'get'">
			<thead>
				<tr>
					<th data-options="field:'ck', checkbox:true">
					<th data-options="field:'filename', width:400">文件名</th>
					<th data-options="field:'filesize', width:180">文件大小</th>
					<th data-options="field:'finishtime', width:270">上传时间</th>
					<th data-options="field:'mark', width:420">备注</th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="row-fluid">
		<h4>答案上传</h4>
		<form class="form-inline" action="/student/file/upload" enctype="multipart/form-data" method="post">
			<input type="file" name="answer" />
			<input type="submit" class="btn btn-primary" value="上传" />
		</form>
	</div>
</div>

<jsp:include page="footer.jsp" />
