package com.polaris.controller.user;

import com.polaris.common.entity.User;
import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.UserRequest;
import com.polaris.controller.BaseController;
import com.polaris.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 用户登陆接口
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse Login(UserRequest userRequest) throws UnsupportedEncodingException {
        userService.login(getResponse(), userRequest);
        return BaseResponse.buildSuccessResponse("", "");
    }

    @RequestMapping("register")
    @ResponseBody
    public BaseResponse register(UserRequest userRequest) {
        return userService.register(userRequest);
    }

    @RequestMapping("test")
    @ResponseBody
    public BaseResponse test(UserRequest userRequest) {
        //return userService.register(userRequest);
        return BaseResponse.buildSuccessResponse("", "");
    }
}
