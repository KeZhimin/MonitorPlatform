/**
 * Created by 智敏 on 2016/3/23.
 */
var allData=[];//所有菜单
var allUser = [];//当前角色对应的所有的用户
var allService = [];//当前角色对应所有的服务

/**
 * 获取所有用户
 */
function GetAllUser(){
	$.ajax({
		url: full_path + 'sys/user/getuser.json',
		type: 'get',
		dataType: 'json',
		async: false,
		success: function(data){
			allUser = data;
		}
	});
}
/**
 * 获取管理菜单组
 */
function GetAllStructure(){
    //获取所有菜单
    $.ajax({
        url: full_path + "sys/structure/getStructure.json",
        type: 'get',
        dataType: 'json',
        async: false,
        success: function(data){
        	allData = data;
        }
    });
}

/**
 * 获取所有服务
 */
function GetService(){
	$.ajax({
		url: full_path,
		type: 'get',
		dataType: 'json',
		async: false,
		succcess: function(data){
			allService = data;
		}
	});
}


/**
 * 全选或全不选
  * @param obj 全选对象
 * @constructor
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
 * 新建群组
 * @constructor
 */
function AddGroup() {
	//设置form提交路径
	$("#group_form").attr('target','sys/group/add.json');
	//清空原来所有已选择的
	$('#structure_tree').treeview('uncheckAll',{ silent: true });
	//移除用户关联下的所有选项
    $("#user_table > tbody").remove();
    //添加一个默认用户
//    AddNode('user_table', allUser, 'userId', 'fullName');
    //添加一个服务
    AddNode('service_table', allService, 'serviceId', 'serviceName');
    $('#group_modal').modal('show');
}



/**
 * 新增对应节点
 * @param obj 待添加节点的表id
 * @param json select数据
 * @param id json中对应数据的id（列名）
 * @param name json中对应数据的name（列名）
 * @constructor
 */
function AddNode(obj,json,id,name){
    var node = "<tr><td><select class='form-control' name='" + id + "'>";
    var len = json.length;
    for(var i = 0;i<len;i++){
        node = node + "<option value='" + json[i][id] + "'>" + json[i][name] + "</option>";
    }
    node = node + "</select></td><td><input type='button' class='btn btn-default' onclick='RemoveNode(this);' value='删除'></td></tr>";
    $("#" + obj).append(node);
}

/**
 * 新增用户关联节点
 * @constructor
 */
function AddUserNode(){
    AddNode('user_table', allUser, 'userId', 'fullName');
}

/**
 * 新增服务管理节点
 * @constructor
 */
function AddServiceNode(){
    AddNode('service_table', allService, 'serviceId', 'serviceName');
}

/**
 * 移除节点
 * @param obj
 * @constructor
 */
function RemoveNode(obj){
    //判断是否为唯一节点
    if($(obj).parents("tbody").children('tr').length > 1){
        $(obj).parents('tr').remove();
    }else{
        alert("不能移除唯一节点...");
    }
}



/**
 * 节点检测，字节点选中，父节点也要选中
 * @constructor
 */
function VerifyTreeNode(){
    var obj = $("#structure_tree").treeview('getChecked');//获取选中的节点数组对象
    for(var o in obj){
        var pNode = $("#structure_tree").treeview('getParent',obj[o]);//获取父节点
        if(!(typeof pNode['nodeId'] == 'undefined'))//如果是为父节点
        {
            $("#structure_tree").treeview('checkNode',pNode);//父节点也要选中
        }
    }
}


$(function () {
	//获取所有菜单
	GetAllStructure();
	//获取所有用户
    GetAllUser();
    
    
    $('#structure_tree').treeview({
        data: allData,
        showIcon: false,
        showCheckbox: true,
        onNodeChecked: function(event, node) {//监听节点被check
            VerifyTreeNode();
        },
        onNodeUnchecked: function (event, node) {//监听节点被uncheck
            VerifyTreeNode();
        }
    });
    Replay([],$('#structure_tree').treeview('getUnselected'));
});


/**
 * 递归回显
 * @param data json数据
 * @param node 所有节点对象
 * @constructor
 */
function Replay(data,node){
    for(var o in data){
        for(var temp in node){
            if(node[temp]['text'] == data[o]['text']){
                $('#structure_tree').treeview('checkNode',node[temp]);
                break;
            }
        }
        if(!(typeof data[o]['nodes'] == 'undefined')){//还有子节点
            Replay(data[o]['nodes'],node);
        }
    }
}

/**
 * 编辑
 * @constructor
 */
