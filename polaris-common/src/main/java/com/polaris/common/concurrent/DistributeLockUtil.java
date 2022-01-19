package com.polaris.common.concurrent;

import org.springframework.stereotype.Component;

@Component
public class DistributeLockUtil {
/*    @Resource
    private RedissonClient redissonClient;

    public <R> R lockD(String traceId, String key, BusInterface<R> busInterface) {
        R r = null;
        RLock lock = redissonClient.getLock(key);
        lock.lock();
        try {
            r = busInterface.dealBus();
        } catch (Exception e) {
            DopTracer.error(traceId + ",分布式锁业务异常", e);
        } finally {
            lock.unlock();
        }
        return r;
    }*/

}
