<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<section style="background-image: url('/img/exam/bg.png');">
<div class="container" style="padding-top: 70px;padding-left:300px;">
	<div class="panel panel-default text-center" style=" width: 500px; height: 411px;">
		<div class="panel-heading">
			<h3 class="panel-title">修改系统配置</h3>
		</div>
		<div class="panel-body text-center">
			<form id="systemconfig" class=" form-horizontal" method="post">
				<div class="control-group">
					<label class="control-label" for="interval">后台任务间隔时间</label>
					<div class="controls">
						<input type="text" id="interval" name="interval"‘
							value="${config.interval }" />&nbsp;min
						<p class="help-block">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="pagesize">分页查询记录条数</label>
					<div class="controls">
						<input type="text" id="pagesize" name="pagesize"
							value="${config.pagesize }" />&nbsp;num
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="timegap">手动开启考试时间阈值</label>
					<div class="controls">
						<input type="text" id="timegap" name="timegap"
							value="${config.timegap }" />&nbsp;min
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="minfilesize">上传文件字节数下限</label>
					<div class="controls">
						<input type="text" id="minfilesize" name="minfilesize" 
							value="${config.minfilesize}" />&nbsp;KB
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="maxfilesize">上传文件字节数上限</label>
					<div class="controls">
						<input type="text" id="maxfilesize" name="maxfilesize"
							value="${config.maxfilesize}" />&nbsp;MB
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<label class="checkbox"> <input type="hidden" id="flag"
							name="flag" value="${config.ck }" /> <input type="checkbox"
							id="ck" name="ck" />教师可以清理和删除考试
						</label>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="button" class="btn btn-primary"
							value="修改" onclick="configSubmit()" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</section>
<script src="http://code.jquery.com/jquery-3.2.1.js" ></script>
<script type="text/javascript">
	//根据传入值判断选中单选框
	var $flag = $("#flag").val();
	if ($flag == "是") {
		$("#ck").attr("checked", true);
	}

	function configSubmit() {
		$.post("/admin/system/config/edit", $("#systemconfig").serialize(), function(data) {
			if (data.status == 200) {
				$.messager.alert('提示','修改配置信息成功!',undefined,function(){
					$.post("/admin/system/config");
				});
			}
		});
	}
</script>

<jsp:include page="footer.jsp" />
