package com.xiaorui.api.user.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Description 功能概述
 * @Author hsd
 * @Date 2021/12/15 15:20
 * @Version V1.0
 **/
@Data
public class UserLoginRequestVO {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

}
