/**
 * Created by 智敏 on 2016/3/29.
 */

var allData = [];//所有菜单[{text:,href:,nodes:[]}]

var parentDate = [];//一级菜单

$(function () {

	$("#structure_form").attr("target","sys/structure/add.json");
	
	
	
	//获取所有菜单
    $.ajax({
        url: full_path + 'sys/structure/getStructure.json',
        type: 'get',
        dataType: 'json',
        async: false,
        success: function(data){
        	allData = data;
        }
    });
    
    //获取父菜单
    $.ajax({
    	url: full_path + 'sys/structure/getStructureInfo.json?parentId=0',
    	type: 'get',
    	dataType: 'json',
    	async: false,
    	success: function(data){
    		parentData = data;
    		AddSelectNode(parentData, 0);
    	}
    });
//显示树
    var $expandibleTree = $('#structure_tree').treeview({
        data: allData,
        onNodeSelected: function (event, node) {
            //选中请求节点信息
            $.ajax({
                url: full_path + 'sys/structure/getStructureInfo.json?structureId=' + node.href,
                type: 'get',
                dataType: 'json',
                success: function(data){
                	
                	//设置表单提交路径
                	$("#structure_form").attr("target","sys/structure/update.json");
                	
                	AddSelectNode(parentData,data[0]['parentId']);
                	$('#structure_id').val(data[0]['structureId']);
                	$('#structure_name').val(data[0]['structureName']);
                	$('#url').val(data[0]['url']);
                	$('#order_num').val(data[0]['orderNum']);
                	$('#description').val(data[0]['description']);
                }
            });
        },
        onNodeUnselected: function(){
        	CleanForm();
        }
    });
});

/**
 * select框增加选项
 * @param data 可选数据 object
 * @param selData 要选中的数据 number
 */
function AddSelectNode(data,selData){
    if(typeof selData == 'undefined'){
        selData = 0;
    }

    var obj = $("#parent_id");
   
    var node = "<option value='0'>主目录</option>";
    for(var o in data){
    	if(selData == data[o]['structureId']){
            node += "<option value='" + data[o]['structureId'] + "' selected>" + data[o]['structureName'] + "</option>";
    	}else{
            node += "<option value='" + data[o]['structureId'] + "'>" + data[o]['structureName'] + "</option>";
    	}
    }
    
    $(obj).children().remove();
    $(obj).append(node);
}

/**
 * 清空表单数据
 */
function CleanForm(){
	$('.form-horizontal input').val("");
	$('.form-horizontal textarea').val("");
	AddSelectNode(parentData,0);
}

/**
 * 删除菜单
 */
function DeleteStructure(){
	var obj = $('#structure_tree').treeview('getSelected');
	if(obj.length < 1){
		alert('请选择要删除的菜单...');
	}else{
		var str = "";
//		str = ConnNode(str,{href:1,nodes:[{href:2,nodes:[{href:3,nodes:[]}]},{href:4,nodes:[{href:6,nodes:[]}]}]});
		str = ConnNode(str,obj[0]);
		
		$.ajax({
			url: full_path + 'sys/structure/deletebatch.htm?ids=' + str,
			type: 'get',
			dataType: 'json',
			success: function(data){
				refresh();
			}
		});
		
	}
}


/**
 * 递归拼接节点
 * @param str
 * @param data
 */
function ConnNode(str,data){
	if((typeof data.nodes != 'undefined') && data.nodes.length > 0){
		var len = data.nodes.length;
		for(var i = 0;i<len;i++){
			str = ConnNode(str,data.nodes[i]);
		}
	}
		str = str + data.href + ";";
		return str;
}

/**
 * 新增
 */
function AddStructure(){
	CleanForm();
	$("#structure_form").attr("target","sys/structure/add.json");
}


/**
 * 保存
 */
function SaveStructure(){
	var target = 	$("#structure_form").attr("target");
	$.ajax({
		url: full_path + target,
		type: 'post',
		data: $("#structure_form").serialize(),
		dataType: 'json',
		success: function(data){
			//新增成功，情况输入框
			CleanForm();
			refresh();
		}
	})
}

/**
 * 页面刷新
 */
function refresh(){
	$.ajax({
		url: full_path + 'sys/structure/structure.htm',
		type: 'get',
		dataType: 'html',
		success: function(data){
			$("#content").empty();
			$("#content").append(data);
		}
	});
}


