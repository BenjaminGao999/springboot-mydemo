package com.example.java.threadspool.threadspooldemo.whatisthread;

/**
 * @author benjamin
 * created at 2019/7/1
 */
public class ThreadYield {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" t doing something");
        });
        t.start();

        // A hint to the scheduler that the current thread is willing to yield its current use of a processor.
        // The scheduler is free to ignore this hint.
        Thread.yield();

        System.out.println("main doing something");


    }
}
