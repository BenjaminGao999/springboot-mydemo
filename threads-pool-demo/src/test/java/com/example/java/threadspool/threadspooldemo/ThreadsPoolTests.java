package com.example.java.threadspool.threadspooldemo;

import org.junit.Test;

import java.util.concurrent.*;


/**
 * @author benjamin
 * created at 2019/6/6
 */
public class ThreadsPoolTests {

    @Test
    public void threadsPoolSourceCode() {

        /*


                    Executor
                         ExecutorService
                                    ScheduledExecutorService
                                    AbstractExecutorService
                                            ThreadPoolExecutor
                                                ScheduledThreadPoolExecutor

         */


//        Executors

// 不在测试中测试线程池， 因为测试线程抓住机会就退出


//        ThreadFactory



        // threadGroup

        // thread priority

        // daemon 守护

//        BlockingQueue

        // thread执行完毕任务之后，怎么还能活着呢？怎么还能reuse呢？

        // thread lifecycle

        /// thread-pool 单个任务中有异常， 会导致什么？
        /*

        https://medium.com/@aozturk/how-to-handle-uncaught-exceptions-in-java-abf819347906

                task中抛出异常， 会导致执行task的thread死掉
                因为task queue内存在未被消费的tasks
                所以 thread-pool将创建新的线程执行剩下的tasks

         */



    }


}