function EditGroup(){
	//设置保存提交路径
	$("#group_form").attr('target','sys/group/update.json');
    var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
    var len = obj.length;
    if(len < 1){
        alert('请选择编辑条目...');
    }else if(len > 1){
        alert('无法批量编辑');
    }else{
       var id =  $(obj).parents('tr').children('td:nth-child(2)').text();
        $.ajax({
            url: full_path + 'sys/group/getgroup.json?id=' + id,
            type: 'get',
            dataType: 'json',
            success: function(data){
            	//清空原来所有已选择的
            	$('#structure_tree').treeview('uncheckAll',{ silent: true });
            	//回显树
                Replay(data['structure'],$('#structure_tree').treeview('getUnselected'));
                //回显用户管理
                ReplaySelect('user_table', allUser, data['user'], 'userId', 'fullName');
                //回显服务管理
               // ReplaySelect('user_table', allUser, data['user'], 'userId', 'fullName');
                
                //回显基础信息
                $("#group_id").val(data['group']['groupId']);
                $("#group_name").val(data['group']['groupName']);
                if(data['group']['isEnabled'] === 1){
                	$("#is_enabled option:nth-child(2)").attr('selected',true);
                }
                
                $('#group_modal').modal('show');
            }
        });
    }
}

//显示用户管理组
function ReplaySelect(obj,data,selData,id,name){
	//移除所有节点
	$('#'+obj+' > tbody').remove();
	var node = "";
	for(var i in selData){
		node += "<tr><td><select class='form-control' name='"+ id +"'>";
		for(var o in data){
			if(selData[i][id] === data[o][id]){
				node += "<option value='" + data[o][id] + "' selected>" + data[o][name] + "</option>";
			}else{
				node += "<option value='" + data[o][id] + "'>" + data[o][name] + "</option>";
			}
		}
		node += "</select></td><td><input type='button' class='btn btn-default' onclick='RemoveNode(this);' value='删除'></td></tr>";
	}
	$('#'+obj).append(node);
}

/**
 * 根据条件查询用户组
 */
function selectGroup(){
	var groupName = $("#formGroup input[name='groupName']").val();
	var isEnabled = $("#formGroup select[name='isEnabled']").val();
	  $.ajax({
	        url: full_path+"sys/group/group.htm?pageSize=2&pageNum=1",
	        type:'post',
	        data: $("#formGroup").serialize(),
	        success: function(data){
	        	console.log(data);
	        	$("#content").empty();
	            $("#content").append(data);
	            $("#formGroup input[name='groupName']").val(groupName);
	            $("#formGroup select[name='isEnabled']").val(isEnabled);
	        }
	    });
}


//保存
function SaveGroup(){
	var target = $('#group_form').attr('target');
	var checkNode = $('#structure_tree').treeview('getChecked');
	var str_ids = "";
	for(var i in checkNode){
		str_ids += checkNode[i]['href'] + ";"
	}
	$("#str_ids").val(str_ids);
	$.ajax({
		url: full_path + target,
		type: 'post',
		data: $("#group_form").serialize(),
		dataType: 'json',
		success:function(data){
			reLoad();
		}
	});
}


//批量激活
function EnabledBatch(){
	var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
	var len = obj.length;
	if(len < 1){
		alert("请选择激活条目...");
	}else{
		var ids = "";
		for(var i=0;i<len;i++){
			var id = $(obj[i]).parents('tr').children('td:nth-child(2)').text();
			var sta =  $(obj[i]).parents('tr').children('td:nth-child(6)').text();
			if('是'==sta){
				alert('包含已激活条目，请重新选择...');
				break;
				return;
			}
			ids = ids + id + ";";
		}
		$.ajax({
			url: full_path + "sys/group/enabled.htm?ids=" + ids,
			type: 'get',
			dataType: 'json',
			success: function(data){
				reLoad();
			}
		});
	}
}

//批量激活
function DeletedBatch(){
	var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
	var len = obj.length;
	if(len < 1){
		alert("请选择激活条目...");
	}else{
		var ids = "";
		for(var i=0;i<len;i++){
			var id = $(obj[i]).parents('tr').children('td:nth-child(2)').text();
			ids = ids + id + ";";
		}
		$.ajax({
			url: full_path + "sys/group/deleted.htm?ids=" + ids,
			type: 'get',
			dataType: 'json',
			success: function(data){
				reLoad();
			}
		});
	}
}


//页面重新加载
function reLoad(){
	$.ajax({
		url: full_path + currentURL,
		type: 'get',
		dataType: 'html',
		success: function(data){
			$("#content").empty();
			$("#content").append(data);
		}
	});
}
