package com.example.java.threadspool.threadspooldemo;

/**
 * @author benjamin
 * created at 2019/6/6
 */
public class MyCheckedException extends Exception {
    @Override
    public String getMessage() {
//        return super.getMessage();
        return "自定义的unchecked异常";
    }
}
