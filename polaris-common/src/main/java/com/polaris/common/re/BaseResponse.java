package com.polaris.common.re;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private T data;
    private int code = 200;
    private String message = "";

    public static <V> BaseResponse buildSuccessResponse(V data) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(200);
        baseResponse.setMessage("");
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <V> BaseResponse buildSuccessResponse() {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(200);
        baseResponse.setMessage("成功");
        baseResponse.setData(null);
        return baseResponse;
    }

    public static BaseResponse buildErrorResponse(String message) {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setCode(400);
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
