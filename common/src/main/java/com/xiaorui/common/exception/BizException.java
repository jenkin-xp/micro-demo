package com.xiaorui.common.exception;

/**
 * @Description 自定义业务异常
 * @Author xp
 * @Date 2022/1/7 11:26
 * @Version V1.0
 **/
public class BizException extends RuntimeException {

    public static final BizException PARAM_DELETION = new BizException(90040012, "参数缺失", new Object[0]);

    protected String msg;
    protected int code;
    protected String traceId;

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException(String traceId, int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
        this.traceId = traceId;
    }

    public BizException() {
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getTraceId() {
        return traceId;
    }

    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause, String traceId) {
        super(cause);
        this.traceId = traceId;
    }

    public BizException(Throwable cause, String traceId, int code) {
        super(cause);
        this.traceId = traceId;
        this.code = code;
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(ExceptionCode exceptionCode){

        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
        this.msg = exceptionCode.getMessage();
    }

}
