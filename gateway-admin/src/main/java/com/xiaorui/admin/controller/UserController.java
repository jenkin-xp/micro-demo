package com.xiaorui.admin.controller;

import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.api.user.feign.UserFeign;
import com.xiaorui.api.user.vo.UserLoginRequestVO;
import com.xiaorui.api.user.vo.UserLoginResultVO;
import com.xiaorui.common.constants.HeaderValue;
import com.xiaorui.common.util.TokenUtil;
import com.xiaorui.common.vo.ResponseDTO;
import com.xiaorui.common.vo.token.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/11 17:55
 * @Version V1.0
 **/
@RestController
@RequestMapping(ServiceId.MODEL_ID_USER)
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @PostMapping("login")
    public ResponseDTO<UserLoginResultVO> login(@RequestBody @Validated UserLoginRequestVO requestVO) {
        return userFeign.login(requestVO);
    }

    @GetMapping("getUserInfo")
    public ResponseDTO<User> getUserInfo(@RequestHeader(HeaderValue.TOKEN) String token) {
        User user = TokenUtil.getUserByToken(token);
        return new ResponseDTO<>(user);
    }

}
