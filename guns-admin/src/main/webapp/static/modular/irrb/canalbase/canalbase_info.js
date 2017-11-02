/**
 * 初始化渠道基本信息详情对话框
 */
var CanalBaseInfoDlg = {
    canalBaseInfoData: {},
    validateFields: {
        canalId: {
            validators: {
                notEmpty: {
                    message: '编号不能为空'
                },
            }
        }, canalCode: {
            validators: {
                notEmpty: {
                    message: '渠道编码不能为空'
                },
            }
        }, irrId: {
            validators: {
                notEmpty: {
                    message: '灌区编码不能为空'
                },
            }
        }, canalName: {
            validators: {}
        }, canalType: {
            validators: {}
        }, canalLength: {
            validators: {
                numeric: {
                    message: '渠道长度（公里）仅能为数字'
                },
            }
        }, canalControlArea: {
            validators: {
                numeric: {
                    message: '控制面积（万亩）仅能为数字'
                },
            }
        }, canalPlanArea: {
            validators: {
                numeric: {
                    message: '规划供水面积（万亩）仅能为数字'
                },
            }
        }, upperCanalId: {
            validators: {
                notEmpty: {
                    message: '上级渠道标识符不能为空'
                },
            }
        }, upperCanalStake: {
            validators: {
                numeric: {
                    message: '上级渠道桩号仅能为数字'
                },
            }
        }, created: {
            validators: {}
        }, modified: {
            validators: {}
        }
    }
};

/**
 * 清除数据
 */
CanalBaseInfoDlg.clearData = function () {
    this.canalBaseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CanalBaseInfoDlg.set = function (key, val) {
    this.canalBaseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CanalBaseInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CanalBaseInfoDlg.close = function () {
    parent.layer.close(window.parent
        .CanalBase.layerIndex
    )
    ;
}

/**
 * 点击上级渠道input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
CanalBaseInfoDlg.onClickDept = function (e, treeId, treeNode) {
    $("#upperCanal").attr("value", instance.getSelectedVal());
    $("#upperCanalId").attr("value", treeNode.id);
};

/**
 * 显示上级渠道选择的树
 *
 * @returns
 */
CanalBaseInfoDlg.showUperCanalSelectTree = function () {
    var upperCanalObj = $("#upperCanal");
    var upperCanalOffset = $("#upperCanal").offset();
    $("#menuContent").css({
        left: upperCanalOffset.left + "px",
        top: upperCanalOffset.top + upperCanalObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏上级渠道选择的树
 */
CanalBaseInfoDlg.hideDeptSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};

/**
 * 收集数据
 */
CanalBaseInfoDlg.collectData = function () {

    this.set('canalId')
        .set('canalCode')
        .set('irrId')
        .set('canalName')
        .set('canalType')
        .set('canalLength')
        .set('canalControlArea')
        .set('canalPlanArea')
        .set('upperCanalId')
        .set('upperCanalStake')
        .set('created')
        .set('modified')
    ;
}

/**
 * 验证数据是否为空
 */
CanalBaseInfoDlg.validate = function () {
    $('#canalBaseForm').data("bootstrapValidator").resetForm();
    $('#canalBaseForm').bootstrapValidator('validate');
    return $("#canalBaseForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加
 */
CanalBaseInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/canalbase/add", function (data) {
        Feng.success("添加成功!");
        window.parent
            .CanalBase.table.refresh();
        CanalBaseInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.canalBaseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CanalBaseInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/canalbase/update", function (data) {
        Feng.success("修改成功!");
        window.parent
            .CanalBase.table.refresh();
        CanalBaseInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.canalBaseInfoData);
    ajax.start();
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
        CanalBaseInfoDlg.hideDeptSelectTree();
    }
}

$(function () {
    Feng.initValidator("canalBaseForm", CanalBaseInfoDlg.validateFields);

    // 初始化树结构
    var ztree = new $ZTree("treeDemo", "/canalbase/tree");
    ztree.bindOnClick(CanalBaseInfoDlg.onClickDept);
    ztree.init();
    instance = ztree;

    //初始化水源选择列表
    var ajax = new $axGet(Feng.ctxPath + "/irrbase/list", function (data) {

        data.forEach(function (element, index) {
            $("<option value='" + element.irrId + "'>" + element.irrName + "</option>").appendTo("#irrId");
        }, this);
    }, function () {
    }).start();

    //初始化渠道类型选项
    if ($("#canalTypeValue").val() != undefined) {
        $("#canalType").val($("#canalTypeValue").val());
    }

    //初始化所属灌区选项
    if ($("#irrIdValue").val() != undefined) {
        $("#irrId").val($("#irrIdValue").val());
    }

    //初始化地图
    var map = L.map('map').setView([-33.87, 150.77], 10);
    var BaseMaps = new $BaseMaps("basemap", map);
    BaseMaps.init();
});
