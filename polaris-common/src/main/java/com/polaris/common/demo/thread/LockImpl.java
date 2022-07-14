package com.polaris.common.demo.thread;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class LockImpl implements Lock {
    private AtomicReference<Thread> currThread = new AtomicReference();
    private LinkedBlockingQueue<Thread> threadQueue = new LinkedBlockingQueue<>();

    @Override
    public void lock() {
        while (!tryLock()) {
            threadQueue.offer(Thread.currentThread());
            LockSupport.park();
            threadQueue.remove(Thread.currentThread());
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return currThread.compareAndSet(null, Thread.currentThread());
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        currThread.compareAndSet(Thread.currentThread(), null);
        Iterator<Thread> iterato = threadQueue.iterator();
        while (iterato.hasNext()) {
            LockSupport.unpark(iterato.next());
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
