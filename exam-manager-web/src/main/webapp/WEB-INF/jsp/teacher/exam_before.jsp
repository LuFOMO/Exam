<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<form class="exam-form form-inline" action="exam_insert" enctype="multipart/form-data" method="post">
	<h4>添加考试</h4>
	<input type="text" name="ename" placeholder="考试名称*" size="20" />
	<div class="controls input-append date" id="datetimepicker" data-link-field="etime" >
		<input class="span2" size="16" type="text"  placeholder="考试时间*" readonly/> 
		<span class="add-on"><i class="icon-remove"></i></span>
		<span class="add-on"><i class="icon-th"></i></span>
	</div>    
	<input type="hidden" id="etime" name="etime" />
	<input type="checkbox" name="eautostart" value="true"/> 自动开始&nbsp;
	<input type="submit" class="btn btn-primary" value="添加" />
</form>

<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th class="span3">考试名称</th>
			<th class="span3">考试时间</th>
			<th>创建人</th>
			<th>上传试卷</th>
			<th>自动开始</th>
			<th>进行中</th>
			<th>已结束</th>
			<th>已归档</th>
			<th>已清理</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="elist">
		<tr>
			<td><s:property value="ename" /></td>
			<td><s:property value="etime.toLocaleString()" /></td>
			<td><s:property value="teacher.tname" /></td>
			<td><s:if test='epaper!=null && !epaper.equals("")'><i class="icon-ok"></i></s:if></td>
			<td><s:if test="eautostart!=null && eautostart"><i class="icon-ok"></i></s:if></td>
			<td><s:if test="eactive!=null && eactive"><i class="icon-ok"></i></s:if></td>
			<td><s:if test="efinish!=null && efinish"><i class="icon-ok"></i></s:if></td>
			<td><s:if test="earchived!=null && earchived"><i class="icon-ok"></i></s:if></td>
			<td><s:if test="ecleared!=null && ecleared"><i class="icon-ok"></i></s:if></td>
			<td>
				<s:if test="(eactive==null || !eactive) && (efinish==null || !efinish)">
					<a class="btn" title="编辑" href="teacher_exam_modify?id=<s:property value="id" />"><i class="icon-edit"></i></a>
				</s:if>
			</td>
		</tr>
		</s:iterator>
	</tbody>
</table>

<%@ include file="footer.jsp" %>
<script type="text/javascript">
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
