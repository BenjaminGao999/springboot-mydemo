package com.example.base.java.demobasejava.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author benjamin
 * created at 2019/10/8
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        testCompletableFuture();

    }

    private static void testCompletableFuture() {

        //  forkJoinPool.commonPool 默默开启一个线程执行任务
        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());

            System.out.println("doing something");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("不睡了");


        });


        System.out.println("outer executing");

        // 当所有的任务都完整才退出forkJoinPool commonPool
        // 默认System.exit() forkJoinPool.commonPool也退出
        ForkJoinPool.commonPool().awaitQuiescence(3600 * 1000, TimeUnit.MILLISECONDS);


    }
}
