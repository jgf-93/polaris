package com.polaris.common.demo.newdesign.singleton;

public class LazySingleton {
    private static LazySingleton lazySingleton;
    private LazySingleton() {

    }

    /**
     * 线程不安全不推荐使用
     *
     * @return
     */
    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * 线程安全 效率降低不推荐使用
     *
     * @return
     */
    public static synchronized LazySingleton getLazySingleton2() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
        LazySingleton lazySingleton2 = LazySingleton.getLazySingleton();
        System.out.println(lazySingleton1 == lazySingleton2);

        LazySingleton lazySingleton3 = LazySingleton.getLazySingleton2();
        LazySingleton lazySingleton4 = LazySingleton.getLazySingleton2();
        System.out.println(lazySingleton3 == lazySingleton4);
    }
}
