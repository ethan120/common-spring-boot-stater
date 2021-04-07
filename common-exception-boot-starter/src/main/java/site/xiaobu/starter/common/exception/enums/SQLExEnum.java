package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.base.IResponse;
import site.xiaobu.starter.common.constant.HttpStatus;

/**
 * SQL 操作相关异常
 */
public enum SQLExEnum implements IResponse {

    DataAccessException(HttpStatus.INTERNAL_ERROR, "数据访问错误");

    SQLExEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    private final String message;
    private final int code;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
