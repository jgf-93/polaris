package com.polaris.common.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockContext {
    private static ReadWriteLock lock=new ReentrantReadWriteLock();

    private static Map<String,String> lockMap=new HashMap<>();

    public static String get(String key){
        Lock rlock=lock.readLock();
        rlock.lock();
        try{
            return lockMap.get(key);
        }finally {
            rlock.unlock();
        }
    }
    public static void put(String key,String value){
        Lock wlock=lock.writeLock();
        wlock.lock();
        try {
            lockMap.put(key,value);
        }finally {
            wlock.unlock();
        }
    }
}
