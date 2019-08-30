package com.example.springboot.misc.misc.exception;

public class HttpException extends RuntimeException {

    public HttpException(String message) {
        super(message);
    }

    public HttpException() {
        super("HttpRequest 封装错误!");
    }
}
