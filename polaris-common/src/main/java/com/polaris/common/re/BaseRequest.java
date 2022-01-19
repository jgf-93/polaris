package com.polaris.common.re;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequest implements Serializable {
    private int pageNo = 1;
    private int pageSize = 10;
}
