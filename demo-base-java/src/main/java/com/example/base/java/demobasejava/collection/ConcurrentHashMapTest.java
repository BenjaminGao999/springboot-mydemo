package com.example.base.java.demobasejava.collection;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author benjamin
 * created at 2019/11/22
 */
public class ConcurrentHashMapTest {


    /**
     * The next hash code to be given out. Updated atomically. Starts at
     * zero.
     */
    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    /**
     * The difference between successively generated hash codes - turns
     * implicit sequential thread-local IDs into near-optimally spread
     * multiplicative hash values for power-of-two-sized tables.
     */
    private static final int HASH_INCREMENT = 0x61c88647;


    /**
     * Returns the next hash code.
     */
    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.get("abc");
        map.put("abc", "value1");

        int maximumCapacity = 1 << 30; //0000 0000 0000 0000 0000 0000 0000 0001 左移动30位
        // MAXIMUM_CAPACITY >>> 1  0100 0000 0000 0000 0000 0000 0000 0000 无符号向右移动1位
        //                         00100 0000 0000 0000 0000 0000 0000 000

        nextHashCode();

        nextHashCode();
        nextHashCode();


//        int i = nextHashCode();

//        System.out.println(Integer.toBinaryString(16));

        // 1000 0000 0000 0000
        System.out.println(Integer.toBinaryString(1 << 15));

    }

}
