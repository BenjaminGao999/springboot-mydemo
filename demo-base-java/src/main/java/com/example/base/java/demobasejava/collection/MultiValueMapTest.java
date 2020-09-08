package com.example.base.java.demobasejava.collection;


import org.apache.commons.collections.map.MultiValueMap;

import java.util.List;

/**
 * @author benjamin
 * created at 2020-09-08
 */
public class MultiValueMapTest {

    public static void main(String[] args) {

        MultiValueMap map = new MultiValueMap();

        map.put("a","a1");
        map.put(null,"a2");

        for (Object key : map.keySet()) {
            List<String> list = (List<String>) map.get((String) key);

            for (String val : list) {
                System.out.println(val);
            }
        }
    }
}
