package com.adam.common.exception;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/28 14:33
 */
public interface ExceptionType {
    /**
     * 异常代码
     *
     * @return
     */
    int getCode();

    /**
     * 异常描述信息
     *
     * @return
     */
    String getDescription();
}
