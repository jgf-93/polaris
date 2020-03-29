package com.polaris.common.demo.designModel.SingletonDesign;

/**
 * 懒汉模式-使用时被产生
 * 静态内部类实现
 * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，
 * 它跟第 3 种方式不同的是：第 3 种方式只要 Singleton 类被装载了，那么 instance 就会被实例化
 * （没有达到 lazy loading 效果），
 * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，
 * 只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。
 * 想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，
 * 另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化 instance 显然是不合适的
 */
public class Lazy4Singleton {

    private static class SingletonHolder {
        private static Lazy4Singleton lazy4Singleton = new Lazy4Singleton();
    }

    private Lazy4Singleton() {

    }

    public static Lazy4Singleton getLazy4Singleton() {
        return SingletonHolder.lazy4Singleton;
    }
}
