package com.polaris.common.demo.thread;

public class LockDemo {
    LockImpl lockImpl = new LockImpl();

    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "开始获取锁");
                lockImpl.lock();
                System.out.println(Thread.currentThread() + "获取到锁执行");
                lockImpl.unlock();
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        lockDemo.test();
    }
}
