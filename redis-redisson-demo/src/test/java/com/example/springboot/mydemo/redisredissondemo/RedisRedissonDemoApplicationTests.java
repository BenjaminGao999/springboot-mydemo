package com.example.springboot.mydemo.redisredissondemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRedissonDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void lockTest() {
        RLock rLock = redissonClient.getFairLock(Constant.LOCK_KEY);
        try {
            if (rLock != null && rLock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("get lock");

//                    Thread.sleep(1000 * 30);

//                    throw new RuntimeException("custom exception");

                } finally {

                    rLock.unlock();
                    System.out.println("unlock");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listTest() {
        RList<Object> list = redissonClient.getList(Constant.LIST_KEY);
        if (list != null) {

            boolean add = list.add("a");

            System.out.println(add);
        }
    }

    @Test
    public void listRangeTest() {
        RList<String> list = redissonClient.getList(Constant.LIST_KEY);
        if (list != null) {
            List<String> objects = list.readAll();
            System.out.println(objects);
        }

    }
}
