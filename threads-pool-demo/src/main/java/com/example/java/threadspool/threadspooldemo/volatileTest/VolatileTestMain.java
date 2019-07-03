package com.example.java.threadspool.threadspooldemo.volatileTest;

/**
 * @author benjamin
 * created at 2019/7/1
 */
public class VolatileTestMain {

    public static void main(String[] args) throws InterruptedException {


        A a = new A();

        Runnable ra = () -> {

            for (int i = 0; i < 100000; i++) {
                a.count++; //复合（多个）volatile 变量的读 / 写
//                a.add();
            }
        };


        Runnable rb = () -> {
            for (int i = 0; i < 100000; i++) {
                a.count--; // 复合（多个）volatile 变量的读 / 写

//                a.sub();
            }
        };


        Thread ta = new Thread(rb);
        ta.start();
        Thread tb = new Thread(ra);
        tb.start();

        ta.join();
        tb.join();

        System.out.println(a.count);

    }

    static class A {

        // volatile保证了内存可见性，保证任何时刻，所有线程看到的共享变量都是一样的
        volatile int count = -1;

        public synchronized void add() {
            count++;
        }

        public synchronized void sub() {
            count--;
        }
    }
}
