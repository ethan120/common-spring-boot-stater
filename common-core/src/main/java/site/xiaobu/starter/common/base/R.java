package site.xiaobu.starter.common.base;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 响应对象
 * code 响应码
 * message 相应信息
 * data 具体响应内容
 * success 逻辑成功与否
 *
 * 不要直接 new 此实例，使用 Resp 类的方法构建
 * */
@Data
public class R<T> implements IResponse {

    private int code;
    private String message;
    private T data;
    private final boolean success;

    public boolean success() {
        return this.success;
    }

    R(boolean success, int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
