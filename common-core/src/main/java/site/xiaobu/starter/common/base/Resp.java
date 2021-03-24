package site.xiaobu.starter.common.base;

public class Resp {

    public static final int SUCCESS = 200;
    public static final int PART_SUCCESS = 206;
    public static final int FAIL = 400;
    public static final int INTERNAL_ERROR = 500;

    public static final int NOT_IMPLEMENTED = 402;
    public static final int NO_HANDLER  = 404;
    public static final int NOT_SUPPORT_METHOD  = 405;
    public static final int NOT_SUPPORT_CONTENT_TYPE  = 415;

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
        return new R<>(false, FAIL, msg, null);
    }

    /**
     * 生成 200 状态响应值
     */
    public static <T> R<T> new200(String msg, T data) {
        return new R<>(true, SUCCESS, msg, data);
    }

    /**
     * 生成 200 状态响应值
     */
    public static <T> R<T> new200(String msg) {
        return new R<>(true, SUCCESS, msg, null);
    }

    /**
     * 生成 206 状态响应值
     */
    public static <T> R<T> new206(String msg) {
        return new R<>(true, PART_SUCCESS, msg, null);
    }
}
