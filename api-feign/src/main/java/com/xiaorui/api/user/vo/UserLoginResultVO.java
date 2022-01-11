package com.xiaorui.api.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 登录VO
 * @Author hsd
 * @Date 2021/12/15 15:15
 * @Version V1.0
 **/
@Data
public class UserLoginResultVO implements Serializable {

    private String token;

    public UserLoginResultVO() {
    }

    public UserLoginResultVO(String token) {
        this.token = token;
    }
}
