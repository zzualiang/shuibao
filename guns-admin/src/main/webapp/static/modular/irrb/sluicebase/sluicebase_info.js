/**
 * 初始化水闸信息详情对话框
 */
var SluiceBaseInfoDlg = {
    sluiceBaseInfoData: {},
    validateFields: {
        sluiceId: {
            validators: {
                notEmpty: {
                    message: '编号不能为空'
                },
            }
        }, sluiceCode: {
            validators: {
                notEmpty: {
                    message: '水闸编码不能为空'
                },
            }
        }, sluiceName: {
            validators: {}
        }, sluiceFullName: {
            validators: {}
        }, sluiceAliasName: {
            validators: {}
        }, sluiceType: {
            validators: {}
        }, canalId: {
            validators: {}
        }, sluiceFlow: {
            validators: {
                numeric: {
                    message: '流量(m^3/s)仅能为数字'
                },
            }
        }, strobeNumber: {
            validators: {}
        }, strobeType: {
            validators: {}
        }, strobeHeight: {
            validators: {
                numeric: {
                    message: '闸门高度仅能为数字'
                },
            }
        }, strobeWidth: {
            validators: {
                numeric: {
                    message: '闸门宽度仅能为数字'
                },
            }
        }, strobeThickness: {
            validators: {
                numeric: {
                    message: '闸门厚度仅能为数字'
                },
            }
        }, motivityType: {
            validators: {}
        }, motivityPower: {
            validators: {
                numeric: {
                    message: '启闭机动力仅能为数字'
                },
            }
        }, motivityVelocity: {
            validators: {
                numeric: {
                    message: '启闭速度仅能为数字'
                },
            }
        }, dissipationType: {
            validators: {}
        }, dissipationLength: {
            validators: {
                numeric: {
                    message: '退水渠长(m)仅能为数字'
                },
            }
        }, dissipationSlopeUpperLimit: {
            validators: {
                numeric: {
                    message: '坡降(上限)仅能为数字'
                },
            }
        }, dissipationSlopeLowerLimit: {
            validators: {
                numeric: {
                    message: '坡降(下限)仅能为数字'
                },
            }
        }, constructionTimeUpperLimit: {
            validators: {
                numeric: {
                    message: '施工时间(天)上限仅能为数字'
                },
            }
        }, constructionTimeLowerLimit: {
            validators: {
                numeric: {
                    message: '施工时间(天)下限仅能为数字'
                },
            }
        }, stake: {
            validators: {
                numeric: {
                    message: '桩号仅能为数字'
                },
            }
        }
    }
};

/**
 * 清除数据
 */
SluiceBaseInfoDlg.clearData = function () {
    this.sluiceBaseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SluiceBaseInfoDlg.set = function (key, val) {
    this.sluiceBaseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SluiceBaseInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SluiceBaseInfoDlg.close = function () {
    parent.layer.close(window.parent.SluiceBase.layerIndex);
}

/**
 * 点击渠道input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
SluiceBaseInfoDlg.onClickDept = function (e, treeId, treeNode) {
    $("#canal").attr("value", instance.getSelectedVal());
    $("#canalId").attr("value", treeNode.id);
};

/**
 * 显示渠道选择的树
 *
 * @returns
 */
SluiceBaseInfoDlg.showCanalSelectTree = function () {
    var canalObj = $("#canal");
    var canalOffset = $("#canal").offset();
    $("#menuContent").css({
        left: canalOffset.left + "px",
        top: canalOffset.top + canalObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏渠道选择的树
 */
SluiceBaseInfoDlg.hideDeptSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};

/**
 * 收集数据
 */
SluiceBaseInfoDlg.collectData = function () {

    this.set('sluiceId')
        .set('sluiceCode')
        .set('sluiceName')
        .set('sluiceFullName')
        .set('sluiceAliasName')
        .set('sluiceType')
        .set('canalId')
        .set('sluiceFlow')
        .set('strobeNumber')
        .set('strobeType')
        .set('strobeHeight')
        .set('strobeWidth')
        .set('strobeThickness')
        .set('motivityType')
        .set('motivityPower')
        .set('motivityVelocity')
        .set('dissipationType')
        .set('dissipationLength')
        .set('dissipationSlopeUpperLimit')
        .set('dissipationSlopeLowerLimit')
        .set('constructionTimeUpperLimit')
        .set('constructionTimeLowerLimit')
        .set('stake')
    ;
}

/**
 * 验证数据是否为空
 */
SluiceBaseInfoDlg.validate = function () {
    $('#sluiceBaseForm').data("bootstrapValidator").resetForm();
    $('#sluiceBaseForm').bootstrapValidator('validate');
    return $("#sluiceBaseForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加
 */
SluiceBaseInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sluicebase/add", function (data) {
        Feng.success("添加成功!");
        window.parent
            .SluiceBase.table.refresh();
        SluiceBaseInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sluiceBaseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SluiceBaseInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sluicebase/update", function (data) {
        Feng.success("修改成功!");
        window.parent
            .SluiceBase.table.refresh();
        SluiceBaseInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sluiceBaseInfoData);
    ajax.start();
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
        SluiceBaseInfoDlg.hideDeptSelectTree();
    }
}

$(function () {
    Feng.initValidator("sluiceBaseForm", SluiceBaseInfoDlg.validateFields);

    // 初始化树结构
    var ztree = new $ZTree("treeDemo", "/canalbase/tree");
    ztree.bindOnClick(SluiceBaseInfoDlg.onClickDept);
    ztree.init();
    instance = ztree;

});
