package com.adam.common.asserts;

import com.adam.common.exception.ExceptionType;
import com.google.common.base.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.util.ObjectUtils;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/28 14:45
 */
public class BusinessAsserts {

    private BusinessAsserts() {
    }

    public static void isFalse(boolean expression, ExceptionType throwing, String msg, Object... args) {
        isTrue(!expression, throwing, msg, args);
    }

    public static void isFalse(boolean expression, ExceptionType throwing) {
        isTrue(!expression, throwing, "");
    }

    public static void isTrue(boolean expression, ExceptionType throwing) {
        isTrue(expression, throwing, "");
    }

    /**
     * @param expression
     * @param throwing
     * @param msg        异常消息模板,使用String.format
     * @param args       异常消息填充参数
     */
    public static void isTrue(boolean expression, ExceptionType throwing, String msg, Object... args) {
        if (!expression) {
            try {
                msg = String.format(msg, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }


    public static void notNull(Object object, ExceptionType throwing) {
        notNull(object, throwing, "");
    }

    public static void notNull(Object object, ExceptionType throwing, String msg, Object... args) {
        if (ObjectUtils.isEmpty(object)) {
            msg =String.format(msg, args);
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }

    public static void isNull(Object object, ExceptionType throwing) {
        isNull(object, throwing, "");
    }

    public static void isNull(Object object, ExceptionType throwing, String msg, Object... args) {
        if (!ObjectUtils.isEmpty(object)) {
            msg =String.format(msg, args);
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }

    public static void notBlank(String string, ExceptionType throwing) {
        notBlank(string, throwing, "");
    }

    public static void notBlank(String string, ExceptionType throwing, String msg, Object... args) {
        if (StringUtils.isBlank(string)) {
            msg =String.format(msg, args);
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }

    public static void isBlank(String string, ExceptionType throwing) {
        isBlank(string, throwing, "");
    }

    public static void isBlank(String string, ExceptionType throwing, String msg, Object... args) {
        if (StringUtils.isNoneBlank(string)) {
            msg =String.format(msg, args);
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }

    public static void notEqual(Object object1, Object object2, ExceptionType throwing) {
        notEqual(object1, object2, throwing, "");
    }

    public static void notEqual(Object object1, Object object2, ExceptionType throwing, String msg, Object... args) {
        if (Objects.equal(object1, object2)) {
            msg =String.format(msg, args);
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }

    public static void isEqual(Object object1, Object object2, ExceptionType throwing) {
        isEqual(object1, object2, throwing, "");
    }

    public static void isEqual(Object object1, Object object2, ExceptionType throwing, String msg, Object... args) {
        if (!Objects.equal(object1, object2)) {
            msg =String.format(msg, args);
            throw new RpcException(throwing.getCode(), StringUtils.isBlank(msg) ? throwing.getDescription() : msg);
        }
    }
}
