package com.stylefeng.guns.common.constant.state.IrrB;

/**
 * @author wangyan
 * @Description: 闸类型的枚举
 * @date 2017年10月19日15:11:00
 */

public enum SluiceType {
    YIN_SHUI(1, "引水闸"),
    FEN_ZHI(2, "分水闸"),
    XIE_SHUI(3, "泄水闸"),
    JIE_ZHI(4,"节制闸"),
    CHONG_SHA(5,"冲沙闸"),
    TUI_SHUI(6,"退水闸"),
    OHTER(9, "其他");

    int code;
    String message;

    SluiceType(int code, String message) {
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

    public static String valueOf(Integer sluiceType) {
        if (sluiceType == null) {
            return "";
        } else {
            for (SluiceType s : SluiceType.values()) {
                if (s.getCode() == sluiceType) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
