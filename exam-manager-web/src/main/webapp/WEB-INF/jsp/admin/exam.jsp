<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>

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

<script type="text/javascript">

	var toolbar = [{
	    text:'清理',
	    iconCls:'icon-remove',
        handler:function(){
        	var examList = $("#examList");
    		var sels = examList.datagrid("getSelections");
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中考试!');
        		return ;
        	}
        	$.messager.confirm('确认','确定清理ID为 '+id+' 的考试吗？',function(r){
        	    if (r){
        	    	var params = {"id":id};
                	$.post("/admin/exam/clean",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','清理考试成功!',undefined,function(){
            					$("#examList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
	},{
       	text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var examList = $("#examList");
    		var sels = examList.datagrid("getSelections");
    		var ids = [];
    		for(var i in sels){
    			if(i.cleaned=='是'){
    				ids.push(sels[i].id);
    			}
    		}
    		ids = ids.join(",");
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中考试!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的考试吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/admin/exam/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除考试成功!',undefined,function(){
            					$("#examList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>	

