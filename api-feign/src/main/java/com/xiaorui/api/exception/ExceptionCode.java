package com.xiaorui.api.exception;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/7 11:27
 * @Version V1.0
 **/
public enum ExceptionCode {

    SYSTEM_ERROR(700, "系统错误"),

    FEIGN_ERROR(701, "feign相关错误"),

    BUSINESS_ERROR(702, "业务异常"),

    LOGIN_ERROR(80820001, "不存在的用户或错误的密码"),

    ROLE_ERROR(80820002, "不存在的角色"),

    USERNAME_ERROR(80820003, "用户名不能包含特殊字符"),

    EMAIL_ERROR(80820004, "错误的邮箱格式"),

    PHONE_ERROR(80820005, "错误的手机号码"),

    USED_PHONE(80820006, "手机号码已被使用"),

    USED_NAME(80820007, "用户名已被使用"),

    CODE_ERROR(80820008, "错误的验证码"),

    BOOK_NOT_EXIST(80820009, "书籍不存在"),

    SERVICE_ERROR(80821000,"服务异常"),
    ;




    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
