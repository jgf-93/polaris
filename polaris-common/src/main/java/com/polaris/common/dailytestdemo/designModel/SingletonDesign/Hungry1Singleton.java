package com.polaris.common.dailytestdemo.designModel.SingletonDesign;

/**
 * 饿汉模式
 * 这种方式比较常用，但容易产生垃圾对象。
 * 它基于 classloader 机制避免了多线程的同步问题，
 * 不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
public class Hungry1Singleton {

    private static Hungry1Singleton hungry1Singleton = new Hungry1Singleton();

    private Hungry1Singleton() {

    }

    public static Hungry1Singleton getHungrySingleton() {
        return hungry1Singleton;
    }
}
