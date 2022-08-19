package com.polaris.common.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {
    @Resource
    protected RedisTemplate redisTemplate;

    //--------------------redisString------------------------------------
    public <K, V> void set(K k, V v) {
        redisTemplate.opsForValue().set(k, v);
    }

    public <K, V> void set(K k, V v, Long time, TimeUnit unit) {
        redisTemplate.opsForValue().set(k, v, time, unit);
    }

    public <K, V> V get(K k) {
        return (V) redisTemplate.opsForValue().get(k);
    }

    public <K> void delete(K k) {
        redisTemplate.opsForValue().set(k, null);
    }

    public <K> void inc(K k, Long data) {
        redisTemplate.opsForValue().increment(k, data);
    }

    public boolean setIfAbsent(String key, String value, Long time, TimeUnit timeUnit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, time, timeUnit);
    }

    public void releaseLock(String key) {
        redisTemplate.delete(key);
    }

    //--------------------redisHash------------------------------------
    public <K, HK, HV> void hSet(K k, HK hk, HV hv) {
        redisTemplate.opsForHash().put(k, hk, hv);
    }

    public <K, HK, HV> HV hGet(K k, HK hk) {
        return (HV) redisTemplate.opsForHash().get(k, hk);
    }

    //--------------------redisList------------------------------------
    public <K, V> void leftPush(K k, V v) {
        redisTemplate.opsForList().leftPush(k, v);
    }

    public <K, V> void rightPush(K k, V v) {
        redisTemplate.opsForList().rightPush(k, v);
    }

    public <K> void leftPop(K k, Long time, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(k, time, unit);
    }


    public <K> void rightPop(K k, Long time, TimeUnit unit) {
        redisTemplate.opsForList().rightPop(k, time, unit);
    }

    public <K, V> void remove(K k, Long count, V v) {
        redisTemplate.opsForList().remove(k, count, v);
    }

    //--------------------redisSet------------------------------------
    public <K, V> void add(K k, V v) {
        redisTemplate.opsForSet().add(k, v);
    }

    public <K, V> void remove(K k, V v) {
        redisTemplate.opsForSet().remove(k, v);
    }
}
