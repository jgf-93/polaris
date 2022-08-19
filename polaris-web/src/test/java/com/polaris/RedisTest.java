package com.polaris;

import com.polaris.common.redis.RedisService;

import javax.annotation.Resource;
import java.util.UUID;

public class RedisTest extends Test {
    @Resource
    private RedisService redisService;
    private static Integer i = 1;

    @org.junit.Test
    public void demo1(Double money) throws InterruptedException {
        String key = "test:key";
        String value = UUID.randomUUID().toString();
        try {
            //redis尝试获取锁，加锁
            Boolean getLock = this.redisService.getLock(key, value);
            if (getLock) {
                System.out.println(Thread.currentThread().getName() + ",成功获取" + key + "锁");
                //业务开始
                i++;
                //业务结束
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            redisService.releaseLock(key, value);
            System.out.println(Thread.currentThread().getName() + "释放" + key + "锁");
        }
    }
}
