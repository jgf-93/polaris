package com.polaris.common.demo.interviewreview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JgfReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        JgfReadWriteLock jgfReadWriteLock=new JgfReadWriteLock();
        new Thread(()->jgfReadWriteLock.writeData("test")).start();
        new Thread(()->jgfReadWriteLock.writeData("jgf")).start();
        //new Thread(()->jgfReadWriteLock.readData()).start();
        Thread.sleep(10000);
        System.out.println(1);
    }

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<String> data = new ArrayList<>();

    public void writeData(String newData) {
        lock.writeLock().lock();
        try {
            // 写入共享数据
            data.add(newData);
            System.out.println("write data: " + newData);

            // 获取读锁
            lock.readLock().lock();
            System.out.println("写入测试数据");
        } finally {
            // 释放写锁
            lock.writeLock().unlock();
            lock.readLock().unlock();
        }
    }

    public void readData() {
        lock.readLock().lock();
        try {
            // 读取共享数据
            System.out.println("read data: " + data);
        } finally {
            // 释放读锁
            lock.readLock().unlock();
        }
    }
}
