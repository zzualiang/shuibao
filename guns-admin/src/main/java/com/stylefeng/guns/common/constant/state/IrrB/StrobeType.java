package com.stylefeng.guns.common.constant.state.IrrB;

/**
 * @author wangyan
 * @Description: 闸门类型的枚举
 * @date 2017年10月19日15:11:00
 */

public enum StrobeType {
    GANG_PING(1, "钢平板"),
    MU_PING(2, "木平板"),
    GANG_WANG_PING(3, "钢网平板"),
    GANG_WANG_BIAN(4, "钢网扁壳"),
    BIAN_KE(5, "扁壳门"),
    GANG_SI_WANG(6, "钢丝网水"),
    NI_FANXIANG_BIAN(7, "泥反向扁壳"),
    GONG_PING(8, "砼平板"),

    OHTER(9, "其他");

    int code;
    String message;

    StrobeType(int code, String message) {
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

    public static String valueOf(Integer strobeType) {
        if (strobeType == null) {
            return "";
        } else {
            for (StrobeType s : StrobeType.values()) {
                if (s.getCode() == strobeType) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
