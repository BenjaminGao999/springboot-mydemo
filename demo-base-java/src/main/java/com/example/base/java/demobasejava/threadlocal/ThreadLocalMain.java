package com.example.base.java.demobasejava.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author benjamin
 * created at 2019/6/28
 */
public class ThreadLocalMain {

    private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();


    public static void main(String[] args) {

//        main >> th1 1000
//        main >> th2 2000
//        pool-1-thread-1 >> th1 null
//        pool-1-thread-1 >> th2 null
//        pool-1-thread-2 >> th1 null
//        pool-1-thread-2 >> th2 null

        ExecutorService threadPool =
                Executors.newFixedThreadPool(3);

        threadLocal1.set(1000);
        threadLocal2.set(2000);

        Runnable run1 = () -> {
            System.out.println(Thread.currentThread().getName() + " >> th1 " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + " >> th2 " + threadLocal2.get());

        };

        Runnable run2 = () -> {
            System.out.println(Thread.currentThread().getName() + " >> th1 " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + " >> th2 " + threadLocal2.get());

        };

        System.out.println(Thread.currentThread().getName() + " >> th1 " + threadLocal1.get());
        System.out.println(Thread.currentThread().getName() + " >> th2 " + threadLocal2.get());


        threadPool.execute(run1);

        threadPool.execute(run2);

        threadPool.shutdown();


    }


}
