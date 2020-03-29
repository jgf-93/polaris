package com.polaris.common.demo.designModel.SingletonDesign;

/**
 * 懒汉模式-线程不安全
 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class Lazy1Singleton {
    private Lazy1Singleton lazy1Singleton;

    private Lazy1Singleton() {

    }

    public Lazy1Singleton getLazySingleton() {
        if (lazy1Singleton == null) {
            lazy1Singleton = new Lazy1Singleton();
        }
        return lazy1Singleton;
    }

    public void sendMessage() {
        System.out.println("发送单例模式-懒汉模式1");
    }
}
