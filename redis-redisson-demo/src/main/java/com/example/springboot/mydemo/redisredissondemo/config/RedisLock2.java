package com.example.springboot.mydemo.redisredissondemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Random;

@Component
public class RedisLock2 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private DefaultRedisScript<Long> redisScript;

    private static final Long RELEASE_SUCCESS = 1L;

    private Random random = new Random();

    private long DEFAULT_EXPIRATION = 10 * 1000; // 默认超时60s
    private long DEFAULT_WAIT_TIME = 10 * 1000; // 默认超时60s

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
    public boolean lock(@NotNull String key, @NotNull String value, Long expiration) {
        if ((expiration < 0)) {
            expiration = DEFAULT_EXPIRATION;
        }

        while (true) {
            Boolean bool = (Boolean) stringRedisTemplate.execute(getRedisCallback(key, value, expiration));
            //是否成功获取锁
            if (bool != null && bool) {
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

    private RedisCallback getRedisCallback(String key, String value, Long expiration) {
        return connection -> {
            //过期时间 单位：ms
            Expiration expiration2 = Expiration.milliseconds(expiration);
            //执行NX操作
            RedisStringCommands.SetOption setOption = RedisStringCommands.SetOption.ifAbsent();
            //获取锁
            return (boolean) connection.set(key.getBytes(), value.getBytes(), expiration2, setOption);
        };
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
    public boolean tryLock(@NotNull String key, @NotNull String value, Long expiration) {
        if ((expiration < 0)) {
            expiration = DEFAULT_EXPIRATION;
        }
        //执行set命令
        Boolean bool = (Boolean) stringRedisTemplate.execute(getRedisCallback(key, value, expiration));
        if (bool != null && bool) {
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
     *                   -1 表示采用默认的等待时间
     * @return
     */
    public boolean tryLock(@NotNull String key, @NotNull String value, Long expiration, long waitTime) {
        if (waitTime < 0) {
            waitTime = DEFAULT_WAIT_TIME;
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
            Boolean bool = (Boolean) stringRedisTemplate.execute(getRedisCallback(key, value, expiration));
            if (bool != null && bool) {
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

    public boolean unlock(@NotNull String key, @NotNull String value) {
        //使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        Long result = (Long) stringRedisTemplate.execute(redisScript, Arrays.asList(key, value));
        //返回最终结果
        return RELEASE_SUCCESS.equals(result);
    }

    /**
     * @param key
     * @param value
     * @return 当前锁是否存在？
     */
    public boolean checkLockExist(@NotNull String key, @NotNull String value) {
        String temp = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(temp) && value.equalsIgnoreCase(temp)) {
            return true;
        }
        return false;
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
