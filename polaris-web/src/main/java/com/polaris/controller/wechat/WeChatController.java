package com.polaris.controller.wechat;

import com.polaris.common.re.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信授权登陆
 */
@RestController
@RequestMapping("/we")
public class WeChatController {
    @RequestMapping("/login")
    public BaseResponse authLogin() {
        return BaseResponse.buildSuccessResponse();
    }
}
