<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<table class="easyui-datagrid" id="examList" title="考试一览表"
	data-options="singleSelect:false,collapsible:true,url:'/admin/exam/list',method:'get', toolbar:toolbar">
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
