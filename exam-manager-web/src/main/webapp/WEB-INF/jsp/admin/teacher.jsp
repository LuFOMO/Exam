<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<form id="teacherAdd" class="exam-form form-inline" method="post">
	<h4>添加教师</h4>
	<input type="text" name="name" placeholder="用户名*" size="20" />
	<input type="text" name="password" placeholder="初始口令*" size="20" />
	<input type="text" name="fullname" placeholder="真实姓名" size="20" />
	<input type="checkbox" id="ck" name="isAdmin"/> 管理员&nbsp; 
	<input type="submit" name="action" class="btn btn-primary" value="添加" onclick="submitForm()"/>
</form>

<table class="easyui-datagrid" id="teacherList" title="教师表" 
	data-options="singleSelect:false,collapsible:true,url:'/admin/teacher/list',method:'get', toolbar:toolbar">
	<thead>
		<tr>
			<th data-options="field:'ck', checkbox:true">
			<th data-options="field:'id', width:120">ID</th>
			<th data-options="field:'name', width:180">用户名</th>
			<th data-options="field:'fullname', width:320">全名</th>
			<th data-options="field:'isAdmin', width:120">是否管理员</th>
			<th data-options="field:'rk', width:570">备注</th>
		</tr>
	</thead>
</table>

<!-- 修改教师信息 -->
<div id="teacherEdit" class="easyui-dialog" style="width:460px;height:360px;padding:10px 20px"
		closed="true" buttons="#teacherEdit-buttons">
	<form id="editMsg" method="post">
		<div class="control-group">
			<label class="control-label">用户名</label>
			<div class="controls">
				<input type="text" name="name" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码</label>
			<div class="controls">
				<input type="text" name="password" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">全名</label>
			<div class="controls">
				<input type="text" name="fullname"/>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox"> 
					<input type="checkbox" name="isAdmin"/>管理员
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<input type="submit" class="btn btn-primary" value="修改" onclick="teacherEdit()"/>
			</div>
		</div>
	</form>	
</div>


<jsp:include page="footer.jsp" />

<script type="text/javascript">
	function getSelectionsIds(){
		var teacherList = $("#teacherList");
		var sels = teacherList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	var toolbar = [{
	    text:'编辑',
	    iconCls:'icon-edit',
	    handler:function(){
	    	var row = $('#teacherList').datagrid('getSelected');
	    	if(row){
		    	$('#teacherEdit').dialog('open').dialog('setTitle','修改教师账号');
		    	$('#editMsg').form('load',row);
	    	}else{
	    		$.messager.alert('提示','必须选择一个才能编辑!');
	    	}
	    }
	},{
       	text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中教师!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的教师吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/admin/teacher/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除教师成功!',undefined,function(){
            					$("#teacherList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
	
	//新增教师信息
	function submitForm(){
		$.post("/admin/teacher/add", $("#teacherAdd").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增教师成功!', undefined, function(){
					$("#teacherList").datagrid("reload");
				});
			}
		});
	}
	
	//修改教师账号
	function teacherEdit(){
		var row = $('#teacherList').datagrid('getSelected');
		$.post("/admin/teacher/edit?id="+row.id, $("#editMsg").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改教师成功!', undefined, function(){
					$('#teacherEdit').dialog('close');		
					$("#teacherList").datagrid("reload");
				});
			}
		});
	}
</script>
