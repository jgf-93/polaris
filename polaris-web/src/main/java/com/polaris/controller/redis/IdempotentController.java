package com.polaris.controller.redis;

import com.polaris.common.re.BaseResponse;
import com.polaris.common.redis.TokenService;
import com.polaris.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("idempotent")
public class IdempotentController extends BaseController {
    @Resource
    private TokenService tokenService;

    @RequestMapping("/token")
    public BaseResponse getToken() {
        return BaseResponse.buildSuccessResponse("获取token成功", tokenService.createToken());
    }

    @RequestMapping("/test")
    public BaseResponse test() {
        System.out.println("校验幂等性:" + System.currentTimeMillis());
        return BaseResponse.buildSuccessResponse("接口调用成功,reids幂等成功", "");
    }
}
