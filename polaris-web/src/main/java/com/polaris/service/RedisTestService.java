package com.polaris.service;

import com.alibaba.fastjson.JSON;
import com.polaris.common.redis.RedisListServiceImpl;
import com.polaris.common.redis.RedisValueServiceImpl;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// 配置Spring中的测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring的配置文件路径
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
@WebAppConfiguration("src/main/resources")//扫描了resources配置文件夹里面的配置，后恢复正常
public class RedisTestService {
    @Resource
    private RedisValueServiceImpl redisValueService;
    @Resource
    private RedisListServiceImpl redisListService;

    /**
     * redis实际连接处理测试
     */
    @Data
    private static class RedisUser implements Serializable {
        private String idCard;
        private String name;
        private Integer age;

        public RedisUser() {

        }

        public RedisUser(String idCard, String name, Integer age) {
            this.idCard = idCard;
            this.name = name;
            this.age = age;
        }
    }

    /**
     * 单机版redis安装测试
     */
    @Test
    public void RedisTest() {
        RedisUser redisUser = new RedisUser("1369", "张三", 18);
        //redisValueService.set(redisUser.getIdCard(), redisUser, 300L, TimeUnit.SECONDS);//缓存30秒
        //redisValueService.hSet("test",redisUser);
        //RedisUser getRedisUser = (RedisUser) redisValueService.get(redisUser.getIdCard());
        //System.out.println("从redis中去除的缓存用户对象打印:" + JSON.toJSONString(getRedisUser));
        for(int i=0;i<50;i++){
            new Thread(()->{
                getMoney("776238");
            });
        }
        System.out.println("当前剩余金额:"+money);
    }
    private int money=100;
    public void getMoney(String orderid){
        try {
            boolean flag = redisValueService.setIfAbsent(orderid, orderid, 10000L, TimeUnit.MILLISECONDS);
            if (flag) {
                money--;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redisValueService.delete(orderid);
        }
    }
    /**
     * solr实际连接处理测试
     */
    @Test
    public void SolrTest() {

    }
}