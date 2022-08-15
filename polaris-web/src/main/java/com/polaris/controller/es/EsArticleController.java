package com.polaris.controller.es;

import com.polaris.common.es.ArticleES;
import com.polaris.common.es.ArticleRepository;
import com.polaris.common.re.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(name = "search")
public class EsArticleController {
    @Resource
    private ArticleRepository articleRepository;

    @RequestMapping("allArticle")
    public BaseResponse searchAllArticle() throws Exception {
        Iterable<ArticleES> iterable = articleRepository.findAll();
        return BaseResponse.buildSuccessResponse(iterable);
    }

    @RequestMapping("saveArticle")
    public BaseResponse saveArticle(String title, String content) throws Exception {
        ArticleES articleES = new ArticleES();
        articleES.setId(UUID.class.newInstance().getLeastSignificantBits());
        articleES.setImg("test.jpg");
        articleES.setTitle(title);
        articleES.setContent(content);
        articleES.setCreateTime(new Date());
        articleES.setUpdateTime(new Date());
        articleES = articleRepository.save(articleES);
        return BaseResponse.buildSuccessResponse();
    }
}
