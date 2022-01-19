package com.polaris.service.category;

import com.polaris.common.entity.Category;
import com.polaris.common.mapper.CategoryMapper;
import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.CategoryRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 插入类目数据
     *
     * @param categoryRequest
     */
    public void insert(CategoryRequest categoryRequest) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryRequest, category);
        categoryMapper.insert(category);
    }

    /**
     * 查询分类数据
     */
    public BaseResponse queryCategory(CategoryRequest categoryRequest) {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", categoryRequest.getParentId());
        return BaseResponse.buildSuccessResponse("查询数据成功", categoryMapper.query(map));
    }
}
