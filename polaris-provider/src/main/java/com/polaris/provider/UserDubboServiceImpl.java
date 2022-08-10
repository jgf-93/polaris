package com.polaris.provider;

import com.google.common.collect.Maps;
import com.polaris.client.UserDubboService;
import com.polaris.client.dto.UserDto;
import com.polaris.common.entity.User;
import com.polaris.common.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class UserDubboServiceImpl implements UserDubboService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto getUser() {
        Map<String, Object> searchMap = Maps.newHashMap();
        searchMap.put("id", 1);
        User user = userMapper.queryUser(searchMap);
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPhoto(user.getPhoto());
        return userDto;
    }
}
