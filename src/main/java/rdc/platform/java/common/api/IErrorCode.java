package rdc.platform.java.common.api;

/**
 * 封装API的错误码
 */
public interface IErrorCode {
    long getStatusCode();

    String getMessage();
}
