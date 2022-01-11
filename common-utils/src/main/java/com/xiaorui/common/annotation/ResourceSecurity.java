package com.xiaorui.common.annotation;

import java.lang.annotation.*;

/**
 * ========================
 * JWT验证：资源验证注解
 * Author：xp_sh
 * Date：2020/06/08 18:00
 * ========================
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceSecurity {
}
