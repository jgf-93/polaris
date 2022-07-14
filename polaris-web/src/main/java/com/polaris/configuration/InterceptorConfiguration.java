package com.polaris.configuration;

import com.polaris.interceptors.RedisIdempotentInterceptor;
import com.polaris.interceptors.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RedisIdempotentInterceptor());
        registry.addInterceptor(new UserInterceptor());
    }
}