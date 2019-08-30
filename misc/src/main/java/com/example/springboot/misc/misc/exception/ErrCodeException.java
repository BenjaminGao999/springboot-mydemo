package com.example.springboot.misc.misc.exception;

public class ErrCodeException extends RuntimeException {
    public ErrCodeException() {
        super("ErrorCodeException");
    }
}
