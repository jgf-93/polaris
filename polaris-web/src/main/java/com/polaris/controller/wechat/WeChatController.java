package com.polaris.controller.wechat;

import com.polaris.common.re.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信授权登陆
 */
@Controller
@RequestMapping("/we")
public class WeChatController {
    @RequestMapping("/login")
    public BaseResponse authLogin() {
        return BaseResponse.buildSuccessResponse("", "");
    }
}
