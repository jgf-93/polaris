package com.polaris.common.demo.ThreadLocal;

import lombok.Data;


/**
 * 每个线程需要有自己单独的实例
 * 实例需要在多个方法中共享，但不希望被多线程共享
 */
public class ThreadLocalDemo {
    static ThreadLocal<User> userCache = new ThreadLocal<User>();

    public static void main(String[] args) {
        User user = new User();
        user.setAge(1);
        user.setName("小红");
        userCache.set(user);
        new Thread(new Runnable() {
            @Override
            public void run() {
                User threadUser = new User();
                threadUser.setName("奇强");
                threadUser.setAge(15);
                userCache.set(threadUser);
                System.out.println(userCache.get());
            }
        }).start();
        System.out.println(userCache.get());
    }

    @Data
    static class User {
        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
