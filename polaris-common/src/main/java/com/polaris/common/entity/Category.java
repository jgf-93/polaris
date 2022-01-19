package com.polaris.common.entity;

import lombok.Data;

import java.util.List;

/**
 * 课程分类
 */
@Data
public class Category extends BaseEntity {
    /**
     * 类目id
     */
    private Long id;
    /**
     * 父类目id
     */
    private int parentId;
    /**
     * 类目等级
     */
    private int level;
    /**
     * 类目名称
     */
    private String name;
}
