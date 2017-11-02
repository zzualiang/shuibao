package com.stylefeng.guns.common.constant.state.IrrB;

/**
 * @author wangyan
 * @Description: 水源工程类型的枚举
 * @date 2017年10月19日15:11:00
 */

public enum SourceTypeB {
    SHUIKu(1, "水库"),
    HELIU(2, "河流"),
    JIN(3, "井"),
    OHTER(9, "其他");

    int code;
    String message;

    SourceTypeB(int code, String message) {
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

    public static String valueOf(Integer sourceTypeB) {
        if (sourceTypeB == null) {
            return "";
        } else {
            for (SourceTypeB s : SourceTypeB.values()) {
                if (s.getCode() == sourceTypeB) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
