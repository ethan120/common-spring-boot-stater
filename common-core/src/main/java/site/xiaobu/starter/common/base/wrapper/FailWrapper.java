package site.xiaobu.starter.common.base.wrapper;

/**
 * 失败包装类
 * 将执行某个功能失败用到的业务对象包装起来
 * */
public class FailWrapper<T> {
    /**
     * 失败原因信息
     * */
    private String msg;
    /**
     * 失败原因代码
     * */
    private int code;
    /**
     * 原始失败对象
     * */
    private T origin;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getOrigin() {
        return origin;
    }

    public void setOrigin(T origin) {
        this.origin = origin;
    }
}
