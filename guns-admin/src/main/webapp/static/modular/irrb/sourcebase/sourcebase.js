/**
 * 水源信息管理初始化
 */
var SourceBase = {
    id: "SourceBaseTable",	//表格id
    seItem:
        null,		//选中的条目
    table:
        null,
    layerIndex:
        -1
};

/**
 * 初始化表格的列
 */
SourceBase.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},

        {
            title: '水源编码',
            field: 'sourceId',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水源编码',
            field: 'sourceCode',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水源名称',
            field: 'sourceName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水源工程类型',
            field: 'sourceTypeB',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水源工程类型',
            field: 'sourceTypeBName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水源类型',
            field: 'sourceTypeS',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水源类型',
            field: 'sourceTypeSName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '创建时间',
            field: 'created',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '更新时间',
            field: 'modified',
            visible: false,
            align: 'center',
            valign: 'middle'
        }
    ];
};

/**
 * 检查是否选中
 */
SourceBase.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        SourceBase.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加水源信息
 */
SourceBase.openAddSourceBase = function () {
    var index = layer.open({
        type: 2,
        title: '添加水源信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sourcebase/sourcebase_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看水源信息详情
 */
SourceBase.openSourceBaseDetail = function () {
    if (this.check()) {
        var index = layer.open({
                type: 2,
                title: '水源信息详情',
                area: ['800px', '420px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/sourcebase/sourcebase_update/' + SourceBase.seItem.sourceId
            })
        ;
        this.layerIndex = index;
    }
};

/**
 * 删除水源信息
 */
SourceBase.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sourcebase/delete", function (data) {
            Feng.success("删除成功!");
            SourceBase
                .table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sourceId", this.seItem.sourceId);
        ajax.start();
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
SourceBase.formParams = function () {
    var queryData = {};

    queryData['condition'] = $("#condition").val();
    //判断是否为全选
    if ($("#sourceTypeS").val() == 0) {
        queryData['sourceTypeS'] = null;
    } else {
        queryData['sourceTypeS'] = $("#sourceTypeS").val();
    }

    if ($("#sourceTypeB").val() == 0) {
        queryData['sourceTypeB'] = null;
    } else {
        queryData['sourceTypeB'] = $("#sourceTypeB").val();
    }

    return queryData;
}

/**
 * 查询水源信息列表
 */
SourceBase.search = function () {
    SourceBase.table.refresh({query: SourceBase.formParams()});
};

$(function () {
    var defaultColunms = SourceBase.initColumn();
    var table = new BSTable(SourceBase.id, "/sourcebase/list", defaultColunms);
    table.setPaginationType("client");
    SourceBase.table = table.init();
});
