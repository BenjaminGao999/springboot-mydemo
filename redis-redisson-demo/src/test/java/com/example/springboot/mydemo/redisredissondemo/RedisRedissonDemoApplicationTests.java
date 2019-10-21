package com.example.springboot.mydemo.redisredissondemo;

import com.example.springboot.mydemo.redisredissondemo.config.RedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRedissonDemoApplicationTests {
    @Autowired
    RedisLock redisLock;

    @Test
    public void contextLoads() throws InterruptedException {
        String keyPrefix = "app:model:";
        String key = keyPrefix + "function:" + "f1";
        String value = UUID.randomUUID().toString();

        boolean lock = redisLock.tryLock(key, value, -1L);
        System.out.println(lock);
        redisLock.unlock(key,value);

//        boolean lock1 = redisLock.lock(key, value, -1L);
//        System.out.println(lock1);

        boolean lock1 = redisLock.tryLock(key, value, -1L, 1000L);
        System.out.println(lock1);
    }





}
