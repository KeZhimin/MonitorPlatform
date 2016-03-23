
var json_of_group = [];
var josn_group_selected ; 
/**
 * 获取群组的json数据
 */
function GetGroup(){
	$.ajax({
		url: full_path + "sys/group/get.json",
		type: 'get',
		dataType: 'json',
		success: function(data){
			json_of_group = data;
		}
	});
}
GetGroup();
//var full_path = '/MonitorPlatform/';

/**
 * 新增用户
 * @constructor
 */
function AddUser(){
	GetGroup();
	//设置表单提交路径
	$("#user_form").attr('target',full_path + 'sys/user/add.htm');
    //显示模态框
    $("#user_modal").modal('show');
    //移除#group_table > tbody 所有节点
    $("#group_table > tbody").remove();

    //添加一个节点，即至少要一个节点
    AddGroupNode();
}
/**
 * 删除用户
 */
function DeleteUser(){
	//设置表单提交路径
	//$("#user_form").attr('target',full_path + 'sys/user/delete.htm');
    //获取选择的记录
    var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
    var len = obj.length;
    var ids="?";
    if(len == 0){
        alert("请选择要删除条目...");
    }else{
        for(var i= 0;i<len;i++){
        	
            ids = ids +"deleteId="+$(obj[i]).parents('tr').children('td:nth-child(2)').text() + "&";
            
        }
        ids = ids.substring(0,ids.length-1);
        //获取json数据
        $.ajax({
            url: full_path + "sys/user/delete.htm"+ ids,
            type: 'get',
            success: function(data){
            	 //移除#group_table > tbody 所有节点
                $("#group_table > tbody").remove();
            	
               
            }
        });
    }
}
/**
 *
 * @constructor
 */
function EditUser(){
	   GetGroup();
	//设置表单提交路径
	$("#user_form").attr('target',full_path + 'sys/user/update.htm');
    //获取选择的记录
    var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
    var len = obj.length;
    if(len == 0){
        alert("请选择要编辑条目...");
    }else if(len > 1){
        alert("无法批量编辑条目...");
    }else{
        //获取选择的条目信息,id在第二列
        var id = $(obj[0]).parents('tr').children('td:nth-child(2)').text();

        //获取json数据
        $.ajax({
            url: full_path + "/sys/user/updatePre/" + id+".json",
            type: 'get',
            dataType: 'json',
            success: function(data){
            	 //移除#group_table > tbody 所有节点
                $("#group_table > tbody").remove();
            	//回显
            	 josn_group_selected = data['sysGroup'];
            	 ShowUser(data['sysUser']);
            	EditGroupNode(josn_group_selected);
            	//显示模态框
                $("#user_modal").modal('show');
               
            }
        });
    }
}
/**
 * 回显用户
 * @param json_user
 */
function ShowUser(json_user){
	if(json_user==""){
		
	}else{
	 $("#userId").val(json_user['userId']);
	 $("#longinName").val(json_user['longinName']);
	 $("#fullName").val(json_user['fullName']);
	}
}
/**
 * 回显用户组
 * @param group_selected
 */
function EditGroupNode(group_selected){
	
	   if(group_selected ==""){
		 
	   }else{
		   //移除选项
		   for(var k = 0; k<group_selected.length;k++){
              $("#"+group_selected[k]['groupId']+"").remove();
		   }
    for(var j = 0; j<group_selected.length;j++){
    	var node = "<tr id='"+group_selected[j]['groupId']+"'><td><select name='groupid' class='form-control'>";
         for(var i= 0,len=json_of_group.length;i<len;i++){
        	//判断是否选中用户组
    		if(group_selected[j]['groupId']==json_of_group[i]['groupId']){
    			
    			node = node+"<option value='"+group_selected[j]['groupId']+"' selected>"+ group_selected[j]['groupName']+ "</option>" ;  
    		}else{
           	 node = node+"<option value='"+json_of_group[i]['groupId']+"'>"+ json_of_group[i]['groupName']+ "</option>" ;
    		}
    	}
         node = node + "</select></td><td><input type='button' class='button button-small' value='删除' onclick='RemoveGroupNode(this);'></td></tr>";
         $("#group_table").append(node);
    }
   
	   }
}
/**
 * 新增群组关系节点
 * @constructor
 */
function AddGroupNode(){
	console.log(json_of_group);
    var node = "<tr><td><select name='groupid' class='form-control'>";
    for(var i= 0,len=json_of_group.length;i<len;i++){
        node = node + "<option value='"+ json_of_group[i]['groupId'] +"'>" + json_of_group[i]['groupName'] + "</option>";
    }
    node = node + "</select></td><td><input type='button' class='button button-small' value='删除' onclick='RemoveGroupNode(this);'></td></tr>";
    $("#group_table").append(node);
}

/**
 * 移除节点
 * @param obj
 * @constructor
 */
function RemoveGroupNode(obj){
    //判断是否为唯一节点
    if($(obj).parents("tbody").children('tr').length > 1){
        $(obj).parents('tr').remove();
    }else{
        alert("不能移除唯一节点...");
    }
}

/**
 * 提交表单
 * @param obj
 * @constructor
 */
function SaveUser(obj){
	var target = $("#user_form").attr('target');
    $.ajax({
        url: target,
        type:'post',
        data: $("#user_form").serialize(),
        success: function(data){
            //判断是否插入成功
            $(obj).tooltip({
                placement:'right',
                title: '保存成功',
                trigger: 'focus'
            }).tooltip('show');
            setTimeout(function(){$("#user_modal").modal('hide');}, 2000);

        }
    });
}

/**
 * 设置全选/全不选
 * @param obj
 */
function OpAllCheckBox(obj){
    var temp = $("table > tbody > tr > td > input[type=checkbox]");
    if($(obj).prop('checked')){
        //全选
        $(temp).each(function(){
            $(this).prop('checked',true);
        });
    }else{
        //全不选
        $(temp).each(function(){
            $(this).prop('checked',false);
        });
    }
}



/**
 * 激活
 * @constructor
 */
function SetEnabled(){
    var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
    var len = obj.length;
    var ids = "";
    if(len < 1){
        alert("请选择未激活的条目...");
    }else 
    
    {
        for(var i= 0;i<len;i++){
            ids = ids + $(obj[i]).parents('tr').children('td:nth-child(2)').text() + ";";
            
        }
      
        $.ajax({
            url: full_path + "sys/user/enable.htm?ids=" + ids,
            type: 'get',
            dataType: 'json',
            success: function(data){
                
            }
        });
    }
}