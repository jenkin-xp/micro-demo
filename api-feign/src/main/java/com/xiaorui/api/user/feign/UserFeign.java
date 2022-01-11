package com.xiaorui.api.user.feign;

import com.xiaorui.api.config.FeignClientErrorDecoder;
import com.xiaorui.api.constants.ServiceId;
import com.xiaorui.api.user.vo.UserLoginRequestVO;
import com.xiaorui.api.user.vo.UserLoginResultVO;
import com.xiaorui.common.vo.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = ServiceId.SERVICE_ID_USER, path = ServiceId.MODEL_ID_USER, configuration = FeignClientErrorDecoder.class)
public interface UserFeign {

    @PostMapping("login")
    ResponseDTO<UserLoginResultVO> login(UserLoginRequestVO requestVO);

}
