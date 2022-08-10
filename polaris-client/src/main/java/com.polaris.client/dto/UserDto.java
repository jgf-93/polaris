package com.polaris.client.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {
    private String userName;
    private Integer age;
}
