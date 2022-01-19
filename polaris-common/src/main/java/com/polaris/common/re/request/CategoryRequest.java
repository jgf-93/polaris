package com.polaris.common.re.request;

import com.polaris.common.entity.BaseEntity;
import com.polaris.common.re.BaseRequest;
import lombok.Data;

@Data
public class CategoryRequest extends BaseRequest {
    private Long parentId;
    private Integer level;
    private String name;
}
