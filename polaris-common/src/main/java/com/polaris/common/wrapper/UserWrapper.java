package com.polaris.common.wrapper;

import com.polaris.common.entity.User;
import com.polaris.common.re.request.UserRequest;

import java.util.Date;

public class UserWrapper {

    public static User getUser(UserRequest userRequest) {
        User user = new User();
        user.setMobile(userRequest.getMobile());
        user.setPassword(userRequest.getPassword());
        user.setId(userRequest.getId());
        user.setPhoto(userRequest.getPhoto());
        user.setQq(userRequest.getQq());
        user.setUserName(userRequest.getUserName());
        user.setCreated(new Date());
        user.setModified(new Date());
        return user;
    }
}
