package com.example.base.java.demobasejava.parallelism;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @author benjamin
 * created at 2019/10/17
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newCachedThreadPool();

        // coreSize 16 任务队列最长64, 当超出64， 创建新的线程，非核心线程最长存活60s， 决绝策略设置为 用main线程执行被拒绝的任务
        // 降低了系统资源分配和避免OOM异常，并行调用外部多个接口， 降低了调用时间

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(16, 32, 60,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<>(64), new ThreadPoolExecutor.CallerRunsPolicy());

        LinkedList<Future<String>> futures = new LinkedList<>();

        for (int i = 0; i < 300; i++) {
            int finalI = i;
            Future<String> future = executor.submit(() -> {
                Thread.sleep(200);
                return Thread.currentThread().getName();
            });
            futures.add(future);
        }

        futures.forEach(f -> {
            try {
                if ("main".equalsIgnoreCase(f.get())) {
                    System.out.println(f.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();

    }
}
