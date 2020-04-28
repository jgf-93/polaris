package com.polaris.controller.user;

import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.UserRequest;
import com.polaris.controller.BaseController;
import com.polaris.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆接口
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse Login(UserRequest userRequest) {
        userService.login(getResponse(), userRequest);
        return BaseResponse.buildSuccessResponse("");
    }
}
