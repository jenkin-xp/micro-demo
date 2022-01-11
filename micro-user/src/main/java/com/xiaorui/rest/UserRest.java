package com.xiaorui.rest;

import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.api.user.vo.UserLoginRequestVO;
import com.xiaorui.api.user.vo.UserLoginResultVO;
import com.xiaorui.common.vo.ResponseDTO;
import com.xiaorui.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/10 11:25
 * @Version V1.0
 **/
@RestController
@RequestMapping(ServiceId.MODEL_ID_USER)
public class UserRest {

    @Autowired
    private IAdminService adminService;

    @PostMapping("login")
    public ResponseDTO<UserLoginResultVO> login(@RequestBody UserLoginRequestVO requestVO) {
        return adminService.login(requestVO);
    }

}
