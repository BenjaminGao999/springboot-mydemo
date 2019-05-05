package com.example.springbootmydemo;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author benjamin
 * created at 2019/4/29
 */
public class TestDemo {

    /**
     * 2019-04-19 00:21:27
     * 2019-04-29 18:37:04.833
     */
    @Test
    public void test() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);
    }

    @Test
    public void utf8Compare() {
        String utf8 = "\u9004\u4ec1\u79c0";
        System.out.println(utf8);

        System.out.println("逄仁秀".equalsIgnoreCase(utf8));
    }
}
