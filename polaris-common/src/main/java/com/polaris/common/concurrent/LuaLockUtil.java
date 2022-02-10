package com.polaris.common.concurrent;

import com.polaris.common.redis.RedisValueServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class LuaLockUtil {
    @Resource
    private RedisValueServiceImpl redisValueService;

    public void luaLock(String key, String value, Long time, TimeUnit timeUnit){
        redisValueService.setIfAbsent(key,value,time,timeUnit);
    }

}
