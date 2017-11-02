/**
 * 初始化灌区基本信息详情对话框
 */
var IrrBaseInfoDlg = {
    irrBaseInfoData: {},
    validateFields: {
        irrId: {
            validators: {
                notEmpty: {
                    message: '编号不能为空'
                }
            }
        },
        irrCode: {
            validators: {
                notEmpty: {
                    message: '灌区编码不能为空'
                }
            }
        },
        sourceId: {
            validators: {
                notEmpty: {
                    message: '水源编码不能为空'
                }
            }
        },
        irrName: {
            validators: {
                notEmpty: {
                    message: '灌区名称不能为空'
                }
            }
        },
        irrType: {
            validators: {
                notEmpty: {
                    message: '灌区类型不能为空'
                }
            }
        },
        upperManageunit: {
            validators: {
                notEmpty: {
                    message: '上级管理单位不能为空'
                }
            }
        },
        designIrrigateArea: {
            validators: {
                notEmpty: {
                    message: '设计灌溉面积不能为空'
                }
            }
        },
        cheadSite: {
            validators: {
                notEmpty: {
                    message: '渠首取水位置不能为空'
                }
            }
        },
        cheadFlux: {
            validators: {
                notEmpty: {
                    message: '渠首设计流量不能为空'
                }
            }
        },
        trunkLegth: {
            validators: {
                notEmpty: {
                    message: '总干渠长度不能为空'
                }
            }
        },
        irrigationArea: {
            validators: {
                notEmpty: {
                    message: '灌溉范围不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
IrrBaseInfoDlg.clearData = function () {
    this.irrBaseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IrrBaseInfoDlg.set = function (key, val) {
    this.irrBaseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IrrBaseInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IrrBaseInfoDlg.close = function () {
    parent.layer.close(window.parent.IrrBase.layerIndex);
}

/**
 * 收集数据
 */
IrrBaseInfoDlg.collectData = function () {

    this.set('irrId')
        .set('irrCode')
        .set('sourceId')
        .set('irrName')
        .set('irrType')
        .set('upperManageunit')
        .set('designIrrigateArea')
        .set('cheadSite')
        .set('cheadFlux')
        .set('trunkLegth')
        .set('irrigationArea')
        .set('created')
        .set('modified');
}

/**
 * 验证数据是否为空
 */
IrrBaseInfoDlg.validate = function () {
    $('#irrBaseForm').data("bootstrapValidator").resetForm();
    $('#irrBaseForm').bootstrapValidator('validate');
    return $("#irrBaseForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加
 */
IrrBaseInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/irrbase/add", function (data) {
        Feng.success("添加成功!");
        window.parent.IrrBase.table.refresh();
        IrrBaseInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.irrBaseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IrrBaseInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/irrbase/update", function (data) {
        Feng.success("修改成功!");
        window.parent.IrrBase.table.refresh();
        IrrBaseInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.irrBaseInfoData);
    ajax.start();
}

$(function () {
    Feng.initValidator("irrBaseForm", IrrBaseInfoDlg.validateFields);

    //初始化水源选择列表
    var ajax = new $axGet(Feng.ctxPath + "/sourcebase/list", function (data) {

        data.forEach(function (element, index) {
            $("<option value='" + (index + 1) + "'>" + element.sourceName + "</option>").appendTo("#sourceId");
        }, this);
    }, function () {}).start();

    //初始化灌区类型选项
    if ($("#irrTypeValue").val() != undefined) {
        $("#irrType").val($("#irrTypeValue").val());
    }

    //初始化灌区类型选项
    if ($("#sourceIdValue").val() != undefined) {
        $("#sourceId").val($("#sourceIdValue").val());
    }

});