<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<section style="background-image: url('/img/exam/bg.png');">
<div class="container" style="padding-top:100px">
<br>
<div id="ajax-info">
 	<p id="notify"></p>
</div>
	<div class="row" style="padding-top:50px;">
		<div class="col-md-6">
			<h3>试卷下载<img  alt="download" src="/img/exam/download.jpg" style="width:100px;padding-left:20px"></h3>
			<br />
			<c:if test="${exam.exampaper =='是' }">
				<a class="btn btn-info" target="_blank"
					href="/teacher/exam/download/${exam.id }">
					<span class="glyphicon glyphicon-download">下载查看</span></a>
			</c:if>
			<c:if test="${exam.exampaper !='是' }">
				<p class="exam-info">本次考试没有电子试卷。</p>
			</c:if>
		</div>
		<div class="col-md-6">
			<h3>答案上传<img  alt="download" src="/img/exam/upload.jpg" style="width:100px;padding-left:20px"></h3>
			<br />
			<p>请按照考试要求将答案文件打包，再次进行上传。同名文件多次上传将会覆盖。</p>
			<form id="examFile" class="form-inline" enctype="multipart/form-data" method="post">
				<input type="hidden" name="name" value="${name }"/> 
				<input type="file" name="answer" /> 
				<br>
				<button type="button" class="btn btn-info" onclick="uploadfile()">
  				<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span> 上传</button>
			</form>
		</div>
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
	//定时请求通知数据
	setInterval(getNotify, "${time }");
	function getNotify(){
		$.post("/student/exam/get/notify", undefined, function(data){
			if(data!=null || !"".equals(data)){
				var json = eval('('+data+')');
				var notify = "";
				$.each(json, function(i, n){
					notify += n+"<br>";
				});
					$("#notify").html(notify+"<br>");
			}
		});
	} 
</script>
<jsp:include page="footer.jsp" />
