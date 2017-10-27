<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<form class="exam-form form-inline" action="teacher_manage_student_insert"
	method="post">
	<h4>添加单个学生</h4>
	<input type="text" name="sno" placeholder="学号*" size="20" />
	<input type="text" name="sname" placeholder="姓名*" size="20" />
	<input type="text" name="sclass" placeholder="班级" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-plus"></i> 添加</button>
</form>

<form class="exam-form form-inline" action="teacher/manage/student_search"
	method="post">
	<h4>查找学生信息</h4>
	<input type="text" name="sno" placeholder="学号" size="20" />
	<input type="text" name="sname" placeholder="姓名" size="20" />
	<input type="text" name="sclass" placeholder="班级" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

<div class="container-fluid">
	<div class="row-fluid">
	<s:if test="slist!=null && slist.size()>0">
		<h4>查找结果</h4>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="span4">学号</th>
					<th class="span4">姓名</th>
					<th class="span3">班级</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="slist">
					<tr>
						<td><s:property value="sno" /></td>
						<td><s:property value="sname" /></td>
						<td><s:property value="sclass" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
	</div>
</div>

<%@ include file="footer.jsp"%>
