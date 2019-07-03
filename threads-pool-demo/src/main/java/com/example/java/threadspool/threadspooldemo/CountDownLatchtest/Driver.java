package com.example.java.threadspool.threadspooldemo.CountDownLatchtest;

import java.util.concurrent.CountDownLatch;

/**
 * @author benjamin
 * created at 2019/7/3
 */
class Driver {
    private static final int N = 6; // ...

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish // 阻塞，直到 countdown 到0
        doSomethingElse();

    }

    private static void doSomethingElse() {
        System.out.println("do something else");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await(); // 阻塞， 直到 countdown 到0

            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        } // return;
    }

    void doWork() {
        System.out.println("do work");
    }
}



