package com.example.base.java.demobasejava.parallelism;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

/**
 * @author benjamin
 * created at 2019/10/12
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {


                return null;
            }
        });





    }
}
