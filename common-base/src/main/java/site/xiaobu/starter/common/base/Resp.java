package site.xiaobu.starter.common.base;

public class Resp {
    /**
     * 生成失败情况的响应值
     */
    public static R<?> fail(int code, String msg) {
        return new R<>(false, code, msg, null);
    }

    /**
     * 生成失败情况的响应值带数据
     */
    public static <T> R<T> fail(int code, String msg, T data) {
        return new R<>(false, code, msg, data);
    }

    /**
     * 生成成功情况的响应值
     */
    public static <T> R<T> succeed(int code, String msg, T data) {
        return new R<>(true, code, msg, data);
    }

    /**
     * 生成 400 状态响应值
     */
    public static R<?> new400(String msg) {
        return new R<>(false, 400, msg, null);
    }

    /**
     * 生成 200 状态响应值
     */
    public static <T> R<T> new200(String msg, T data) {
        return new R<>(true, 200, msg, data);
    }

    /**
     * 生成 200 状态响应值
     */
    public static <T> R<T> new200(String msg) {
        return new R<>(true, 200, msg, null);
    }
}
