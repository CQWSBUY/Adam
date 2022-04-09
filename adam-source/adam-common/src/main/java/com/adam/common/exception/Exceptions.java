package com.adam.common.exception;

public interface Exceptions {

    interface Constant {
        /**
         * 系统异常
         */
        int SYSTEM = 1000;

    }

    /**
     * 系统异常
     */
    enum System implements ExceptionType, IExceptions {

        SYSTEM_ERROR(SYSTEM + 1, "当前服务器繁忙，请稍后再试"),
        ACCESS_TOKEN_NULL(SYSTEM + 2, "认证参数不能为空"),
        ACCESS_TOKEN_INVALID(SYSTEM + 3, "登录超时，请重新登录"),
        OPERATION_NOT_AUTHORITY(SYSTEM + 4, "没有操作权限"),
        REQUEST_PARAM_ERROR(SYSTEM + 5, "参数错误"),
        URL_ENCODE_ERROR(SYSTEM + 6, "请求参数编码错误"),
        TYPE_ERROR(SYSTEM + 7, "类型错误"),
        RPC_ERROR(SYSTEM + 8, "远程接口调用失败"),
        ;


        System(int code, String description) {
            this.code = code;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public ExceptionType getExceptionType() {
            return this;
        }
    }

}
