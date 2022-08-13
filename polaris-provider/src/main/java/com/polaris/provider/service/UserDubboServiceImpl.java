package com.polaris.provider.service;

import com.google.common.collect.Maps;
import com.polaris.client.UserDubboService;
import com.polaris.client.dto.UserDto;
import com.polaris.common.entity.User;
import com.polaris.common.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
@Service//暴露服务
@Component
public class UserDubboServiceImpl implements UserDubboService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto getUser() {
        Map<String, Object> searchMap = Maps.newHashMap();
        searchMap.put("userName", "1186967953@qq.com");
        searchMap.put("password","123456");
        User user = userMapper.queryUser(searchMap);
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPhoto(user.getPhoto());
        return userDto;
    }
}
