package com.stylefeng.guns.common.constant.state.IrrB;

/**
 * @author wangyan
 * @Description: 渠道类型的枚举
 * @date 2017年10月19日15:11:00
 */

public enum CanalType {
    ZHU(1, "主干渠"),
    GAN(2, "干渠"),
    ZHI(3, "支渠"),
    DOU(4, "斗渠"),
    NONG(5,"农渠"),
    OHTER(9, "其他");

    int code;
    String message;

    CanalType(int code, String message) {
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

    public static String valueOf(Integer canalType) {
        if (canalType == null) {
            return "";
        } else {
            for (CanalType s : CanalType.values()) {
                if (s.getCode() == canalType) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
