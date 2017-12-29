<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div style="background-image: url('/img/exam/bg.png');padding-top:70px;">
<div  class="container">
<p class="exam-info">
	完成学生名单的导入和修改后，
	 <a class="btn" href="/teacher/exam_modify"><span class="danger glyphicon glyphicon-edit">返回编辑</span></a>
</p>

<table class="easyui-datagrid" id="studentsList" title="学生信息表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/teacher/student/list',method:'get',pageSize:${pagesize },toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:100">id</th>
            <th data-options="field:'sid',width:300">学号</th>
            <th data-options="field:'name',width:200">姓名</th>
            <th data-options="field:'clazz',width:100">班级</th>
            <th data-options="field:'rk',width:580">备注</th>
        </tr>
    </thead>
</table>

<!-- 添加单个学生信息 -->
<div id="studentAdd" class="easyui-dialog"
	style="width: 500px; height: 300px; padding-top: 50px; text-align: center"
	closed="true" buttons="#studentAdd-buttons">
	<form id="ssAdd" method="post">
		<div class="control-group">
			<div class="controls">
				<label class="control-label text-right">学号</label> 
				<input type="text" name="sid" />
			</div>
		</div>
		<br>
		<div class="control-group">
			<div class="controls">
				<label class="control-label text-right">姓名</label> 
				<input type="text" name="name" />
			</div>
		</div>
		<br>
		<div class="control-group">
			<div class="controls">
				<label class="control-label text-right">班级</label> 
				<input type="text" name="clazz" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<input type="button" class="btn btn-md btn-primary" value="添加" onclick="addStudent()" />
			</div>
		</div>
	</form>
</div>
<div style="padding-top:20px;">
<form id="ssAddAll" class=" form-inline" enctype="multipart/form-data" method="post">
	<h4>批量导入学生名单</h4>
	<input type="hidden" name="eid" value="${exam.id }" /> 
	<input type="file" name="file" />
	<br>
	<input type="button" class="btn btn-primary" value="导入" onclick="addAllStudents()"/>
	<br>
</form>
</div>
</div>
</div>
<script>
    function getSelectionsIds(){
    	var studentsList = $("#studentsList");
    	var sels = studentsList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
		    $('#studentAdd').dialog('open').dialog('setTitle','添加学生信息');
	    }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中信息!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的学生信息吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/teacher/student/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除学生信息成功!',undefined,function(){
            					$("#studentsList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
    
    function addStudent(){
    	$.post("/teacher/manage/student/add", $("#ssAdd").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','添加学生信息成功!', undefined, function(){
					$('#studentAdd').dialog('close');	
					$("#studentsList").datagrid("reload");
				});
			}
		});
    }
        
    function addAllStudents(){
    	$.ajax({
            url: "/teacher/student/addAll",
            type: 'POST',
            cache: false,
            data: new FormData($('#ssAddAll')[0]),
            processData: false,
            contentType: false,
            dataType:"json",
            success : function(data) {
                if (data.status == 200) {
                	$.messager.alert('提示','导入学生信息成功!', undefined, function(){
    					$("#studentsList").datagrid("reload");
    				});
                }
                if(data.status == 500){
    				$.messager.alert('提示','导入学生信息失败!');
    			}
            }
        });
    }
</script>
<jsp:include page="footer.jsp" />
