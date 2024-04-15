package com.polaris.common.demo.interviewreview;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestThread {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String args[]) {
        //读
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    try {
                        readLock.lock();
                        System.out.println("thread " + threadName + " read locking");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        readLock.unlock();
                        System.out.println("thread " + threadName + " release read lock remain read count:" + readWriteLock.getReadLockCount());
                    }
                }
            }, "" + i).start();
        }

        //写
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    try {
                        writeLock.lock();
                        System.out.println("thread " + threadName + " write locking");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        writeLock.unlock();
                        System.out.println("thread " + threadName + " release write lock remain write count:" + readWriteLock.getWriteHoldCount());
                    }
                }
            }, "" + i).start();
        }
    }
}