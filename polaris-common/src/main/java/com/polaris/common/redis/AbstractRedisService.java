package com.polaris.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public abstract class AbstractRedisService {
    @Resource
    protected RedisTemplate redisTemplate;
}
