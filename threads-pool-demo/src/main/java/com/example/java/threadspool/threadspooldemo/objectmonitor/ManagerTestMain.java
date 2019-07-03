package com.example.java.threadspool.threadspooldemo.objectmonitor;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author benjamin
 * created at 2019/7/1
 */
public class ManagerTestMain {

    public static void main(String[] args) {

        ManagerImpl manager = new ManagerImpl(new LinkedList<>());

        ExecutorService threadPool =
                Executors.newFixedThreadPool(3);

        Runnable producer = () -> {
            while (true) {
                manager.produce();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Runnable consumer = () -> {
            while (true) {
                manager.consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        threadPool.execute(producer);

        threadPool.execute(consumer);
        threadPool.execute(consumer);

        threadPool.shutdown();
    }
}
