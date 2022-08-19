package com.polaris.common.redis;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class RedisListService<K, V> extends AbstractRedisService {
    public void leftPop(K k) {
        redisTemplate.opsForList().leftPop(k);
    }

    public void leftPop(K k, Long time, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(k, time, unit);
    }

    public void rightPop(K k) {
        redisTemplate.opsForList().rightPop(k);
    }

    public void rightPop(K k, Long time, TimeUnit unit) {
        redisTemplate.opsForList().rightPop(k, time, unit);
    }

    public void remove(K k, Long count, V v) {
        redisTemplate.opsForList().remove(k, count, v);
    }
}
