<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<section style="background-image:url('../img/exam/bg.png');" >

<div class="panel panel-default text-center" style="padding-left:500px;padding-top:50px;width:1000px;height:8ew00px;background-image:url('../img/exam/bg.png');">
  <div class="panel-heading">
    <h3 class="panel-title">修改系统配置</h3>
  </div>
  <div class="panel-body text-center">
  <form id="systemconfig" class=" form-horizontal" method="post">
   	<div class="control-group">
		<label class="control-label" for="interval">后台任务间隔时间</label>
		<div class="controls">
			<input type="text" id="interval" name="interval" value="${config.interval }"/>
			<p class="help-block">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="pagesize">分页查询记录条数</label>
		<div class="controls">
			<input type="text" id="pagesize" name="pagesize" value="${config.pagesize }"/>
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="timegap">手动开启考试时间阈值</label>
		<div class="controls">
			<input type="text" id="timegap" name="timegap" value="${config.timegap }"/>
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="minfilesize">上传文件字节数下限</label>
		<div class="controls">
			<input type="text" id="minfilesize" name="minfilesize" value="${config.minfilesize/1024}"/>KB
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="maxfilesize">上传文件字节数上限</label>
		<div class="controls">
			<input type="text" id="maxfilesize" name="maxfilesize" value="${config.maxfilesize/1024/1024}"/>MB
			<p class="help-block"></p>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<label class="checkbox">
			<input type="hidden" id="flag" name="flag" value="${config.ck }"/>
			<input type="checkbox" id="ck" name="ck" />教师可以清理和删除考试
			</label>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<input type="submit" name="action" class="btn btn-primary" value="修改" onclick="configSubmit()"/>
		</div>
	</div>
</form>
   
  </div>
</div>
	

<jsp:include page="footer.jsp" />
</section>
<script type="text/javascript">

	//根据传入值判断选中单选框
	var $flag = $("#flag").val();
	if($flag =="是"){
		$("#ck").attr("checked",true);
	}
	
	function configSubmit(){
		$.post("/admin/config/edit", $("#systemconfig").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','配置信息修改成功!');
				//重新加载页面
				$.post("/admin/system/config");
			}
		});
	}
</script>