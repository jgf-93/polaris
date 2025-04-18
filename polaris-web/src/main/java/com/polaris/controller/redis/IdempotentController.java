package com.polaris.controller.redis;

import com.polaris.common.re.BaseResponse;
import com.polaris.common.redis.TokenService;
import com.polaris.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("idempotent")
@Transactional
public class IdempotentController extends BaseController {
    @Resource
    private TokenService tokenService;

    @RequestMapping("/token")
    public BaseResponse getToken() {
        return BaseResponse.buildSuccessResponse( tokenService.createToken());
    }

    @RequestMapping("/test")
    public BaseResponse test() {
        System.out.println("校验幂等性:" + System.currentTimeMillis());
        return BaseResponse.buildSuccessResponse();
    }
}
