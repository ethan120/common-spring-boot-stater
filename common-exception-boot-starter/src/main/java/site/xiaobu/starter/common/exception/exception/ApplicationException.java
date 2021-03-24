package site.xiaobu.starter.common.exception.exception;

import site.xiaobu.starter.common.base.IResponse;

/**
 * @Description: 程序异常
 * 可以作为应用系统的所有异常超类来使用
 * @Author: zhanghuan
 * @Date: 2021-01-06 17:49
 * @Version: V1.0
 */
public class ApplicationException extends RuntimeException {
    private final IResponse response;

    public ApplicationException(IResponse response) {
        this.response = response;
    }

    public ApplicationException(String message, Throwable cause, IResponse response) {
        super(message, cause);
        this.response = response;
    }

    public ApplicationException(Throwable cause, IResponse response) {
        super(cause);
        this.response = response;
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, IResponse response) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.response = response;
    }

    public int getCode() {
        return response.getCode();
    }

    public String getMessage() {
        return response.getMessage();
    }

}
