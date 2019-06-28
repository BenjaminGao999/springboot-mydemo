package com.example.springboot.mybatis.mybatisdemo.maintest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author benjamin
 * created at 2019/6/27
 */
public class BlockingQueueMain {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool =
                Executors.newFixedThreadPool(8);


        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

        Runnable takeS = () -> {
            System.out.println("take s ");
            String take = null;
            try {
                take = linkedBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(take);
        };


        Runnable putS = () -> {
            System.out.println("put s  ");
            try {
                Thread.sleep(3000);
                linkedBlockingQueue.put("s");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        threadPool.execute(takeS);

        threadPool.execute(putS);

        threadPool.shutdown();

    }
}
