package com.adam.common.result;

import java.io.Serializable;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/28 14:59
 */
public class JSONResult implements Serializable {
    /**
     * 返回代码：0-成功，-1-失败
     */
    private int code;
    /**
     * 成功/错误信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 成功返回
     *
     * @param data 返回数据
     * @return
     */
    public static JSONResult success(Object data) {
        JSONResult result = new JSONResult();
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static JSONResult success() {
        return success(null);
    }

    /**
     * 失败
     *
     * @param code 状态码
     * @param msg  失败信息
     * @return
     */
    public static JSONResult failure(Integer code, String msg) {
        JSONResult result = new JSONResult();
        result.setMsg(msg);
        result.setCode(code == null ? -1 : code);
        return result;
    }

    /**
     * 失败
     *
     * @param msg 失败信息
     * @return
     */
    public static JSONResult failure(String msg) {
        return JSONResult.failure(-1, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
