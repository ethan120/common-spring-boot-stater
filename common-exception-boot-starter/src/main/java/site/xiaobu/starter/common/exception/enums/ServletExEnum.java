package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.base.IResponse;
import site.xiaobu.starter.common.base.Resp;

public enum ServletExEnum implements IResponse {

    NoHandlerFoundException(Resp.NO_HANDLER, "没有对应的处理器"),
    HttpRequestMethodNotSupportedException(Resp.NOT_SUPPORT_METHOD, "不支持的请求方式"),
    HttpMediaTypeNotSupportedException(Resp.NOT_SUPPORT_CONTENT_TYPE, "不支持的Content-Type"),
    MissingPathVariableException(Resp.FAIL, "缺少路径参数"),
    MissingServletRequestParameterException(Resp.FAIL, "缺少请求参数"),
    TypeMismatchException(Resp.FAIL, "参数类型不匹配"),
    HttpMediaTypeNotAcceptableException(Resp.FAIL, "前端不支持的Content-Type"),
    MissingServletRequestPartException(Resp.FAIL, "请求缺失了一部分"),
    AsyncRequestTimeoutException(Resp.FAIL, "异步请求超时"),

    HttpMessageNotReadableException(Resp.FAIL, "序列化请求值失败"),
    HttpMessageNotWritableException(Resp.FAIL, "序列化响应值失败"),
    ServletRequestBindingException(Resp.FAIL, "参数绑定失败"),
    ConversionNotSupportedException(Resp.FAIL, "类型转换失败");

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
