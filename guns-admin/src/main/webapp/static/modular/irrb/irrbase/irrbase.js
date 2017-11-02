/**
 * 灌区基本信息管理初始化
 */
var IrrBase = {
    id: "IrrBaseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IrrBase.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},

        {title: '编号', field: 'irrId', visible: false, align: 'center', valign: 'middle'}, {
            title: '灌区编码',
            field: 'irrCode',
            visible: true,
            align: 'center',
            valign: 'middle'
        },{
            title: '灌区名称',
            field: 'irrName',
            visible: true,
            align: 'center',
            valign: 'middle'
        }, {title: '灌区类型', field: 'irrType', visible: false, align: 'center', valign: 'middle'}, {
            title: '灌区类型',
            field: 'irrTypeName',
            visible: true,
            align: 'center',
            valign: 'middle'
        }, {title: '水源编码', field: 'sourceId', visible: false, align: 'center', valign: 'middle'}, {
            title: '水源名称',
            field: 'sourceName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },  {
            title: '上级管理单位',
            field: 'upperManageunit',
            visible: true,
            align: 'center',
            valign: 'middle'
        }, {
            title: '设计灌溉面积',
            field: 'designIrrigateArea',
            visible: true,
            align: 'center',
            valign: 'middle'
        }, {title: '渠首取水位置', field: 'cheadSite', visible: true, align: 'center', valign: 'middle'}, {
            title: '渠首设计流量',
            field: 'cheadFlux',
            visible: true,
            align: 'center',
            valign: 'middle'
        }, {title: '总干渠长度', field: 'trunkLegth', visible: true, align: 'center', valign: 'middle'}, {
            title: '灌溉范围',
            field: 'irrigationArea',
            visible: true,
            align: 'center',
            valign: 'middle'
        }, {title: '创建时间', field: 'created', visible: false, align: 'center', valign: 'middle'}, {
            title: '更新时间',
            field: 'modified',
            visible: false,
            align: 'center',
            valign: 'middle'
        }];
};

/**
 * 检查是否选中
 */
IrrBase.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        IrrBase.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加灌区基本信息
 */
IrrBase.openAddIrrBase = function () {
    var index = layer.open({
        type: 2,
        title: '添加灌区基本信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/irrbase/irrbase_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看灌区基本信息详情
 */
IrrBase.openIrrBaseDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '灌区基本信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/irrbase/irrbase_update/' + IrrBase.seItem.irrId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除灌区基本信息
 */
IrrBase.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/irrbase/delete", function (data) {
            Feng.success("删除成功!");
            IrrBase.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("irrId", this.seItem.irrId);
        ajax.start();
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
IrrBase.formParams = function () {
    var queryData = {};

    queryData['condition'] = $("#condition").val();
    //判断是否为全选
    if ($("#irrType").val() == 0) {
        queryData['irrType'] = null;
    } else {
        queryData['irrType'] = $("#irrType").val();
    }

    return queryData;
}

/**
 * 查询灌区基本信息列表
 */
IrrBase.search = function () {
    IrrBase.table.refresh({query: IrrBase.formParams()});
};

$(function () {
    var defaultColunms = IrrBase.initColumn();
    var table = new BSTable(IrrBase.id, "/irrbase/list", defaultColunms);
    table.setPaginationType("client");
    IrrBase.table = table.init();
});
