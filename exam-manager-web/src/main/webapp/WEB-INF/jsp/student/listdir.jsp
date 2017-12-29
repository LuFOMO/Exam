<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<section style="background-image: url('/img/exam/bg.png');">
<div class="container" style="padding-top:70px">
	<div class="row">
		<h3>已上传文件列表</h3>
		<div style="padding-top:30px">
			<table class="table table-hover table-striped  table-condensed">
			<thead>
				<tr>
					<th class="col-md-4">文件名</th>
					<th class="col-md-4">文件大小(KB)</th>
					<th class="col-md-4">上传时间</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${file.filename }</td>
					<td>${file.filesize/1024 }</td>
					<td>${file.uploadtime }</td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
	<br>
	<div class="row">
		<h4>答案上传</h4>
			<form id="examFile" class="form-inline" enctype="multipart/form-data" method="post">
				<input type="hidden" name="name" value="${name }"/> 
				<input type="file" name="answer" /> 
				<input type="button" class="btn btn-primary" value="上传" onclick="uploadfile()"/>
			</form>
	</div>
</div>
</section>
<script type="text/javascript">
//上传试卷
	function uploadfile(){
    	$.ajax({
            url: "/student/exam/file/upload",
            type: 'POST',
            cache: false,
            data: new FormData($('#examFile')[0]),
            processData: false,
            contentType: false,
            dataType:"json",
            success : function(data) {
                if (data.error == 0) {
                	$.messager.alert('提示','上传答案成功!');
                }
                if(data.error == 1){
    				$.messager.alert('提示','上传答案失败!');
    			}
            }
        });
	 }
</script>
<jsp:include page="footer.jsp" />
