<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<section style="background-image: url('/img/exam/bg.png');">
<div class="container" style="padding-top: 70px;">
	
<div class="panel panel-default">
		<div class="panel-heading text-center">
			<h4>编辑考试</h4>
		</div>
	<div class="panel-body text-center" >
	<br>
		<form id="examEdit" class="form-inline" method="post">
			<div class="form-group">
				<input class="form-control" type="hidden" name="id" value="${exam.id }"/>
				<input class="form-control" type="hidden" name="teachname" value="${exam.teachname }"/>
				<input class="form-control" type="text" name="name" value="${exam.name }" size="20" /><br>
			</div>
				<div class="form-group">		
					<div class="input-group date" id="datetimepicker">
    					<input id="time" class="form-control" size="20" type="text" name="starttime" value="${exam.starttime }" readonly>					
   						 <span class="input-group-addon">  
                    		<span class="glyphicon glyphicon-calendar"></span>  
                		 </span>
                		 <span class="input-group-addon">  
                    		<span class="glyphicon glyphicon-remove"></span>  
                		 </span>	 
					</div>
				</div>
			<div class="form-group">	
				<input class="form-control" type="hidden" id="flag" value="${exam.autostart }" />
				<input type="checkbox" id="autostart" name="autostart" /> 自动开始&nbsp; 
				<input type="button" class="btn btn-md btn-primary" value="编辑" onclick="editExam()" />
			</div>
		</form>
		<br>
	</div>
</div>
<br>

<form id="examPaper" class=" form-inline" enctype="multipart/form-data" method="post">
	<h4>上传试卷</h4>
	<input type="hidden" name="id" value="${exam.id }">
	<c:if test='${exam.exampaper!=null }' >
		<p class="exam-alert">已经上传过试卷，再次上传将导致原有试卷不可访问！
			<a id="downloadPaper" class="btn" target="_blank" href="/teacher/exam/download/${exam.id }"><span class="glyphicon glyphicon-download"></span>下载查看</a>
		</p>
		<input type="file" name="paper" />
		<br>
		<input type="button" class="btn btn-warning" value="更新"  onclick="uploadPaper()" style="color:#fff;"/>
	</c:if>
	<c:if test='${exam.exampaper==null }'>
		<input type="file" name="paper" />
		<br>
 		<input type="button" class="btn btn-primary" value="上传" onclick="uploadPaper()"/>
	</c:if>
</form>
<br>
<form class="form-inline" method="post">
	<h4>导入学生名单</h4>
	<a href="/teacher/exam/get/pagesize"><span class="glyphicon glyphicon-edit"></span>添加学生名单</a>
</form>
<br>
<form class=" form-inline" action="/teacher/exam/active" method="post">
	<h4>开启考试</h4>
	<input type="hidden" id="id" value="${exam.id }" />
	<c:if test="${start=='是' && started=='是' }">
	<h3 class="text-danger">
		考试（${exam.name }）正在进行中，本系统不允许同时进行多场考试。
	</h3>
	</c:if>
	<c:if test="${start=='否' && started=='否' }">
		<p class="text-danger">时间相差过多，不能开启考试。</p>
		<button type="submit" class="btn btn-danger btn-large disabled">
				<span class="glyphicon glyphicon-off"></span> 开启
		</button>
	</c:if>
	<c:if test="${start=='是' && started=='否' }">
		<button type="submit" class="btn btn-success btn-large">
			<span class="glyphicon glyphicon-off"></span> 开启
		</button>
	</c:if>
</form>
</div>
</section>
<script type="text/javascript" src="<%=basePath %>/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript">
	$("#datetimepicker").datetimepicker({
			format: "yyyy-mm-dd hh:ii", //选择日期后，文本框显示的日期格式
			language: 'zh-CN', //汉化
			autoclose:true, //选择日期后自动关闭
     		pickerPosition: "bottom-right"
    });

	//根据传入值判断选中单选框
	var $flag = $("#flag").val();
	if ($flag == "是") {
		$("#autostart").attr("checked", true);
	}	
	function editExam() {
		$.post("/teacher/exam/edit", $("#examEdit").serialize(), function(data) {
			if (data.status == 200) {
				$.messager.alert('提示', '编辑考试成功!', undefined, function() {
					//跳转到考试列表页面
					window.location.href="/teacher/exam/list";
				});
			}
			if(data.status==500){
				$.messager.alert('提示', '编辑考试失败!');
			}
		});
	}
	
	function uploadPaper(){
    	$.ajax({
            url: "/teacher/exam/upload",
            type: 'POST',
            cache: false,
            data: new FormData($('#examPaper')[0]),
            processData: false,
            contentType: false,
            dataType:"json",
            success : function(data) {
                if (data.error == 0) {
                	$.messager.alert('提示','上传试卷成功!',undefined, function() {
    					
    					window.location.href="/teacher/exam/edit/${exam.id }";
    				});
                }
                if(data.error == 1){
    				$.messager.alert('提示','上传试卷失败!');
    			}
            }
        });
	 }
	 
	//每隔15分钟请求提交一次数据
	setInterval(calcTime, 900000);
	function calcTime(){
		//开始考试时间
		var $time = "${exam.starttime }";
		$time = $time.replace(/-/g, "/");
		var starttime = Date.parse($time);
		//现在的时间
		var time = new Date();
		time = Date.parse(time);
			//开启考试
			if(starttime-time>900000){
				var $flag = $("#flag").val();
				//自动开启
				if($flag=="是"){
					postData("是", "是");
				}else{
					//手动开启
					postData("是", "否");
				}
			}else{
				postData("否", "否");
			}
		}
 
	function postData(s1, s2){
		 $.post("/teacher/exam/calcTime?id=${exam.id }", { start: s1, started: s2}, function(data){
			 if(data.status == 200){
				 window.location.href = "/teacher/exam_modify";
			 }
		 });
	 }
</script>

<jsp:include page="footer.jsp" />