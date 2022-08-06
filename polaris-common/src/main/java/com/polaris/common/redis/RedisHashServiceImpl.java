package com.polaris.common.redis;

import org.springframework.stereotype.Component;

@Component
public class RedisHashServiceImpl<K, V, D> extends AbstractRedisService {
    public void hSet(K k, V v, D d) {
        redisTemplate.opsForHash().put(k, v, d);
    }

    public D hGet(K k, V v) {
        return (D) redisTemplate.opsForHash().get(k, v);
    }

    public void delete(K k) {
        redisTemplate.opsForHash().delete(k, null);
    }
}
