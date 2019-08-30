package com.example.base.java.demobasejava.collection;

import java.util.HashMap;

/**
 * @author benjamin
 * created at 2019/7/4
 */
public class HashMapTestMain {

    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("key", "value");

        System.out.println(map.hashCode() >>> 16);// bit位上的高16位

        System.out.println(5 % 2);
    }
}
