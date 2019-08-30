package com.example.springboot.misc.misc.exception;

/**
 * @author benjamin
 * created at 2019/8/21
 */
public class MyException extends RuntimeException{

    public MyException(String message) {
        super(message);
    }
}
