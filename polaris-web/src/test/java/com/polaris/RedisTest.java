package com.polaris;

import com.alibaba.fastjson.JSON;
import com.polaris.common.entity.User;
import com.polaris.common.redis.RedisService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

public class RedisTest extends Test {
    @Resource
    private RedisService redisService;
    private static Integer i = 1;

    /**
     * 分布式锁测试
     */
    @org.junit.Test
    public void distributedLock() {
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

    /**
     * redis通用api测试
     */
    @org.junit.Test
    public void redisTest() {
        User user = new User();
        user.setUserName("1186967953@qq.com");
        user.setPassword("123456");
        user.setMobile("15757857623");
        user.setPhoto("/user/test.jpg");
        user.setQq("1186967953");
        user.setLoginTime(new Date());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        redisService.set("jgf", user);
        User redisUser = redisService.get("jgf");
        System.out.println("获取到valueops:" + JSON.toJSONString(redisUser));

        redisService.hSet("hash", "userName", "张健");
        redisService.hSet("hash", "tel", "15757857623");
        String value = (String) redisService.hGet("hash", "userName");
        System.out.println("获取到hashops:" + JSON.toJSONString(value));

    }
}
