var defaultData = [
    {
        href: '1',
        text: '上网助手服务',
        nodes: [
            {
                href: '2',
                text: '全国包上网助手马尾机房'
            },
            {
                href: '3',
                text: '浙江上网助手服务器组'
            }
        ]
    },
    {
        href: '4',
        text: 'Portal平台服务器',
        nodes: [
            {href: '5', text: '福建Potal服务器组'},
            {href: '6', text: '新店服务器组'}
        ]
    },
    {
        href: '6',
        text: '其他服务',
        nodes: [
            {href: '7', text: '福建省上网助手云平台'},
            {href: '8', text: '福建天翼客服'},
            {href: '9', text: '服保保障系统'}
        ]
    }
];


var cityNode = [
    {
        id: '101', name: '福建省', node: [
        {id: '10101', name: '福州'},
        {id: '10102', name: '厦门'},
        {id: '10102', name: '莆田'}
    ]
    },
    {
        id: '102', name: '海南省', node: [
        {id: '10201', name: '海口'},
        {id: '10202', name: '三亚'},
        {id: '10202', name: '琼州'}
    ]
    },
    {
        id: '103', name: '广东省', node: [
        {id: '10301', name: '广州'},
        {id: '10302', name: '东莞'},
        {id: '10303', name: '深圳'},
        {id: '10304  ', name: '清远'}
    ]
    }
];


var orgData = [{id: '101', name: '上网助手服务'}, {id: '102', name: 'Portal平台服务器'}, {id: '103', name: '上网助手云平台'}];
/**
 * 获取所有组
 * @constructor
 */
function GetAllOrg() {
    $.ajax({
        url: full_path + 'comm/',
        type: 'get',
        dataType: 'json',
        async: false,
        success: function (data) {
            orgData = data;
        }
    });
}


/**
 * 展示省份
 * @param obj select的id
 * @param data 所有数据
 * @constructor
 */
var DisPlayProvince = function (obj, data) {
    var node = "<option>--请选择--</option>";
    for (var o in data) {
        node = node + "<option value='" + data[o]['id'] + "'>" + data[o]['name'] + "</option>";
    }
    $('#' + obj).empty();
    $('#' + obj).append(node);
};

/**
 * 展示城市
 * @param obj select的id
 * @param data 所有数据
 * @param str 已选择省份的数据
 * @constructor
 */
var DisPlayCity = function (obj, data, str) {
    var node = "<option>--请选择--</option>";
    for (var i in data) {
        if (data[i]['name'] == str) {
            for (var o in data[i]['node']) {
                node = node + "<option value='" + data[i]['node'][o]['id'] + "'>" + data[i]['node'][o]['name'] + "</option>";
            }
        }
    }
    $('#' + obj).empty();
    $('#' + obj).append(node);
};


/**
 * 新增服务器组
 * @constructor
 */
function AddOrg() {
    //设置表单提交路径
    $('#org_form').attr('target','com/');
    //获取所有分组
    // GetAllOrg();

    //把分组添加到select中
    DisPlayOrg('orgs', orgData);

    //显示modal
    $('#org_modal').modal('show');
}

/**
 * 编辑分组信息
 * @constructor
 */
function EditOrg() {
    //设置表单提交路径
    $('#org_form').attr('target','com/');
    //获取选中的item
    var obj = $('#sever_tree').treeview('getSelected');
    if (obj.length < 1) {
        alert('请选择编辑条目...');
    } else {
        $.ajax({
            url: full_path + 'comm/',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                //刷新当前页面
            }
        });
    }
}

/**
 * 删除分组
 * @constructor
 */
function DeleteOrg() {
    var obj = $('#sever_tree').treeview('getSelected');
    if (obj.length < 1) {
        alert('请选择删除条目...');
    } else {
        if (typeof obj[0]['nodes'] != 'undefined' && obj[0]['nodes'].length > 0) {
            alert('请先删除子节点...');
        } else {
            $.ajax({
                url: full_path + 'comm/ ?id=' + obj[0]['href'],
                type: 'get',
                dataType: 'json',
                success: function (data) {
                    //刷新当前页面
                }
            });
        }
    }
}

/**
 * 保存组信息
 * @constructor
 */
function SaveOrg(){
    var target = $('#org_form').attr('target');
    $.ajax({
        url: full_path + target,
        type: 'post',
        data: $('#org_form').serialize(),
        dataType: 'json',
        success: function(data){

        }
    });
}

/**
 * 在select中显示分组，包括回显
 * @param obj select的ID
 * @param data 所有分组数据
 * @param str 选中的分组数据
 * @constructor
 */
function DisPlayOrg(obj, data, str) {
    if (typeof  str == 'undefined') {
        str = '0';
    }
    var node = "<option value='0'>根目录</option>";
    for (var o in data) {
        if (data[o]['id'] == str) {
            node = node + "<option value='" + data[o]['id'] + "' selected>" + data[o]['name'] + "</option>";
        } else {
            node = node + "<option value='" + data[o]['id'] + "'>" + data[o]['name'] + "</option>";
        }
    }
    $('#' + obj).empty();
    $('#' + obj).append(node);
}



$(function () {
    var $expandibleTree = $('#sever_tree').treeview({
        data: defaultData
    });

    DisPlayProvince('province_id', cityNode);
    $('#province_id').change(function () {
        DisPlayCity('city_id', cityNode, $('#province_id > option:selected').text());
    });
});