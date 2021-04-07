package site.xiaobu.starter.common.base;

import site.xiaobu.starter.common.constant.HttpStatus;

/**
 * 工具类，用于构建响应对象
 * */
public final class Resp {
    /**
     * 生成失败情况的响应对象
     */
    public static R<?> newFailed(int code, String msg) {
        return new R<>(false, code, msg, null);
    }

    /**
     * 生成失败情况的响应对象
     */
    public static <T> R<T> newFailed(int code, String msg, T data) {
        return new R<>(false, code, msg, data);
    }

    /**
     * 生成成功情况的响应对象
     */
    public static <T> R<T> newSucceed(int code, String msg, T data) {
        return new R<>(true, code, msg, data);
    }

    /**
     * 生成 400 状态响应对象
     * 逻辑执行异常或业务失败
     */
    public static R<?> new400(String msg) {
        return new R<>(false, HttpStatus.FAIL, msg, null);
    }

    /**
     * 生成 200 状态响应对象
     * 逻辑执行正常且业务成功
     */
    public static <T> R<T> new200(String msg, T data) {
        return new R<>(true, HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 生成 200 状态响应对象
     * 逻辑执行正常且业务成功
     */
    public static <T> R<T> new200(String msg) {
        return new R<>(true, HttpStatus.SUCCESS, msg, null);
    }

    /**
     * 生成 206 状态响应对象
     * 批量任务中,逻辑执行正常但部分业务失败
     */
    public static <T> R<T> new206(String msg) {
        return new R<>(true, HttpStatus.PART_SUCCESS, msg, null);
    }

    /**
     * 生成完全可自定义的响应对象
     * */
    public static <T> R<T> newResp(boolean success,int code,String msg,T data){
        return new R<>(success,code,msg,data);
    }
}
