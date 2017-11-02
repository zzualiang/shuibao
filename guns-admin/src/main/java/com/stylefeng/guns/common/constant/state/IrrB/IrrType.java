package com.stylefeng.guns.common.constant.state.IrrB;

/**
 * @author wangyan
 * @Description: 灌区类型的枚举
 * @date 2017年10月19日15:11:00
 */

public enum IrrType {
    DA_XING(1, "大型灌区"),
    ZHONG_XING(2, "中型灌区"),
    XIAO_XING(3, "小型灌区"),
    OHTER(9, "其他");

    int code;
    String message;

    IrrType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer irrType) {
        if (irrType == null) {
            return "";
        } else {
            for (IrrType s : IrrType.values()) {
                if (s.getCode() == irrType) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
