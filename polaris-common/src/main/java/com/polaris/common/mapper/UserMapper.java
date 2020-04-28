package com.polaris.common.mapper;

import com.polaris.common.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User queryUser(String userName, String password);
}
