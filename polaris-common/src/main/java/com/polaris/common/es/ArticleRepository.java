//package com.polaris.common.es;
//
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//
//import java.util.List;
//
//public interface ArticleRepository extends ElasticsearchRepository<ArticleES, Long> {
//
//    ArticleES findByTitle(String title);
//
//    List<ArticleES> findByTitleOrContent(String title,String content);
//}
