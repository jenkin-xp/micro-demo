package com.xiaorui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaorui.api.user.vo.UserLoginRequestVO;
import com.xiaorui.api.user.vo.UserLoginResultVO;
import com.xiaorui.common.exception.ExceptionCode;
import com.xiaorui.common.util.TokenUtil;
import com.xiaorui.common.vo.ResponseDTO;
import com.xiaorui.common.vo.token.User;
import com.xiaorui.model.Admin;
import com.xiaorui.mapper.AdminMapper;
import com.xiaorui.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 小睿后台用户管理 服务实现类
 * </p>
 *
 * @author 夏鹏
 * @since 2022-01-11
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public ResponseDTO<UserLoginResultVO> login(UserLoginRequestVO requestVO) {
        Admin userModel = getByUsername(requestVO.getUsername());
        if (userModel == null || !userModel.getPassword().equals(requestVO.getPassword())) {
            return new ResponseDTO<>(ExceptionCode.LOGIN_ERROR);
        }
        return new ResponseDTO<>(getLoginResult(userModel));
    }

    private UserLoginResultVO getLoginResult(Admin userModel) {
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        String token = TokenUtil.getToken(user);
        return new UserLoginResultVO(token);
    }

    private Admin getByUsername(String username) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, username);
        queryWrapper.eq(Admin::getInvalid, false);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
