package com.polaris.common.re.request;

import com.polaris.common.re.BaseRequest;
import lombok.Data;

@Data
public class UserRequest extends BaseRequest {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 账号名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String photo;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * qq号
     */
    private String qq;
}
