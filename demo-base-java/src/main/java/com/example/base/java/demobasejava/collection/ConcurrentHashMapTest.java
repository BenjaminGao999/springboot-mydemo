package com.example.base.java.demobasejava.collection;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author benjamin
 * created at 2019/11/22
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.get("abc");
        map.put("abc", "value1");

        int maximumCapacity = 1 << 30; //0000 0000 0000 0000 0000 0000 0000 0001 左移动30位
        // MAXIMUM_CAPACITY >>> 1  0100 0000 0000 0000 0000 0000 0000 0000 无符号向右移动1位
        //                         00100 0000 0000 0000 0000 0000 0000 000



//        System.gc();
    }
}
