package com.polaris.common.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class User extends BaseEntity {
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
