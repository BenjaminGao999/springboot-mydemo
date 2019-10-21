package com.example.springboot.mydemo.redisredissondemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {
    @Autowired
    private StringRedisTemplate template;
    private DefaultRedisScript<Long> redisScript;

    private static final Long RELEASE_SUCCESS = 1L;

    private Random random = new Random();

    private long DEFAULT_EXPIRATION = 10 * 1000; // 默认超时60s

    {
        redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptText("if redis.call('get', KEYS[1]) == KEYS[2] then return redis.call('del', KEYS[1]) else return 0 end");

    }

    /**
     * 阻塞锁
     *
     * @param key
     * @param value
     * @param expiration 锁的过期时间/ms
     *                   -1 表示采用默认过期时间
     * @return
     */
    public boolean lock(String key, String value, Long expiration) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("key或者value不能为空");
        }

        if ((expiration < 0)) {
            expiration = DEFAULT_EXPIRATION;
        }

        while (true) {
            //执行set命令
            Boolean absent = template.opsForValue().setIfAbsent(key, value, expiration, TimeUnit.MILLISECONDS);

            //是否成功获取锁
            if (absent != null && absent) {
                return true;
            } else {
                try {
                    Thread.sleep(getRandomMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 非阻塞锁
     *
     * @param key
     * @param value
     * @param expiration 锁的过期时间/ms
     *                   -1 表示采用默认过期时间
     * @return
     */
    public boolean tryLock(String key, String value, Long expiration) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("key或者value不能为空");
        }

        if ((expiration < 0)) {
            expiration = DEFAULT_EXPIRATION;
        }
        //执行set命令
        Boolean absent = template.opsForValue().setIfAbsent(key, value, expiration, TimeUnit.MILLISECONDS);
        if (absent != null && absent) {

            return true;
        }
        return false;
    }


    /**
     * 超时阻塞锁
     *
     * @param key
     * @param value
     * @param expiration 锁的过期时间/ms
     *                   -1 表示采用默认过期时间
     * @param waitTime   获取锁的超时时间/ms
     * @return
     */
    public boolean tryLock(String key, String value, Long expiration, long waitTime) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value) || waitTime < 1) {
            throw new IllegalArgumentException("key或者value不能为空, 且waitTime必须大于1");
        }


        long start = System.currentTimeMillis();
        while (true) {
            //检测是否超时
            if (System.currentTimeMillis() - start > waitTime) {
                return false;
            }
            if ((expiration < 0)) {
                expiration = DEFAULT_EXPIRATION;
            }
            //执行set命令
            Boolean absent = template.opsForValue().setIfAbsent(key, value, expiration, TimeUnit.MILLISECONDS);

            //是否成功获取锁
            if (absent != null && absent) {
                return true;
            } else {
                try {
                    Thread.sleep(getRandomMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public boolean unlock(String key, String value) {
        //使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        Long result = (Long) template.execute(redisScript, Arrays.asList(key, value));
        //返回最终结果
        return RELEASE_SUCCESS.equals(result);
    }

    /**
     * @return basic+随机值
     */
    private int getRandomMillis() {
        int bound = 100;
        int basic = 200;
        return random.nextInt(bound) + basic;
    }

}
