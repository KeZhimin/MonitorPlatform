/**
 * Created by 智敏 on 2016/3/23.
 */

var json_of_structure = [{structureId: 1001,structureName:'用户管理'},{structureId: 1002,structureName:'菜单管理'},{structureId: 1003,structureName:'角色管理'}];
var json_of_user = [{userId:10001,userName:'小嶋阳菜'},{userId: 10002,userName: '柏木由纪'},{userId:10003,userName:'渡边麻友'}];
var json_of_service = [{serviceId:101,serviceName:'马尾机房'},{serviceId:102,serviceName:'永泰机房'},{serviceId:103,serviceName:'新店机房'}];

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
    $("#user_table > tbody").remove();
    AddNode('user_table', json_of_user, 'userId', 'userName');
    AddNode('service_table', json_of_service, 'serviceId', 'serviceName');
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
    var node = "<tr><td><select class='form-control' name='" + name + "'>";
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
    AddNode('user_table', json_of_user, 'userId', 'userName');
}

/**
 * 新增服务管理节点
 * @constructor
 */
function AddServiceNode(){
    AddNode('service_table', json_of_service, 'serviceId', 'serviceName');
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


var checkData = [{
    text: 'Parent 1',
    nodes: [
        {
            text: 'Child 1-1'
        },
        {
            text: 'Child 1-2'
        }
    ]
},{text: 'Parent 2'}];



var defaultData = [
    {
        text: 'Parent 1',
        nodes: [
            {
                text: 'Child 1-1'
            },
            {
                text: 'Child 1-2'
            }
        ]
    },
    {
        text: 'Parent 2',
        nodes: [
            {text: 'Child 2-1'},
            {text: 'Child 2-2'}
        ]
    },
    {
        text: 'Parent 3',
        nodes: [
            {text: 'Child 3-1'},
            {text: 'Child 3-2'},
            {text: 'Child 3-3'}
        ]
    },
    {
        text: 'Parent 4',
        nodes: [
            {text: 'Child 4-1'},
            {text: 'Child 4-2'}
        ]
    }
];

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
    $.ajax({
        url: full_path + "group/group.json",
        type: 'get',
        dataType: 'json',
        success: function(data){
            defaultData = data;
        }
    });

    $('#structure_tree').treeview({
        data: defaultData,
        showIcon: false,
        showCheckbox: true,
        onNodeChecked: function(event, node) {//监听节点被check
            VerifyTreeNode();
        },
        onNodeUnchecked: function (event, node) {//监听节点被uncheck
            VerifyTreeNode();
        }
    });
    Replay(checkData,$('#structure_tree').treeview('getUnselected'));
});


/**
 * 回显
 * @constructor
 */
//function RePlay(){
//    var node = $('#structure_tree').treeview('getUnselected');
//    for(var o1 in checkData){
//        if(!(typeof checkData[o1]['nodes'] == 'undefined')){//还有子节点
//            for(var o2 in checkData[o1]['nodes']){
//                for(var temp in node){
//                    if(checkData[o1]['nodes'][o2]['text'] == node[temp]['text']){
//                        $('#structure_tree').treeview('checkNode',node[temp]);
//                        break;
//                    }
//                }
//            }
//        }else{//没有子节点
//            for(var kk in node){
//                if(checkData[o1]['text'] == node[kk]['text']){
//                    $('#structure_tree').treeview('checkNode',node[kk]);
//                    break;
//                }
//            }
//        }
//    }
//}


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
    var obj = $("table > tbody > tr > td > input[type=checkbox]:checked");
    var len = obj.length;
    if(len < 1){
        alert('请选择编辑条目...');
    }else if(len > 1){
        alert('无法批量编辑');
    }else{
       var id =  $(obj).parents('tr').children('td:nth-child(2)').text();
        $.ajax({
            url: full_path + 'sys/Group/Group.json',
            type: 'get',
            dataType: 'json',
            success: function(data){
                Replay(data,$('#structure_tree').treeview('getUnselected'));
                $('#group_modal').modal('show');
            }
        });
    }
}