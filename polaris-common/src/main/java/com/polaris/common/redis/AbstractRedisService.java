package com.polaris.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class AbstractRedisService<K, V> {
    @Resource
    protected RedisTemplate redisTemplate;

    public void set(K k, V v) {
        redisTemplate.opsForValue().set(k, v);
    }

    public void set(K k, V v, Long time, TimeUnit unit) {
        redisTemplate.opsForValue().set(k, v, time, unit);
    }

    public V get(K k) {
        return (V) redisTemplate.opsForValue().get(k);
    }

    public void delete(K k) {
        redisTemplate.opsForValue().set(k, null);
    }
}
