package com.polaris.common.demo.interviewreview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnReentLock {
    Lock lock=new ReentrantLock();

    public void testA(){
        lock.lock();
        testB();
        lock.unlock();
    }
    public void testB(){
        lock.lock();
        System.out.println("测试可重入锁");
        lock.unlock();
    }

    public static void main(String[] args) {
        UnReentLock ur=new UnReentLock();
        ur.testA();
    }
}
