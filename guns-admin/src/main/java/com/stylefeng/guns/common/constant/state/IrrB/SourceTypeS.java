package com.stylefeng.guns.common.constant.state.IrrB;

/**
 * @author wangyan
 * @Description: 水源类型的枚举
 * @date 2017年10月19日15:11:00
 */

public enum SourceTypeS {
    DI_BIAO(1, "地表水"),
    DI_XIA(2, "地下水"),

    OHTER(9, "其他");

    int code;
    String message;

    SourceTypeS(int code, String message) {
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

    public static String valueOf(Integer sourceTypeS) {
        if (sourceTypeS == null) {
            return "";
        } else {
            for (SourceTypeS s : SourceTypeS.values()) {
                if (s.getCode() == sourceTypeS) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
