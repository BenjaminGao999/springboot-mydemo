package com.example.base.java.demobasejava.spring.split;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author benjamin
 * created at 2020-09-02
 */
public class SpringSplitTest {


    @Test
    public void strSplit(){

        String str = ";20;30;";

        String[] split = str.split(";");

        System.out.println(split.length);
        System.out.println(Arrays.toString(split));

        List<String> list = Arrays.asList(split);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
