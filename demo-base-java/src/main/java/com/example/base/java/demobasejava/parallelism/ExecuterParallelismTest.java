package com.example.base.java.demobasejava.parallelism;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author benjamin
 * created at 2019/10/12
 */
public class ExecuterParallelismTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(8);

        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "s1";
            }
        };


        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "s2";
            }
        };

        Callable<String> task3 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "s3";
            }
        };


        LinkedList<Callable<String>> tasks = new LinkedList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        List<Future<String>> futures = service.invokeAll(tasks);

        futures.stream().forEach(new Consumer<Future<String>>() {
            @Override
            public void accept(Future<String> stringFuture) {

                try {
                    System.out.println(stringFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        service.shutdown();


    }
}
