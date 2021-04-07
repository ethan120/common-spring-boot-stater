package site.xiaobu.starter.common.constant;

/**
 * 常用状态码
 * */
public final class HttpStatus {
    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 部分成功
     */
    public static final int PART_SUCCESS = 206;
    /**
     * 失败
     */
    public static final int FAIL = 400;
    /**
     * 内部错误
     * */
    public static final int INTERNAL_ERROR = 500;

    /**
     * 接口未实现
     */
    public static final int NOT_IMPLEMENTED = 402;
    /**
     * 没有处理器
     */
    public static final int NO_HANDLER = 404;
    /**
     * 方法不支持
     */
    public static final int NOT_SUPPORT_METHOD = 405;
    /**
     * Content-Type 不支持
     * */
    public static final int NOT_SUPPORT_CONTENT_TYPE  = 415;
}
