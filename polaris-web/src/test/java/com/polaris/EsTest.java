package com.polaris;

import com.alibaba.fastjson.JSON;
import com.polaris.common.es.ArticleES;
import com.polaris.common.es.ArticleRepository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

public class EsTest extends Test {
    @Resource
    private ArticleRepository articleRepository;

    @org.junit.Test
    public void searchAllArticle() throws Exception {
        Iterable<ArticleES> iterable = articleRepository.findAll();
        iterable.forEach(a -> System.out.println(JSON.toJSONString(a)));
    }

    @org.junit.Test
    public void saveArticle() throws Exception {
        ArticleES articleES = new ArticleES();
        articleES.setId(UUID.randomUUID().getLeastSignificantBits());
        articleES.setImg("test.jpg");
        articleES.setTitle("测试文章");
        articleES.setContent("本次测试文章含有奖励");
        articleES.setCreateTime(new Date());
        articleES.setUpdateTime(new Date());
        articleES=articleRepository.save(articleES);
        System.out.println(JSON.toJSONString(articleES));
    }
}
