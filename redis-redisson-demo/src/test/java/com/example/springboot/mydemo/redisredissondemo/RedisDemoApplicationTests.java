package com.example.springboot.mydemo.redisredissondemo;

import com.example.springboot.mydemo.redisredissondemo.cache.CacheService;
import com.example.springboot.mydemo.redisredissondemo.config.RedisLock;
import com.example.springboot.mydemo.redisredissondemo.config.RedisLock2;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {
    @Autowired
    RedisLock2 redisLock;

    @Test
    public void contextLoads() throws InterruptedException {
        String keyPrefix = "app:model:";
        String key = keyPrefix + "function:" + "f1";
        String value = UUID.randomUUID().toString();

        boolean b = redisLock.tryLock(key, value, -1L);

        boolean unlock = redisLock.unlock(key, value);

        String value2 = UUID.randomUUID().toString();


        boolean b1 = redisLock.checkLockExist(key, value2);

        System.out.println(b);

        System.out.println(b1);
    }


    @Autowired
    CacheService cacheService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void testCache() {

        stringRedisTemplate.opsForValue()
                .getOperations()
                .delete("test::benjamin");

        String benjamin = "benjamin";
        cacheService.getKey(benjamin, "abc");


        String s = stringRedisTemplate.opsForValue()
                .get("test::benjamin");


        System.out.println(s);

    }

    @Test
    public void evict() {
        stringRedisTemplate.opsForValue()
                .getOperations()
                .delete("test::benjamin");

        String benjamin = "benjamin";
        cacheService.getKey(benjamin, "abc");




        String s = stringRedisTemplate.opsForValue()
                .get("test::benjamin");


        System.out.println(s);

        cacheService.evict(benjamin);

        String s1 = stringRedisTemplate.opsForValue()
                .get("test::benjamin");

        System.out.println(s1);


    }
}
