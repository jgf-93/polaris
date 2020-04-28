package com.polaris.service.user;

import com.alibaba.fastjson.JSON;
import com.polaris.common.Constants.RedisConstant;
import com.polaris.common.entity.User;
import com.polaris.common.mapper.UserMapper;
import com.polaris.common.re.request.UserRequest;
import com.polaris.common.redis.RedisSetServiceImpl;
import com.polaris.common.redis.RedisValueServiceImpl;
import com.polaris.common.utils.Base64Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisValueServiceImpl<String, User> redisValueService;

    /**
     * @param userRequest
     */
    public void login(HttpServletRequest request, HttpServletResponse response, UserRequest userRequest) {
        Assert.notNull(userRequest.getUserName(), "用户账号不能为空!");
        Assert.hasLength(userRequest.getPassword(), "用户密码不能为空!");
        User user = userMapper.queryUser(userRequest.getUserName(), userRequest.getPassword());
        if (user == null) {
            Assert.notNull(user, "当前用户不存在!");
        }
        String key = Base64Tool.encrypt(String.valueOf(user.getId()));
        //把用户信息放入redis
        redisValueService.set(key, user);
        //吧用户信息放入cookie
        response.setHeader(RedisConstant.REDIS_USER_KEY, key);
        Cookie cookie = new Cookie("user", JSON.toJSONString(user));
        cookie.setMaxAge(5 * 365 * 24 * 60 * 60);
        response.addCookie(cookie);
    }
}
