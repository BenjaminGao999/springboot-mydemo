package com.example.java.threadspool.threadspooldemo.whatisthread;

/**
 * @author benjamin
 * created at 2019/7/1
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" t doing something");
        });
        t.start();

        // main thread waiting for t thread to die or terminate
        //Waits for this thread to die
//        t.join();

        t.join(500);

        System.out.println("main doing something");

    }
}
