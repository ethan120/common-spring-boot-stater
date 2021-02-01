package site.xiaobu.starter.common.base;

public class R<T> implements IResponse {

    private int code;

    private String message;

    private T data;

    private final boolean success;

    public boolean success() {
        return this.success;
    }

    protected R(boolean success, int code, String message, T data) {
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

    public T getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
