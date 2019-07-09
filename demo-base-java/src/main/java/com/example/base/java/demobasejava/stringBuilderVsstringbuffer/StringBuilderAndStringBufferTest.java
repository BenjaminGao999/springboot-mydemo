package com.example.base.java.demobasejava.stringBuilderVsstringbuffer;

/**
 * @author benjamin
 * created at 2019/7/3
 */
public class StringBuilderAndStringBufferTest {

    public static void main(String[] args) {


        new StringBuilder();
        // char[]
        // char[] 不支持多线程同步

        //char[] value;
        // 支持多线程同步操作。因为每个方法是synchronized方法， 因此如果不存在多线程， 用stringBuilder执行效率更高
        new StringBuffer();
    }
}
