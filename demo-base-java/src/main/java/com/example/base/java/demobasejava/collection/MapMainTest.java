package com.example.base.java.demobasejava.collection;

import java.util.HashMap;

import java.util.LinkedHashMap;

/**
 * @author benjamin
 * created at 2019/7/9
 */
public class MapMainTest {

    /*

        HashMap 和 LinkedHashMap 数据结构上的区别？


    LinkedHashMap基于HashMap的数据接口和entry, 但是 LinkedHashMap对entry进行了扩展， 新增了before,after用来记录插入顺序。
      entry多加了连个节点 before, after
      head, tail作为field
      通过head和tail，以及每个节点的 before和 after可以记录插入顺序。


       LinkedHashMap新增的内存可以忽略不计， 但是增加了时间复杂度。

     */
}
