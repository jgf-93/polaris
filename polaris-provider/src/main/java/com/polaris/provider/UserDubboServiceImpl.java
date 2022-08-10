package com.polaris.provider;

import com.google.common.collect.Maps;
import com.polaris.client.UserDubboService;
import com.polaris.client.dto.UserDto;
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
        Map<String,Object> searchMap= Maps.newHashMap();
        searchMap.put("id",1);
        userMapper.queryUser(searchMap);
        return null;
    }
}
