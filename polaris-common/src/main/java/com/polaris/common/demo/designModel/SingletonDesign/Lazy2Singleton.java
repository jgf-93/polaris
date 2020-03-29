package com.polaris.common.demo.designModel.SingletonDesign;

/**
 * 懒汉模式2
 * 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，
 * 但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 */
public class Lazy2Singleton {

    private Lazy2Singleton lazy2Singleton;

    private Lazy2Singleton() {

    }

    public synchronized Lazy2Singleton getLazy2Singleton() {
        if (lazy2Singleton == null) {
            lazy2Singleton = new Lazy2Singleton();
        }
        return lazy2Singleton;
    }

    public void sendMessage() {
        System.out.println("发送单例模式-懒汉模式2");
    }
}
