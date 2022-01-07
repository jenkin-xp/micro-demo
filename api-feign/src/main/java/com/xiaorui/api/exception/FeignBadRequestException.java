package com.xiaorui.api.exception;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/7 11:30
 * @Version V1.0
 **/
public class FeignBadRequestException extends RuntimeException {

    private int code;

    private String message;

    public FeignBadRequestException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public FeignBadRequestException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
