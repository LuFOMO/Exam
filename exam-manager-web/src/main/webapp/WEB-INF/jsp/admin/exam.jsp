<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

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
				<s:if test="(ecleared==null || !ecleared) && (earchived!=null && earchived)">
					<a class="btn" href="admin_exam_clear?id=<s:property value="id" />"><i class="icon-remove-sign"></i> 清理</a>
				</s:if>
				<s:if test="ecleared!=null && ecleared">
					<a class="btn" href="admin_exam_delete?id=<s:property value="id" />"><i class="icon-trash"></i> 删除</a>
				</s:if>
			</td>
		</tr>
		</s:iterator>
	</tbody>
</table>

<%@ include file="footer.jsp" %>
