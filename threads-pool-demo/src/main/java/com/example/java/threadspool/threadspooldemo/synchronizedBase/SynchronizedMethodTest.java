package com.example.java.threadspool.threadspooldemo.synchronizedBase;

/**
 * @author benjamin
 * created at 2019/7/3
 */
public class SynchronizedMethodTest {

    // per object only one monitor


    public synchronized void methodA() {
        System.out.println("method a");

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {

        System.out.println("method b");

    }


    public synchronized void methodC() {

        System.out.println("method c");

        methodD();

    }

    public synchronized void methodD() {
        System.out.println("method d");
    }
}
