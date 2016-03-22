
var json_of_group = [
    {value:'1',name:'AKB48'},
    {value:'2',name:'SKE48'},
    {value:'3',name:'SNH48'}
];

//var full_path = '/MonitorPlatform/';

/**
 * 新增用户
 * @constructor
 */
function AddUser(){
	//设置表单提交路径
	$("#user_form").attr('target',full_path + 'sys/user/add');
    //显示模态框
    $("#user_modal").modal('show');
    //移除#group_table > tbody 所有节点
    $("#group_table > tbody").remove();
    //添加一个节点，即至少要一个节点
    AddGroupNode();
}

/**
 *
 * @constructor
 */
function EditUser(){
	//设置表单提交路径
	$("#user_form").attr('target',full_path + 'sys/user/update');
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
        alert(id);
        //获取json数据
        $.ajax({
            url: full_path + "/sys/user/updatePre/" + id,
            type: 'get',
            dataType: 'json',
            success: function(data){
            	//回显
            }
        });
    }
}



/**
 * 新增群组关系节点
 * @constructor
 */
function AddGroupNode(){
    var node = "<tr><td><select class='form-control'>";
    for(var i= 0,len=json_of_group.length;i<len;i++){
        node = node + "<option value='"+ json_of_group[i]['value'] +"'>" + json_of_group[i]['name'] + "</option>";
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
        data: $("#user_form").serialize(),
        success: function(data){
            //判断是否插入成功
            $(obj).tooltip({
                placement:'right',
                title: '保存成功',
                trigger: 'focus'
            }).tooltip('show');
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
        alert("请选择注销条目...");
    }else{
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