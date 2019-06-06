package com.example.java.threadspool.threadspooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author benjamin
 * created at 2019/6/6
 */
public class TreadPoolMain {

    public static void main(String[] args) {

        //        newFixedThreadPool
        // 固定n个线程， 无界的任务队列

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 8; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(Thread.currentThread().hashCode());

//                    System.out.println(Thread.currentThread().getThreadGroup().getName());


                }
            };

            threadPool.execute(task);
        }

        // 记得退出线程池，否则不会退出
        threadPool.shutdown();

    }




}
