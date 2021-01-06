package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.common.IResponse;

/**
 * @Description: SQL相关异常
 * @Author: zhanghuan
 * @Date: 2020-12-14 14:58
 * @Version: V1.0
 */
public enum SQLExEnum implements IResponse {

    DataAccessException(500, "数据访问错误");

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
