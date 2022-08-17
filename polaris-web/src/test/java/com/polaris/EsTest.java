//package com.polaris;
//
//import com.alibaba.fastjson.JSON;
//import com.polaris.common.es.ArticleES;
//import com.polaris.common.es.ArticleRepository;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
//public class EsTest extends Test {
//    @Resource
//    private ArticleRepository articleRepository;
//
//    @org.junit.Test
//    public void searchAllArticle() throws Exception {
//        Iterable<ArticleES> iterable = articleRepository.findAll();
//        iterable.forEach(a -> System.out.println(JSON.toJSONString(a)));
//    }
//
//    @org.junit.Test
//    public void saveArticle() throws Exception {
//        ArticleES articleES = new ArticleES();
//        articleES.setId(System.currentTimeMillis());
//        articleES.setImg("test.jpg");
//        articleES.setTitle("小陈文章经典");
//        articleES.setContent("小陈文章包含火影忍者的内容");
//        articleES.setCreateTime(new Date());
//        articleES.setUpdateTime(new Date());
//        articleES = articleRepository.save(articleES);
//        System.out.println(JSON.toJSONString(articleES));
//    }
//
//    /**
//     * es 关键词模糊查询
//     */
//    @org.junit.Test
//    public void searchArticleByKeyWord() throws Exception {
//        //ArticleES articleES = articleRepository.findByTitle("小蒋");
////        List<ArticleES> articleESList = articleRepository.findByTitleOrContent("小蒋", "忙");
////        System.out.println(JSON.toJSONString(articleESList));
//        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
//                .must(QueryBuilders.matchPhraseQuery("title.keyword", "小蒋文章"));
//        Iterable<ArticleES> aList = articleRepository.search(queryBuilder);
//        System.out.println(JSON.toJSONString(aList));
//    }
//}
