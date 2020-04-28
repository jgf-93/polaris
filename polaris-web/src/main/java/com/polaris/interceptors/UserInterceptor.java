package com.polaris.interceptors;

import com.polaris.common.Constants.RedisConstant;
import com.polaris.common.entity.User;
import com.polaris.common.exception.ServiceException;
import com.polaris.common.exception.UserExpireException;
import com.polaris.common.redis.RedisValueServiceImpl;
import com.polaris.common.utils.Base64Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
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
        String key = httpServletRequest.getHeader(RedisConstant.REDIS_USER_KEY);
        if (StringUtils.isEmpty(key)) {
            throw new ServiceException("当前用户未登录,请前去登陆!");
        }
        User user = redisValueService.get(Base64Tool.decrypt(key));
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
