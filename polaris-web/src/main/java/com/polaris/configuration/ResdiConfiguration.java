package com.polaris.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class ResdiConfiguration {
    @Value("maxTotal")
    private int maxTotal;
    @Value("maxIdle")
    private int maxIdle;
    @Value("minIdle")
    private int minIdle;

    @Bean
    public RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory getConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        //jedisConnectionFactory.setHostName();
        return jedisConnectionFactory;
    }
}
