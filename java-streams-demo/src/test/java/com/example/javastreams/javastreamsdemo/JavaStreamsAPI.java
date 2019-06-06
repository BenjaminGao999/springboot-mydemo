package com.example.javastreams.javastreamsdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author benjamin
 * created at 2019/6/5
 */
public class JavaStreamsAPI {

    @Test
    public void createStreams() {

      /*  Stream<Integer> stream = Stream.of(1, 2, 3);

        stream.forEach(integer -> {
            System.out.println(integer);
        });*/

       /* Stream<Integer> stream = Stream.of(new Integer[]{1, 2, 3});
        stream.forEach(p->{
            System.out.println(p);
        });*/
/*
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();

        stream.forEach(p-> System.out.println(p));*/

        Stream<Date> stream = Stream.generate(() -> new Date());
        stream.forEach(p -> System.out.println(p));
    }
}
