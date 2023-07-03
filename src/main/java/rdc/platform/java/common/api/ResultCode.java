package rdc.platform.java.common.api;


/**
 * 枚举了一些常用API操作码
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long statusCode;
    private String message;

    private ResultCode(long code, String message) {
        this.statusCode = code;
        this.message = message;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
