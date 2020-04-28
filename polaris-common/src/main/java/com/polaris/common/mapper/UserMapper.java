package com.polaris.common.mapper;

import com.polaris.common.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User queryUser(Map<String, Object> map);
}
