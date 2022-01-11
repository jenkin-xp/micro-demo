package com.xiaorui.common.vo.token;

import com.xiaorui.common.enums.TokenPackageType;
import lombok.Data;

import java.util.Date;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2021/12/9 15:25
 * @Version V1.0
 **/
@Data
public class User extends TokenPackage{

    private String username;

    private String password;

    private String nickname;

    private Integer status;

    private String deviceId;

    private Date registerDate;

    @Override
    public void setIndependType() {
        setType(TokenPackageType.USER.getName());
    }
}
