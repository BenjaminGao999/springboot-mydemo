package com.example.springboot.misc.misc.exception;

/**
 * @author gaozhiqiang
 * @since 1.0
 */
public class SignFailedException extends RuntimeException {

    private final String message = "签名验证失败";


    @Override
    public String getMessage() {
        return message;
    }
}
