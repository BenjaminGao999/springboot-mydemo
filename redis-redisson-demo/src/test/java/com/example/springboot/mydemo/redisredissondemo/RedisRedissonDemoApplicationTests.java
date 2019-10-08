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
    public void contextLoads() {
        String keyPrefix = "appname:modulename:";
        String key = keyPrefix + "articleId:" + "customerId";
        String value = UUID.randomUUID().toString();
        redisLock.setTimeout(3000);
        boolean lock = redisLock.lock(key, value);

//        System.out.println(lock);


        boolean unlock = redisLock.unlock(key, value);

        System.out.println(unlock);
    }
}
