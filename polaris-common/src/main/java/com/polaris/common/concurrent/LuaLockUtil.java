package com.polaris.common.concurrent;

import com.polaris.common.redis.RedisService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class LuaLockUtil {
    @Resource
    private RedisService redisService;

    public void luaLock(String key, String value, Long time, TimeUnit timeUnit) {
        redisService.setIfAbsent(key, value, time, timeUnit);
    }

}
