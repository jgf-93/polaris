package com.polaris.common.demo.newdesign.singleton;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class EnumSingleton {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.INSTANCE;
        Singleton singleton2=Singleton.INSTANCE;
        System.out.println(singleton1==singleton2);
    }
    enum Singleton{
        INSTANCE
    }
}
