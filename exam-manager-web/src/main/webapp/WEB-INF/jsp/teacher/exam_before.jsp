<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<form id="examAdd" class="exam-form form-inline" action="/teacher/exam/add" enctype="multipart/form-data" method="post">
	<h4>添加考试</h4>
	<input type="text" name="ename" placeholder="考试名称*" size="20" />
	<div class="controls input-append date" id="datetimepicker" data-link-field="etime" >
		<input class="span2" size="16" type="text"  placeholder="考试时间*" readonly/> 
		<span class="add-on"><i class="icon-remove"></i></span>
		<span class="add-on"><i class="icon-th"></i></span>
	</div>    
	<input type="hidden" id="etime" name="etime" />
	<input type="checkbox" name="eautostart" value="true"/> 自动开始&nbsp;
	<input type="submit" class="btn btn-primary" value="添加" onclick="addExam()"/>
</form>

<table class="easyui-datagrid" id="examList" title="考试一览表"
	data-options="singleSelect:false,collapsible:true,url:'/teacher/exam/list',method:'get', toolbar:toolbar">
	<thead>
		<tr>
			<th data-options="field:'ck', checkbox:true">
			<th data-options="field:'id', width:60">ID</th>
			<th data-options="field:'name', width:190">考试名称</th>
			<th data-options="field:'starttime', width:180">考试时间</th>
			<th data-options="field:'teachname', width:120">创建人</th>
			<th data-options="field:'exampaper', width:180">上传试卷</th>
			<th data-options="field:'autostart', width:120">自动开始</th>
			<th data-options="field:'started', width:120">进行中</th>
			<th data-options="field:'finished', width:120">已结束</th>
			<th data-options="field:'archived', width:120">已归档</th>
			<th data-options="field:'cleaned', width:120">已清理</th>
		</tr>
	</thead>
</table>

<jsp:include page="footer.jsp" />

<script type="text/javascript">
	function addExam(){
		$.post("/teacher/exam/add", $("examAdd").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增教师成功!', undefined, function(){
					$("#examList").datagrid("reload");
				});
			});
	}

	$("#datetimepicker").datetimepicker({
	    format: "yyyy-mm-dd hh:ii",
	    autoclose: true,
	    todayBtn: true,
	    minuteStep: 10,
	    minView:0,
	    pickerPosition:'bottom-left',
	    language:'zh-CN'
	});
</script>
