package com.polaris.interceptors;

import com.alibaba.fastjson.JSON;
import com.polaris.common.constants.RedisConstant;
import com.polaris.common.entity.User;
import com.polaris.common.exception.ServiceException;
import com.polaris.common.exception.UserExpireException;
import com.polaris.common.redis.RedisValueServiceImpl;
import com.polaris.common.utils.Base64Tool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

public class UserInterceptor implements HandlerInterceptor {
    private Logger logger = Logger.getLogger(UserInterceptor.class);
    @Autowired
    private RedisValueServiceImpl<String, User> redisValueService;

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
        Cookie[] cookies = httpServletRequest.getCookies();
        Cookie cookie = Stream.of(cookies).filter(c -> RedisConstant.REDIS_USER_KEY.equals(c.getName())).findFirst().orElse(null);
        if (cookie == null) {
            throw new ServiceException("当前用户未登录,请前去登陆!");
        }
        User user = redisValueService.get(Base64Tool.decrypt(cookie.getValue()));
        logger.info("从redis获取到用户信息:" + JSON.toJSONString(user));
        if (user == null) {
            throw new UserExpireException("用户会话过期,请重新登陆!");
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
