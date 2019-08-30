package com.example.springboot.misc.misc.common;

import com.example.springboot.misc.misc.exception.ErrorCodeEnum;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应格式
 */
public class ResponseUtil {

    private static final String CODE = "code";
    private static final String DATA = "data";
    private static final String MESSAGE = "message";

    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put(CODE, 0);
        obj.put(DATA, new HashMap<>());
        obj.put(MESSAGE, "成功");
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put(CODE, 0);
        obj.put(DATA, data == null ? new HashMap<>() : data);
        obj.put(MESSAGE, "成功");
        return obj;
    }

    public static Object fail() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put(CODE, -1);
        obj.put(DATA, new HashMap<>());
        obj.put(MESSAGE, "错误");
        return obj;
    }

    public static Object fail(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put(CODE, -1);
        obj.put(DATA, data == null ? new HashMap<>() : data);
        obj.put(MESSAGE, "错误");
        return obj;
    }

    public static Object fail(ErrorCodeEnum errorCodeEnum) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put(CODE, errorCodeEnum.getCode());
        obj.put(DATA, new HashMap<>());
        obj.put(MESSAGE, errorCodeEnum.getMessage());
        return obj;
    }


    public static Object badArgument() {
        return fail(ErrorCodeEnum.ARGUEMENT_ERROR);
    }

    public static Object badArgumentValue() {
        return fail(ErrorCodeEnum.ARGUEMENT_VALUE_ERROR);
    }

    public static Object unlogin() {
        return fail(ErrorCodeEnum.UNLOIGN);
    }

    public static Object serious() {
        return fail(ErrorCodeEnum.SYSTEM_INTERNAL_ERROR);
    }

    public static Object unsupport() {
        return fail(ErrorCodeEnum.SERVICE_UNSUPPORT);
    }


    public static Object argsValidError(String validResult) {
        Map<String, Object> obj = new HashMap<>();
        obj.put(CODE, ErrorCodeEnum.ARGUMENT_VALID_ERROR.getCode());
        obj.put(DATA, new HashMap<>());
        obj.put(MESSAGE, StringUtils.isEmpty(validResult) ? ErrorCodeEnum.ARGUMENT_VALID_ERROR.getMessage() : validResult);
        return obj;
    }
}

