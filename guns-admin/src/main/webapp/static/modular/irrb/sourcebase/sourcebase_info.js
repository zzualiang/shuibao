/**
 * 初始化水源信息详情对话框
 */
var SourceBaseInfoDlg = {
    sourceBaseInfoData: {},
    validateFields: {
        sourceId: {
            validators: {
                notEmpty: {
                    message: '水源编码不能为空'
                }
            }
        }, sourceCode: {
            validators: {
                notEmpty: {
                    message: '水源编码不能为空'
                }
            }
        }, sourceName: {
            validators: {
                notEmpty: {
                    message: '水源名称不能为空'
                }
            }
        }, sourceTypeB: {
            validators: {
                notEmpty: {
                    message: '水源工程类型不能为空'
                }
            }
        }, sourceTypeS: {
            validators: {
                notEmpty: {
                    message: '水源类型不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
SourceBaseInfoDlg.clearData = function () {
    this.sourceBaseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SourceBaseInfoDlg.set = function (key, val) {
    this.sourceBaseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SourceBaseInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SourceBaseInfoDlg.close = function () {
    parent.layer.close(window.parent
        .SourceBase.layerIndex
    )
    ;
}

/**
 * 收集数据
 */
SourceBaseInfoDlg.collectData = function () {

    this.set('sourceId')
        .set('sourceCode')
        .set('sourceName')
        .set('sourceTypeB')
        .set('sourceTypeS')
        .set('created')
        .set('modified');
}

/**
 * 验证数据是否为空
 */
SourceBaseInfoDlg.validate = function () {
    $('#sourceBaseForm').data("bootstrapValidator").resetForm();
    $('#sourceBaseForm').bootstrapValidator('validate');
    return $("#sourceBaseForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加
 */
SourceBaseInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sourcebase/add", function (data) {
        Feng.success("添加成功!");
        window.parent
            .SourceBase.table.refresh();
        SourceBaseInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sourceBaseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SourceBaseInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //校验信息
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sourcebase/update", function (data) {
        Feng.success("修改成功!");
        window.parent
            .SourceBase.table.refresh();
        SourceBaseInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sourceBaseInfoData);
    ajax.start();
}

$(function () {
    Feng.initValidator("sourceBaseForm", SourceBaseInfoDlg.validateFields);

    //初始化水源类型选项
    if($("#sourceTypeSValue").val()!=undefined){
        $("#sourceTypeS").val($("#sourceTypeSValue").val());
    }

    //初始化水源工程类型选项
    if($("#sourceTypeBValue").val()!=undefined){
        $("#sourceTypeB").val($("#sourceTypeBValue").val());
    }

});
