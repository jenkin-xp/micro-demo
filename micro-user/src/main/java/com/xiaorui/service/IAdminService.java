package com.xiaorui.service;


import com.xiaorui.api.user.vo.UserLoginRequestVO;
import com.xiaorui.api.user.vo.UserLoginResultVO;
import com.xiaorui.common.vo.ResponseDTO;

/**
 * <p>
 * 后台用户管理 服务类
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-11
 */
public interface IAdminService  {

    ResponseDTO<UserLoginResultVO> login(UserLoginRequestVO requestVO);
}
