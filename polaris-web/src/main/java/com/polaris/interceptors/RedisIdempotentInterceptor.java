package com.polaris.interceptors;

import com.polaris.common.annotations.RedisIdempotent;
import com.polaris.common.redis.RedisValueServiceImpl;
import com.polaris.common.redis.TokenService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class RedisIdempotentInterceptor implements HandlerInterceptor {
    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //解析幂等方法
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        RedisIdempotent redisIdempotent = method.getAnnotation(RedisIdempotent.class);
        if (redisIdempotent != null) {
            //如果校验失败就提示异常
            tokenService.checkToken(httpServletRequest);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
