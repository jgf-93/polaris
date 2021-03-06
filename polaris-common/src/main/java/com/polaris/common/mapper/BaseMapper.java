package com.polaris.common.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    void insert(T t);

    int count(Map<String, Object> map);

    List<T> list(Map<String, Object> map);

    void update(T t);
}
