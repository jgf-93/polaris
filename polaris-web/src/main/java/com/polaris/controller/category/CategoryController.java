package com.polaris.controller.category;

import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.CategoryRequest;
import com.polaris.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 插入类目数据
     *
     * @param categoryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/insert")
    public BaseResponse insert(CategoryRequest categoryRequest) throws Exception {
        categoryService.insert(categoryRequest);
        return BaseResponse.buildSuccessResponse("上传成功", "");
    }

    /**
     * 根据父类目id查询子类目
     *
     * @param categoryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/query")
    public BaseResponse query(CategoryRequest categoryRequest) throws Exception {
        return categoryService.queryCategory(categoryRequest);
    }
}
