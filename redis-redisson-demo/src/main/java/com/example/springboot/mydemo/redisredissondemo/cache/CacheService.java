package com.example.springboot.mydemo.redisredissondemo.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

/**
 * @author benjamin
 * created at 2019/10/25
 */
@Service
@EnableCaching
public class CacheService {

    @Cacheable(cacheNames = "test", key = "#key")
    public String getKey(String key, String v) {
        return v;
    }

    @CacheEvict(cacheNames = "test", key = "#key")
    public void evict(String key) {
        System.out.println("delete");
    }

}
