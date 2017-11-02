/**
 * 水闸信息管理初始化
 */
var SluiceBase = {
    id: "SluiceBaseTable",	//表格id
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
SluiceBase.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},

        {
            title: '编号',
            field: 'sluiceId',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水闸编码',
            field: 'sluiceCode',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '工程简称',
            field: 'sluiceName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '工程全称',
            field: 'sluiceFullName',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '工程别名',
            field: 'sluiceAliasName',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水闸类别',
            field: 'sluiceType',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '水闸类别',
            field: 'sluiceTypeName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '所属渠段',
            field: 'canalId',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '所属渠段',
            field: 'canalName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '流量(m^3/s)',
            field: 'sluiceFlow',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '闸门孔数',
            field: 'strobeNumber',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '闸门型式',
            field: 'strobeType',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '闸门型式',
            field: 'strobeTypeName',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '闸门高度',
            field: 'strobeHeight',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '闸门宽度',
            field: 'strobeWidth',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '闸门厚度',
            field: 'strobeThickness',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '启闭机样式',
            field: 'motivityType',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '启闭机动力',
            field: 'motivityPower',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '启闭速度',
            field: 'motivityVelocity',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '消能工型式',
            field: 'dissipationType',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '退水渠长(m)',
            field: 'dissipationLength',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '坡降',
            field: 'dissipationSlopeLimit',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '坡降(上限)',
            field: 'dissipationSlopeUpperLimit',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '坡降(下限)',
            field: 'dissipationSlopeLowerLimit',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '施工时间(天)',
            field: 'constructionTimeLimit',
            visible: true,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '施工时间(天)上限',
            field: 'constructionTimeUpperLimit',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '施工时间(天)下限',
            field: 'constructionTimeLowerLimit',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '桩号',
            field: 'stake',
            visible: false,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '桩号',
            field: 'stakeFormat',
            visible: true,
            align: 'center',
            valign: 'middle'
        }
    ];
};

/**
 * 检查是否选中
 */
SluiceBase.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        SluiceBase.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加水闸信息
 */
SluiceBase.openAddSluiceBase = function () {
    var index = layer.open({
        type: 2,
        title: '添加水闸信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sluicebase/sluicebase_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看水闸信息详情
 */
SluiceBase.openSluiceBaseDetail = function () {
    if (this.check()) {
        var index = layer.open({
                type: 2,
                title: '水闸信息详情',
                area: ['800px', '420px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/sluicebase/sluicebase_update/' + SluiceBase.seItem.sluiceId
            })
        ;
        this.layerIndex = index;
    }
};

/**
 * 删除水闸信息
 */
SluiceBase.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sluicebase/delete", function (data) {
            Feng.success("删除成功!");
            SluiceBase
                .table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sluiceId", this.seItem.sluiceId);
        ajax.start();
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
SluiceBase.formParams = function () {
    var queryData = {};

    queryData['condition'] = $("#condition").val();
    //判断是否为全选

    return queryData;
}

/**
 * 查询水闸信息列表
 */
SluiceBase.search = function () {
    SluiceBase.table.refresh({query: SluiceBase.formParams()});
};

$(function () {
    var defaultColunms = SluiceBase
        .initColumn();
    var table = new BSTable(SluiceBase.id, "/sluicebase/list", defaultColunms
        )
    ;
    table.setPaginationType("client");
    SluiceBase
        .table = table.init();
});
