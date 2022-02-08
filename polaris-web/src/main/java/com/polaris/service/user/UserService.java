package com.polaris.service.user;

import com.alibaba.fastjson.JSON;
import com.polaris.common.constants.RedisConstant;
import com.polaris.common.entity.User;
import com.polaris.common.mapper.UserMapper;
import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.UserRequest;
import com.polaris.common.redis.RedisValueServiceImpl;
import com.polaris.common.utils.Base64Tool;
import com.polaris.common.wrapper.UserWrapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Logger logger = Logger.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisValueServiceImpl<String, User> redisValueService;

    /**
     * @param userRequest
     */
    public void login(HttpServletResponse response, UserRequest userRequest) throws UnsupportedEncodingException {
        Assert.notNull(userRequest.getUserName(), "用户账号不能为空!");
        Assert.hasLength(userRequest.getPassword(), "用户密码不能为空!");
        logger.info(String.format("请求参数打印-用户名打印:%s,密码打印:%s", userRequest.getUserName(), userRequest.getPassword()));
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userRequest.getUserName());
        map.put("password", userRequest.getPassword());
        User user = userMapper.queryUser(map);
        if (user == null) {
            Assert.notNull(user, "当前用户不存在!");
        }
        //把用户信息放入redis
        redisValueService.set(String.valueOf(user.getId()), user);
        //吧用户信息放入cookie
        String key = Base64Tool.encrypt(String.valueOf(user.getId()));
        Cookie redisCookie = new Cookie(RedisConstant.REDIS_USER_KEY, key);
        response.addCookie(redisCookie);
        Cookie cookie = new Cookie("user", URLEncoder.encode(JSON.toJSONString(user), "UTF-8"));
        cookie.setMaxAge(5 * 365 * 24 * 60 * 60);
        logger.info("cookievalue"+JSON.toJSONString(cookie));
        response.addCookie(cookie);
    }

    public BaseResponse register(UserRequest userRequest) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userRequest.getUserName());
        User user = userMapper.queryUser(map);
        if (user != null) {
            Assert.notNull(user, "用户名已经存在,请更换用户名!");
        }
        user = UserWrapper.getUser(userRequest);
        userMapper.insert(user);
        return BaseResponse.buildSuccessResponse("注册成功!请前往登陆...", "");
    }
}
