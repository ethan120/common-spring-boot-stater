package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.base.IResponse;
import site.xiaobu.starter.common.constant.HttpStatus;

/**
 * 基础异常
 * */
public enum BaseExEnum implements IResponse {
    NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED,"没有编写业务逻辑,此为默认实现");

    private final String message;
    private final int code;

    BaseExEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
