package com.polaris.controller;

import com.polaris.common.constants.RedisConstant;
import com.polaris.common.entity.User;
import com.polaris.common.exception.UserExpireException;
import com.polaris.common.redis.RedisValueServiceImpl;
import com.polaris.common.utils.Base64Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {

    @Autowired
    private RedisValueServiceImpl<String, User> redisValueService;

    private ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal();

    private ThreadLocal<HttpServletResponse> responeThreadLocal = new ThreadLocal();

    protected User getUser() {
        HttpServletRequest request = requestThreadLocal.get();
        User user = redisValueService.get(Base64Tool.decrypt(request.getHeader(RedisConstant.REDIS_USER_KEY)));
        if (user == null) {
            throw new UserExpireException("用户信息不存在!");
        }
        return user;
    }

    protected HttpServletRequest getRequest() {
        return requestThreadLocal.get();
    }

    @ModelAttribute
    protected void setRequestThreadLocal(HttpServletRequest httpServletRequest) {
        requestThreadLocal.set(httpServletRequest);
    }

    protected HttpServletResponse getResponse() {
        return responeThreadLocal.get();
    }

    @ModelAttribute
    protected void setResponeThreadLocal(HttpServletResponse response) {
        responeThreadLocal.set(response);
    }
}
