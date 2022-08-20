package com.polaris.interceptors;

import com.alibaba.fastjson.JSON;
import com.polaris.common.constants.RedisConstant;
import com.polaris.common.entity.User;
import com.polaris.common.exception.ServiceException;
import com.polaris.common.exception.UserExpireException;
import com.polaris.common.redis.RedisService;
import com.polaris.common.utils.UserPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
    private List<String> noAuthUrlList = Arrays.asList("/test");
    @Autowired
    private RedisService redisService;

    /**
     * 检查用户缓存
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //httpServletRequest.get
        logger.info("当前请求进入了拦截器:" + httpServletRequest.getRequestURL());
        String requestUrl = httpServletRequest.getRequestURI();
        //测试请求不校验token
        if (noAuthUrlList.stream().anyMatch(n -> requestUrl.contains(n))) {
            return true;
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            throw new ServiceException("当前用户未登录,请前去登陆!");
        }
        Cookie cookie = Stream.of(cookies).filter(c -> RedisConstant.REDIS_USER_KEY.equals(c.getName())).findFirst().orElse(null);
        if (cookie == null) {
            throw new ServiceException("当前用户未登录,请前去登陆!");
        }
        User user = redisService.get(cookie.getValue());
        logger.info("从redis获取到用户信息:" + JSON.toJSONString(user));
        if (user == null) {
            throw new UserExpireException("用户会话过期,请重新登陆!");
        }
        UserPool.setUser(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        UserPool.remove();
    }
}
