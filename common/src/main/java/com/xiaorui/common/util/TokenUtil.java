package com.xiaorui.common.util;

import com.alibaba.fastjson.JSON;
import com.xiaorui.common.enums.TokenPackageType;
import com.xiaorui.common.exception.PermissionException;
import com.xiaorui.common.vo.token.BaseToken;
import com.xiaorui.common.vo.token.TokenPackage;
import com.xiaorui.common.vo.token.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class TokenUtil {

    /**
     * token默认时间,单位分
     */
    private static final Integer TOKEN_DEFAULT_TIME = 24 * 60 * 30;
    private static String jwsKey;

    private static RedisUtils redisUtils;
    //redis缓存token的key    前缀
    public static final String TOKEN_KEY_PREFIX = "access_token_";
    //token过期时间为15分钟
    public static final Long TOKEN_EXPIRE_TIME = 120 * 60L;

    //静态属性注入
    @Autowired
    public TokenUtil(RedisUtils redisUtils) {
        TokenUtil.redisUtils = redisUtils;
    }

    /**
     * 返回token的统一方法
     *
     * @param tokenPackage token对象的包装类
     * @param id           token对象的主键
     * @return
     */
    public static String getTokenUnifiedApproach(TokenPackage tokenPackage, int id) {
        String toJSONString = JSON.toJSONString(tokenPackage);
        Claims claims = Jwts.claims().setSubject(toJSONString);
        LocalDateTime currentTime = LocalDateTime.now();
        Date expirationTime = Date
                .from(currentTime.plusMinutes(TOKEN_DEFAULT_TIME).atZone(ZoneId.systemDefault()).toInstant());
        String jws = Jwts.builder().setClaims(claims).setId(String.valueOf(id))
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(expirationTime).signWith(SignatureAlgorithm.HS512, jwsKey).compact();

        return jws;
    }

    public static String getToken(User user) {
        if (user == null) {
            return "";
        }
        String jws = getTokenUnifiedApproach(user, user.getId());
        String key = TOKEN_KEY_PREFIX + user.getType() + "_" + user.getId();
        redisUtils.set(key, jws, TOKEN_EXPIRE_TIME);
        return jws;


    }

    /**
     * 返回token对象的包装类
     * @param token
     * @return
     */
    public static TokenPackage getTokenPackageByToken(String token) {
        return getToken(token, BaseToken.class);
    }

    public static User getUserByToken(String token){
        return getToken(token, User.class);
    }

    private static <T> T getToken(String jws, Class<T> clazz) throws PermissionException {
        if (StringUtils.isEmpty(jws)) {
            throw PermissionException.PERMISSION_TOKEN_EXPIRE;
        } else {
            Claims claims = Jwts.parser().setSigningKey(jwsKey).parseClaimsJws(jws).getBody();
            String subject = claims.getSubject();
            return JSON.parseObject(subject, clazz);
        }
    }

    /**
     * 验证token是否合法
     *
     * @param token
     */
    public static void checkUserToken(String token) {
        if (StringUtils.isEmpty(token)) {
            throw PermissionException.PERMISSION_TOKEN_EXPIRE;
        } else {
            String subject = Jwts.parser().setSigningKey(jwsKey).parseClaimsJws(token).getBody().getSubject();
            User user = JSON.parseObject(subject, User.class);
            if (user == null || (!TokenPackageType.USER.getName().equals(user.getType()))) {
                throw PermissionException.PERMISSION_TOKEN_EXPIRE;
            }
        }
    }

    @Value("${jws-key:bXlzcHJpbmdib290}")
    private void setJwsKey(String jwsKey) {
        TokenUtil.jwsKey = jwsKey;
    }
}
