<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<p class="exam-info">完成学生名单的导入和修改后，
	<a class="btn" href="teacher_exam_modify?id=<s:property value="eid" />"><i class="icon-edit"></i>返回编辑</a>
</p>

<form class="exam-form form-inline" action="teacher_student_insert"
	method="post">
	<h4>添加单个学生</h4>
	<input type="text" name="sno" placeholder="学号*" size="20" />
	<input type="text" name="sname" placeholder="姓名*" size="20" />
	<input type="text" name="sclass" placeholder="班级" size="20" />
	<input type="hidden" name="eid" value="<s:property value="eid"/>" />
	<input type="submit" class="btn btn-primary" value="添加" />
</form>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6">
			<form class="form-inline" action="teacher_student" method="post">
				分页大小 <input type="text" name="pageSize"
					value="<s:property value="#session.pageSize" />"
					class="input-small" /> <input type="submit" class="btn" value="设置" />
			</form>
		</div>
		<div class="pull-right">
			<form class="form-inline" action="teacher_student" method="get">
				<a title="第一页"
					<s:if test="pageNo==1">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=1" class="btn"	</s:else>">
					<i class="icon-fast-backward"></i>
				</a>
				<a title="前一页"
					<s:if test="pageNo==1">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=<s:property value="pageNo-1"/>" class="btn"	</s:else>">
					<i class="icon-step-backward"></i>
				</a>
				<input type="hidden" name="eid" value="<s:property value="eid"/>" />
				<input type="text" name="pageNo"
					placeholder="<s:property value="pageNo"/>/<s:property value="pageCount"/>"
					class="input-small" />
				<button type="submit" title="前往" class="btn">
					<i class="icon-play"></i>
				</button>
				<a title="后一页"
					<s:if test="pageNo==pageCount">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=<s:property value="pageNo+1"/>" class="btn"</s:else>">
					<i class="icon-step-forward"></i>
				</a>
				<a title="最后一页"
					<s:if test="pageNo==pageCount">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=<s:property value="pageCount"/>" class="btn"</s:else>">
					<i class="icon-fast-forward"></i>
				</a>
			</form>
		</div>
	</div>
	<div class="row-fluid">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="span4">学号</th>
					<th class="span4">姓名</th>
					<th class="span3">班级</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="slist">
					<tr>
						<td><s:property value="sno" /></td>
						<td><s:property value="sname" /></td>
						<td><s:property value="sclass" /></td>
						<td><a href="teacher_student_delete?eid=<s:property value="eid"/>&id=<s:property value="id" />"><i
								class="icon-trash" title="删除"></i></a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="row-fluid">
		<div class="pull-right">
			<form class="form-inline" action="teacher_student" method="get">
				<a title="第一页"
					<s:if test="pageNo==1">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=1" class="btn"	</s:else>">
					<i class="icon-fast-backward"></i>
				</a>
				<a title="前一页"
					<s:if test="pageNo==1">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=<s:property value="pageNo-1"/>" class="btn"	</s:else>">
					<i class="icon-step-backward"></i>
				</a>
				<input type="hidden" name="eid" value="<s:property value="eid"/>" />
				<input type="text" name="pageNo"
					placeholder="<s:property value="pageNo"/>/<s:property value="pageCount"/>"
					class="input-small" />
				<button type="submit" title="前往" class="btn">
					<i class="icon-play"></i>
				</button>
				<a title="后一页"
					<s:if test="pageNo==pageCount">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=<s:property value="pageNo+1"/>" class="btn"</s:else>">
					<i class="icon-step-forward"></i>
				</a>
				<a title="最后一页"
					<s:if test="pageNo==pageCount">href="javascript: void(0)" class="btn disabled"</s:if>
					<s:else>href="teacher_student?eid=<s:property value="eid"/>&pageNo=<s:property value="pageCount"/>" class="btn"</s:else>">
					<i class="icon-fast-forward"></i>
				</a>
			</form>
		</div>
	</div>
</div>
<form class="exam-form form-inline" action="teacher_student_upload"
	enctype="multipart/form-data" method="post">
	<h4>批量导入学生名单</h4>
	<input type="hidden" name="eid" value="<s:property value="eid"/>" />
	<input type="file" name="students" /> <input type="submit"
		class="btn btn-primary" value="导入" />
</form>

<%@ include file="footer.jsp"%>
