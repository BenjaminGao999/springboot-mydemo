package com.example.java.threadspool.threadspooldemo.synchronizedBase;

/**
 * @author benjamin
 * created at 2019/7/3
 */
public class MainTest {

    public static void main(String[] args) {
//        SynchronizedMethodTest methodTest = new SynchronizedMethodTest();
//        Runnable r1 = () -> {
//            methodTest.methodA();
//        };
//        Runnable r2 = () -> {
//            methodTest.methodB();
//        };
//
//        new Thread(r1).start();
//        new Thread(r2).start();


        SynchronizedMethodTest methodTest = new SynchronizedMethodTest();

        methodTest.methodC();


    }
}
