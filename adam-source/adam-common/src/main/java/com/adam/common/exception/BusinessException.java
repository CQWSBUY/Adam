package com.adam.common.exception;

import org.apache.dubbo.rpc.RpcException;
import org.springframework.util.StringUtils;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/28 14:36
 */
public class BusinessException extends RpcException {

    /**
     * 异常状态码
     */
    private int code;

    /**
     * 异常描述
     */
    private String description;

    /**
     * 业务异常基础接口
     */
    private ExceptionType type;

    public BusinessException() {
        super();
    }

    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException(ExceptionType type) {
        this(type.getCode(),type.getDescription(),type);
    }

    public BusinessException(String message) {
        this(IExceptions.getSystemException(), message);
    }

    public BusinessException(Integer code) {
        this(code, null);
    }

    public BusinessException(Integer code, String message) {
        super(code,message);
        this.code = code;
        this.description = message;
    }

    public BusinessException(ExceptionType type, String desc) {
        this(type.getCode(), desc, type);
    }

    private BusinessException(Integer code, String description, ExceptionType type, Throwable cause) {
        super(description, cause);
        this.code = code;
        this.description = description;
    }

    private BusinessException(Integer code, String description, ExceptionType type) {
        super(code, description);
        this.code = code;
        this.description = description;
        this.type = type;
    }

    @Override
    public String getMessage() {
        String msg = "";
        if (StringUtils.hasText(this.description)) {
            msg += this.description;
            return msg;
        }
        if (StringUtils.hasText(this.type.getDescription())) {
            if (StringUtils.hasText(msg)) {
                msg += ":";
            }
            msg += this.type.getDescription();
        }
        if (this.type == null && StringUtils.isEmpty(this.description)) {
            return super.getCause().getMessage();
        }
        return msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public ExceptionType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusinessException other = (BusinessException) obj;
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }
}
