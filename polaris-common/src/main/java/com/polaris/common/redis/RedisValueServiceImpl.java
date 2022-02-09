package com.polaris.common.redis;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisValueServiceImpl<K, V> extends AbstractRedisService {
    public void set(K k, V v) {
        redisTemplate.opsForValue().set(k, v);
    }
    public void hSet(K k,V v){
        redisTemplate.opsForHash().hasKey(k,v);
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

    public void inc(K k, Long data) {
        redisTemplate.opsForValue().increment(k, data);
    }
}
