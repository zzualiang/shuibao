/**
 * 渠道基本信息管理初始化
 */
var CanalBase = {
    id: "CanalBaseTable",	//表格id
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
CanalBase.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},

        {
            title: '编号',
            field: 'canalId',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '渠道编码',
            field: 'canalCode',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '灌区编码',
            field: 'irrId',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '所属灌区',
            field: 'irrName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '渠道名称',
            field: 'canalName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '渠道类型',
            field: 'canalType',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '渠道类型',
            field: 'canalTypeName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '渠道长度（公里）',
            field: 'canalLength',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '控制面积（万亩）',
            field: 'canalControlArea',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '规划供水面积（万亩）',
            field: 'canalPlanArea',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '上级渠道标识符',
            field: 'upperCanalId',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '上级渠道',
            field: 'upperCanalName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '上级渠道桩号',
            field: 'upperCanalStake',
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
CanalBase.check = function () {
    var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        CanalBase.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加渠道基本信息
 */
CanalBase.openAddCanalBase = function () {
    var index = layer.open({
        type: 2,
        title: '添加渠道基本信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/canalbase/canalbase_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看渠道基本信息详情
 */
CanalBase.openCanalBaseDetail = function (type) {

    ;

    if (this.check()) {
        var index = layer.open({
                type: 2,
                title: '渠道基本信息详情',
                area: [($('.wrapper').width()-554)+'px', ($('.wrapper').height()-154)+'px'], //宽高
                fix: false, //不固定
                maxmin: true,
                anim: 0,
                content: Feng.ctxPath + '/canalbase/canalbase_' + type + '/' + CanalBase.seItem.id
            })
        ;
        this.layerIndex = index;
        if (type == 'info') layer.full(index);
    }
};

/**
 * 删除渠道基本信息
 */
CanalBase.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/canalbase/delete", function (data) {
            Feng.success("删除成功!");
            CanalBase
                .table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("canalId", this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
CanalBase.formParams = function () {
    var queryData = {};

    queryData['condition'] = $("#condition").val();
    //判断是否为全选
    if ($("#canalType").val() == 0) {
        queryData['canalType'] = null;
    } else {
        queryData['canalType'] = $("#canalType").val();
    }

    if ($("#irrId").val() == 0) {
        queryData['irrId'] = null;
    } else {
        queryData['irrId'] = $("#irrId").val();
    }

    return queryData;
}

/**
 * 查询渠道基本信息列表
 */
CanalBase.search = function () {
    CanalBase.table.refresh({query: CanalBase.formParams()});
};

$(function () {
    var defaultColunms = CanalBase
        .initColumn();
    var table = new BSTreeTable(CanalBase.id, "/canalbase/list", defaultColunms);
    table.setExpandColumn(2);
    table.setIdField("canalId");
    table.setCodeField("canalId");
    table.setParentCodeField("upperCanalId");
    table.setExpandAll(true);
    table.init();
    CanalBase.table = table;

    //初始化水源选择列表
    var ajax = new $axGet(Feng.ctxPath + "/irrbase/list", function (data) {

        data.forEach(function (element, index) {
            $("<option value='" + element.irrId + "'>" + element.irrName + "</option>").appendTo("#irrId");
        }, this);
    }, function () {
    }).start();
});
