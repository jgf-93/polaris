package com.polaris.common.demo.designModel.SingletonDesign;

/**
 * 懒汉模式3-
 * 双检锁
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class Lazy3Sington {
    private static Lazy3Sington lazy3Sington;

    private Lazy3Sington() {

    }

    public Lazy3Sington getLazy3Sington() {
        if (lazy3Sington == null) {
            synchronized (Lazy3Sington.this) {
                if (lazy3Sington == null) {
                    lazy3Sington = new Lazy3Sington();
                }
            }
        }
        return lazy3Sington;
    }
}
