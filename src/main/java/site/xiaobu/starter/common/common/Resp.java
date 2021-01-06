package site.xiaobu.starter.common.common;

public class Resp {
    /**
     * 生成失败情况的响应值
     */
    public static CommonResponse<?> fail(int code, String msg) {
        return new CommonResponse<>(false, code, msg, null);
    }

    /**
     * 生成失败情况的响应值带数据
     */
    public static <T> CommonResponse<T> fail(int code, String msg, T data) {
        return new CommonResponse<>(false, code, msg, data);
    }

    /**
     * 生成成功情况的响应值
     */
    public static <T> CommonResponse<T> succeed(int code, String msg, T data) {
        return new CommonResponse<>(true, code, msg, data);
    }

    /**
     * 生成 400 状态响应值
     */
    public static CommonResponse<?> new400(String msg) {
        return new CommonResponse<>(false, 400, msg, null);
    }

    /**
     * 生成 200 状态响应值
     */
    public static <T> CommonResponse<T> new200(String msg, T data) {
        return new CommonResponse<>(true, 200, msg, data);
    }
}
