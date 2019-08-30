package com.example.springboot.misc.misc.config;


import com.example.springboot.misc.misc.common.ResponseUtil;
import com.example.springboot.misc.misc.exception.ErrorCodeEnum;
import com.example.springboot.misc.misc.exception.SignFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 捕获系统异常
 */
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalEscapeExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalEscapeExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        logger.error("接口请求Handler映射失败或方法内执行错误: ", e);
        return ResponseUtil.serious();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Object argumentHandler(MethodArgumentTypeMismatchException e) {
        logger.error("参数类型匹配错误: ", e);
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Object httpMessageNotReadableHandler(HttpMessageNotReadableException e) {
        logger.error("请求参数无法读取: ", e);
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object methodArgumentNotValid(MethodArgumentNotValidException e) {
        logger.error("请求参数校验出错: ", e);
        return ResponseUtil.argsValidError(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Object httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        logger.error("请求方式出错: ", e);
        return ResponseUtil.fail(ErrorCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED);
    }


    @ExceptionHandler(value = {SignFailedException.class})
    @ResponseBody
    public Object signFailed(SignFailedException e) {
        logger.error("签名验证失败");
        return ResponseUtil.argsValidError(e.getMessage());
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    public Object illegalArgumentException(IllegalArgumentException e) {
        logger.error("非法参数异常");
        return ResponseUtil.argsValidError(e.getMessage());
    }

}
