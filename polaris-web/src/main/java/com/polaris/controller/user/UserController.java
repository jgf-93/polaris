package com.polaris.controller.user;

import com.polaris.common.entity.User;
import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.UserRequest;
import com.polaris.controller.BaseController;
import com.polaris.service.user.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 用户登陆接口
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户登陆注册")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    //swagger返回值注解
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "0 成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model", response = User.class) })
    @ApiOperation(httpMethod = "post", value = "登陆接口")//swagger 当前接口注解
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
