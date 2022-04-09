package com.adam.account.handler;

import com.adam.common.exception.BusinessException;
import com.adam.common.exception.Exceptions;
import com.adam.common.result.JSONResult;
import org.apache.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/28 14:55
 */
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private String profile;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    private void init() {
//        this.profile = context.getEnvironment().getActiveProfiles()[0];
    }

    /**
     * 远程服务调用异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RpcException.class)
    @ResponseBody
    public JSONResult handler(RpcException e) {
        logger.error("业务异常:", e);
        if (printError()) {
            e.printStackTrace();
        }
        return JSONResult.failure(e.getCode(), e.getMessage());
    }

    /**
     * 业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public JSONResult handler(BusinessException e) {
        logger.error("业务异常:", e);
        if (printError()) {
            e.printStackTrace();
        }
        return JSONResult.failure(e.getCode(), e.getMessage());
    }


    /**
     * 未被关注的异常信息，统一返回给客户端为“系统异常”
     *
     * @param e
     * @param response
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONResult exceptionHandler(Exception e, HttpServletResponse response, HttpServletRequest request) {
        logger.error("系统异常:", e);
        if (printError()) {
            e.printStackTrace();
        }
        return JSONResult.failure(-1, "系统异常");
    }

    /**
     * 请求方法错误
     *
     * @param e
     * @param response
     * @param request
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public JSONResult methodNotSupport(HttpRequestMethodNotSupportedException e, HttpServletResponse response, HttpServletRequest request) {
        logger.error("系统异常:", e);
        if (printError()) {
            e.printStackTrace();
        }
        return JSONResult.failure(-1, "不支持【" + e.getMethod() + "】请求方法");
    }

    /**
     * 参数错误异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class, BindException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    public JSONResult handler(Exception e) {
        logger.error("参数异常:", e);
        if (printError()) {
            e.printStackTrace();
        }
        String defaultMessage = ((BeanPropertyBindingResult) ((BindException) e).getBindingResult()).getAllErrors().get(0).getDefaultMessage();
        return JSONResult.failure(Exceptions.System.REQUEST_PARAM_ERROR.getCode(), defaultMessage);
    }

    /**
     * Hibernate Validator参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JSONResult handler(MethodArgumentNotValidException e) {
        if (printError()) {
            e.printStackTrace();
        }
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().get(0);
        return JSONResult.failure(Exceptions.System.REQUEST_PARAM_ERROR.getCode(), objectError.getDefaultMessage());
    }

    /**
     * Spring Validator参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public JSONResult handler(ConstraintViolationException e) {
        if (printError()) {
            e.printStackTrace();
        }
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            String message = constraintViolation.getMessage();
            if (!StringUtils.isEmpty(message)) {
                //直接返回第一个错误信息
                return JSONResult.failure(Exceptions.System.REQUEST_PARAM_ERROR.getCode(), message);
            }
        }
        return JSONResult.failure(Exceptions.System.REQUEST_PARAM_ERROR.getCode(), Exceptions.System.REQUEST_PARAM_ERROR.getDescription());
    }

    private boolean printError() {
        return "dev_uat".equals(this.profile) || "dev".equals(this.profile) || "uat".equals(this);
    }
}
