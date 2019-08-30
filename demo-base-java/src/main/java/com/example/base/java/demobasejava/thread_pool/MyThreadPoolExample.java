package com.example.base.java.demobasejava.thread_pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author benjamin
 * created at 2019/8/17
 */
public class MyThreadPoolExample {

    //1. 核心参数
    // 2. 拒绝策略
    // 3. corePoolSize, maxPoolSize, keepAliveTime的关系？ 线程何时销毁的？ 如何避免在coreThread和maxThread数量间的线程频繁的创建和销毁？
    // 4. corePoolSize设置多大合适？


    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        // 00000000  00000000  00000000   00011101
//        System.out.println(Integer.toString(COUNT_BITS, 2));
//
//        // 00011111  11111111  11111111   11111111
//        System.out.println(Integer.toString(CAPACITY, 2));
//
//        // 536,870,911
//        System.out.println(CAPACITY);
//
//
//        // 00000000 00000000 000000000 00000000
//        System.out.println(Integer.toString(SHUTDOWN, 2));
//
//        // 00100000 00000000 00000000 00000000
//        System.out.println(Integer.toString(STOP, 2));
//
//        // 01000000 00000000 00000000 00000000
//        System.out.println(Integer.toString(TIDYING, 2));
//
//        // 01100000 00000000 00000000 00000000
//        System.out.println(Integer.toString(TERMINATED, 2));
//
//        // 11100000 00000000 00000000 00000000
//        System.out.println(Integer.toString(RUNNING, 2));
//
//        //  11111111 11111111 11111111 11111111
//        System.out.println(Integer.toBinaryString(-1));

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2, 1000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.CallerRunsPolicy());

        // 初始化所有核心线程
        threadPool.prestartAllCoreThreads();

        // 核心线程可以被回收
        threadPool.allowCoreThreadTimeOut(true);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 4; i++) {
            threadPool.execute(runnable);
        }

        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callback ok ";
            }
        });

        String callback = future.get();// 阻塞在这

        threadPool.shutdown();
    }
}
