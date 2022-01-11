package com.xiaorui.common.annotation;

import java.lang.annotation.*;

/**
 * @Description 自定义扫描忽略
 * @Author xp
 * @Date 2022/1/11 15:57
 * @Version V1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ScanIgnore {
}
