package com.example.springboot.mybatis.mybatisdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author benjamin
 * created at 2019/6/27
 */
public class QueueTest {

    @Test
    public void test() {

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("s");
        linkedList.offer("p");

//        String poll = linkedList.poll();
//        System.out.println(poll);

//        String remove = linkedList.remove();
//        System.out.println(remove);

       /* linkedList.poll();
        linkedList.poll();
        null
        linkedList.poll();*/

       /*linkedList.remove();
       linkedList.remove();
       java.util.NoSuchElementException
       linkedList.remove();*/

        /*String element = linkedList.element();
        NoSuchElementException
        System.out.println(element);

        String peek = linkedList.peek();
        null
        System.out.println(peek);*/

        /*String peekLast = linkedList.peekLast();
        System.out.println(peekLast);*/

        System.out.println(Arrays.toString(linkedList.toArray()));


        // 不过是一层互斥锁的包装而已
        List<String> synchronizedList = Collections.synchronizedList(new LinkedList<String>());

        // 根据index获取元素至少要遍历半个list
        String index_1 = linkedList.get(1);
        System.out.println(index_1);

//        int[][] ints = new int[1][2];


    }




}
