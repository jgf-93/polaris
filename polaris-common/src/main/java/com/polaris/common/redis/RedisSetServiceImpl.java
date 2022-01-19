package com.polaris.common.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisSetServiceImpl<K, V> extends AbstractRedisService {
    public void add(K k, V v) {
        redisTemplate.opsForSet().add(k, v);
    }

    public void remove(K k, V v) {
        redisTemplate.opsForSet().remove(k, v);
    }
}
