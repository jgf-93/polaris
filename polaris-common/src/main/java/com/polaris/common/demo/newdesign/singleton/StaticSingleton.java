package com.polaris.common.demo.newdesign.singleton;

/**
 * 静态内部类实现懒汉单例模式
 * 类加载线程安全
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    private static class StaticSingletonInstance {
        private static StaticSingleton staticSingleton =new StaticSingleton();
    }

    public static StaticSingleton getStaticSingleton() {
        return StaticSingletonInstance.staticSingleton;
    }

    public static void main(String[] args) {
        StaticSingleton staticSingleton1=StaticSingleton.getStaticSingleton();
        StaticSingleton staticSingleton2=StaticSingleton.getStaticSingleton();
        System.out.println(staticSingleton1==staticSingleton2);
    }
}
