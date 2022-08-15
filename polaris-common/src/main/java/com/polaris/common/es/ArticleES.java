package com.polaris.common.es;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleES {
    private Long id;
    private String title;
    private String img;
    private String content;
    private Date createTime;
    private Date updateTime;
}
