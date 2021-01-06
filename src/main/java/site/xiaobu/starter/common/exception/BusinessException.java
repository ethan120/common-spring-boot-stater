package site.xiaobu.starter.common.exception;

import site.xiaobu.starter.common.common.IResponse;

/**
 * @Description: 业务异常
 * @Author: zhanghuan
 * @Date: 2021-01-06 17:49
 * @Version: V1.0
 */
public class BusinessException extends RuntimeException {
    private IResponse response;

    public BusinessException(IResponse response) {
        this.response = response;
    }

    public BusinessException(String message, Throwable cause, IResponse response) {
        super(message, cause);
        this.response = response;
    }

    public BusinessException(Throwable cause, IResponse response) {
        super(cause);
        this.response = response;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, IResponse response) {
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
