<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form class="exam-form form-horizontal" action="admin_config_update"
	method="post">
	<h4>修改系统配置</h4>
	<div class="control-group">
		<label class="control-label" for="interval">后台任务间隔时间</label>
		<div class="controls">
			<input type="text" id="interval" name="interval" value="<s:property value="interval"/>" />
			<p class="help-block"><s:property value="interval_desc"/></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="pagesize">分页查询记录条数</label>
		<div class="controls">
			<input type="text" id="pagesize" name="pagesize" value="<s:property value="pagesize"/>" />
			<p class="help-block"><s:property value="pagesize_desc"/></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="timegap">手动开启考试时间阈值</label>
		<div class="controls">
			<input type="text" id="timegap" name="timegap" value="<s:property value="timegap"/>" />
			<p class="help-block"><s:property value="timegap_desc"/></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="minfilesize">上传文件字节数下限</label>
		<div class="controls">
			<input type="text" id="minfilesize" name="minfilesize" value="<s:property value="minfilesize"/>" />
			<p class="help-block"><s:property value="minfilesize_desc"/></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="maxfilesize">上传文件字节数上限</label>
		<div class="controls">
			<input type="text" id="maxfilesize" name="maxfilesize" value="<s:property value="maxfilesize"/>" />
			<p class="help-block"><s:property value="maxfilesize_desc"/></p>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<label class="checkbox">
			<input type="checkbox" id="candelete" name="candelete" value="true" 
				<s:if test="candelete">checked</s:if> /> 教师可以清理和删除考试
			<!-- to make struts2 get unchecked input -->
			<input type="hidden" id="__checkbox_candelete" name="__checkbox_candelete" value="true" />
			</label>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<input type="submit" name="action" class="btn btn-primary" value="修改" />
		</div>
	</div>
</form>

<%@ include file="footer.jsp" %>
