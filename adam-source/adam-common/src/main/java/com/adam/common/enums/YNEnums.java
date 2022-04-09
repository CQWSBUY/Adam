package com.adam.common.enums;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: 状态
 * @date 2021/12/28 9:02
 */
public enum YNEnums {
    Y("Y","是"),
    PASS("N","否");

    private String code;

    private String msg;

    YNEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
