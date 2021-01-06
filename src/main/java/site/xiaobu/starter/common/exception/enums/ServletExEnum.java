package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.common.IResponse;

public enum ServletExEnum implements IResponse {

    NoHandlerFoundException(404, "没有对应的处理器"),
    HttpRequestMethodNotSupportedException(405, "不支持的请求方式"),
    HttpMediaTypeNotSupportedException(415, "不支持的Content-Type"),
    MissingPathVariableException(400, "缺少路径参数"),
    MissingServletRequestParameterException(400, "缺少请求参数"),
    TypeMismatchException(400, "参数类型不匹配"),
    HttpMediaTypeNotAcceptableException(400, "前端不支持的Content-Type"),
    MissingServletRequestPartException(400, "请求缺失了一部分"),
    AsyncRequestTimeoutException(400, "异步请求超时"),

    HttpMessageNotReadableException(400, "序列化请求值失败"),
    HttpMessageNotWritableException(400, "序列化响应值失败"),
    ServletRequestBindingException(400, "参数绑定失败"),
    ConversionNotSupportedException(400, "类型转换失败");

    ServletExEnum(int code, String message) {
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
