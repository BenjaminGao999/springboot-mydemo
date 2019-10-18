package com.example.base.java.demobasejava.parallelism;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author benjamin
 * created at 2019/10/12
 */
public class ParallelismTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

      /*  CompletableFuture<String> result1 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return "s1";
        });

        CompletableFuture<String> result2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return "s2";
        });


        CompletableFuture<String> result3 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return "s3";
        });

        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());*/

        LinkedList<CompletableFuture<String>> futures = new LinkedList<>();

        for (int i = 0; i < 100; i++) {

            int finalI = i;
            CompletableFuture<String> result3 = CompletableFuture.supplyAsync(() -> {

                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                return "result - " + finalI + " - Thread - " + Thread.currentThread().getName();
            });

            futures.add(result3);

        }


        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        // 当所有的任务都完整才退出forkJoinPool commonPool
        // 默认System.exit() forkJoinPool.commonPool也退出
        ForkJoinPool.commonPool().awaitQuiescence(3600 * 1000, TimeUnit.MILLISECONDS);


    }
}
