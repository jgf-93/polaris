package com.polaris.common.mapper;

import com.polaris.common.entity.Category;
import com.polaris.common.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> query(Map<String, Object> map);
}
