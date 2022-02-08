package com.polaris.common.utils;

import com.polaris.common.entity.User;

/**
 * @author jiangguanfeng
 */
public class UserPool {

    public static ThreadLocal<User> userPool = new ThreadLocal();

    private UserPool(){

    }
    public static void setUser(User user) {
        userPool.set(user);
    }

    public static void getUser() {
        userPool.get();
    }

    public static void remove() {
        userPool.remove();
    }
}
