package com.adam.common.exception;

public interface IExceptions {

    int SYSTEM = 1000;

    /**
     * 获取详细的异常信息
     *
     * @return
     */
    ExceptionType getExceptionType();

    /**
     * 默认系统异常信息
     *
     * @return
     */
    static ExceptionType getSystemException() {
        return new ExceptionType() {

            @Override
            public int getCode() {
                return SYSTEM;
            }

            @Override
            public String getDescription() {
                return "系统异常";
            }
        };
    }

}
