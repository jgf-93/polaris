package com.polaris.common.concurrent;

@FunctionalInterface
public interface BusInterface<R> {

    R dealBus();
}
