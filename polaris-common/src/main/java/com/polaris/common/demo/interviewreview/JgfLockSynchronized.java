package com.polaris.common.demo.interviewreview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JgfLockSynchronized {

    private static volatile int x = 1;

    public static void main(String[] args) throws InterruptedException {
        TestLockDemo testLockDemo = new TestLockDemo();
        //testLockDemo.addAdd();
        //System.out.println(testLockDemo.getCount());
        JgfLockSynchronized j = new JgfLockSynchronized();
        j.testCondition();
    }

    public static void testVolatie() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                if (finalI == 3) {
                    x += 1;
                }
                System.out.println(x);
            }).start();
        }
    }

    Lock cLock = new ReentrantLock();
    Condition c = cLock.newCondition();

    public void testCondition() throws InterruptedException {
        new Thread(() -> {
            try {
                cLock.lock();
                c.await();
                System.out.println("测试condition并发");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                cLock.unlock();
            }

        }).start();
        Thread.sleep(1000);
        cLock.lock();
        c.signal();
        cLock.unlock();

    }

    static class TestLockDemo {
        private Lock lock = new ReentrantLock();
        private int count = 0;

        public void add() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public void addAdd() {
            lock.lock();
            try {
                count++;
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }

        private Lock fairlock = new ReentrantLock(true);

        public void fairAdd() {
            fairlock.lock();
            try {
                count++;
            } finally {
                fairlock.unlock();
            }
        }

        public Integer getCount() {
            return count;
        }
    }
}
