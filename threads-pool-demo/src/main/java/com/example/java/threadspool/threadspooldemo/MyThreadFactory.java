package com.example.java.threadspool.threadspooldemo;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author benjamin
 * created at 2019/6/6
 */
class MyThreadFactory implements ThreadFactory {
    private static final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
    private final Thread.UncaughtExceptionHandler handler;

    public MyThreadFactory(Thread.UncaughtExceptionHandler handler) {
        this.handler = handler;
    }

    @Override
    public Thread newThread(Runnable run) {
        Thread thread = defaultFactory.newThread(run);
        thread.setUncaughtExceptionHandler(handler);
        return thread;
    }
}

class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable t) {
        System.err.println("Uncaught exception is detected! " + t
                + " st: " + Arrays.toString(t.getStackTrace()));
        // ... Handle the exception
    }
}

final class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("My task is started running...");
        // ...
        throw new ArithmeticException();
        // ...
    }
}

class UncaughtExceptionHandler {
    public static void main(String[] args) {
        ThreadFactory factory = new MyThreadFactory(new MyExceptionHandler());
        ExecutorService threadPool = Executors.newFixedThreadPool(10, factory);
        threadPool.execute(new MyTask());
        // ...
        threadPool.shutdown();
    }
}

