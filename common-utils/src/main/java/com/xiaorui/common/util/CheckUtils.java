package com.xiaorui.common.util;

import java.util.List;
import java.util.Map;

/**
 * @Description: 校验工具类
 * @Author: xp
 * @Date: 2021/3/2 14:45
 * @Version: 1.0
 **/
public class CheckUtils {

    public static boolean isEmpty(Object obj) {
        return (obj == null || obj.toString().isEmpty());
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isEmpty(Integer integer) {
        return (integer == null || integer == 0);
    }

    public static boolean isNotEmpty(Integer integer) {
        return !isEmpty(integer);
    }

    public static boolean isEmpty(List<?> list) {
        return (list == null || list.isEmpty());
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
