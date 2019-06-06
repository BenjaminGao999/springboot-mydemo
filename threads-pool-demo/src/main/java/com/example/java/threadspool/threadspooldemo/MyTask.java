package com.example.java.threadspool.threadspooldemo;

/**
 * @author benjamin
 * created at 2019/6/6
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("My task is started running...");
        // ...
        throw new ArithmeticException(); // uncatched exception
        // ...
    }
}
