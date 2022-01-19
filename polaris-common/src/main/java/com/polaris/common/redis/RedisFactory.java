package com.polaris.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisFactory {
    @Autowired
    private RedisValueServiceImpl redisValueService;
    @Autowired
    private RedisListServiceImpl redisListService;
    @Autowired
    private RedisSetServiceImpl redisSetService;

    public enum RedisTypeEnum {
        REDIS_VALUE,
        REDIS_LIST,
        REDIS_SET;
    }

    public AbstractRedisService getRedis(RedisTypeEnum redisTypeEnum) {
        switch (redisTypeEnum) {
            case REDIS_VALUE:
                return redisValueService;
            case REDIS_LIST:
                return redisListService;
            case REDIS_SET:
                return redisSetService;
        }
        return redisValueService;
    }
}
