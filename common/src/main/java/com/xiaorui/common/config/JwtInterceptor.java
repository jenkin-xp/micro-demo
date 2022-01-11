package com.xiaorui.common.config;

import com.xiaorui.common.annotation.ScanIgnore;
import com.xiaorui.common.constants.HeaderValue;
import com.xiaorui.common.annotation.JwtIgnore;
import com.xiaorui.common.annotation.TokenIsIgnore;
import com.xiaorui.common.enums.TokenPackageType;
import com.xiaorui.common.exception.PermissionException;
import com.xiaorui.common.util.RedisUtils;
import com.xiaorui.common.util.StringUtils;
import com.xiaorui.common.util.TokenUtil;
import com.xiaorui.common.vo.token.TokenPackage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: JwtInterceptor
 * @Description:
 * @Author: xp_sh
 * @Date: 2020/6/8 17:53
 * @Version: 1.0
 **/
@Slf4j
@Component
@ScanIgnore
public class JwtInterceptor implements AsyncHandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        request.setAttribute(HeaderValue.USER_ID, 0);
        String token = request.getHeader(HeaderValue.TOKEN);
        if(redisUtils == null){
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtils = factory.getBean("redisUtils", RedisUtils.class);
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
            TokenIsIgnore tokenIsIgnore = handlerMethod.getMethodAnnotation(TokenIsIgnore.class);
            if (tokenIsIgnore != null) {
                if (StringUtils.isNotEmpty(token)) {
                    checkToken(token, request);
                }
                return true;
            }
        }
        if(StringUtils.isEmpty(token)){
            throw PermissionException.PERMISSION_USER_NOT_LOGIN;
        }
        checkToken(token, request);
        return true;
    }

    private void checkToken(String token, HttpServletRequest request) {
        //返回token对象的包装类
        TokenPackage tokenPackage = TokenUtil.getTokenPackageByToken(token);
        if (tokenPackage != null ) {
            if (TokenPackageType.USER.getName().equals(tokenPackage.getType())) {
                String key = TokenUtil.TOKEN_KEY_PREFIX + tokenPackage.getType() + "_" + tokenPackage.getId();
                String message = redisUtils.get(key);
                if (message == null) {
                    throw PermissionException.PERMISSION_TOKEN_EXPIRE;
                } else {
                    request.setAttribute(HeaderValue.USER_ID, tokenPackage.getId());
                    //缓存未过时，因为进行了操作，将其过时时间重置为15分钟
                    redisUtils.set(key, token, TokenUtil.TOKEN_EXPIRE_TIME);
                }
            }
        }
    }

}
