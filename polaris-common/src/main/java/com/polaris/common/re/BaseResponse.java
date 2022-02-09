package com.polaris.common.re;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private T data;
    private int count = 0;
    private int code = 200;
    private String message = "";

    public static <V> BaseResponse buildSuccessResponse(int count, V data) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(200);
        baseResponse.setMessage("");
        baseResponse.setCount(count);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <V> BaseResponse buildSuccessResponse(String message, V data) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(200);
        baseResponse.setMessage(message);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static BaseResponse buildErrorResponse(String message) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(400);
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
