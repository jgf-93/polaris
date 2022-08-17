package com.polaris.common.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "db",type="article")
public class ArticleES {
    @Id
    private Long id;
    private String title;
    private String img;
    private String content;
    private Date createTime;
    private Date updateTime;
}
