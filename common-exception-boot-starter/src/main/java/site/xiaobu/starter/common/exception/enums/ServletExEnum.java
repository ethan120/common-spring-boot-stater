package site.xiaobu.starter.common.exception.enums;

import site.xiaobu.starter.common.base.IResponse;
import site.xiaobu.starter.common.constant.HttpStatus;

/**
 * Servlet 操作相关异常
 */
public enum ServletExEnum implements IResponse {

    ServletException(HttpStatus.FAIL, "发生Servlet异常"),
    NoHandlerFoundException(HttpStatus.NO_HANDLER, "没有对应的处理器"),
    HttpRequestMethodNotSupportedException(HttpStatus.NOT_SUPPORT_METHOD, "不支持的请求方式"),
    HttpMediaTypeNotSupportedException(HttpStatus.NOT_SUPPORT_CONTENT_TYPE, "不支持的Content-Type"),
    MissingPathVariableException(HttpStatus.FAIL, "缺少路径参数"),
    MissingServletRequestParameterException(HttpStatus.FAIL, "缺少请求参数"),
    TypeMismatchException(HttpStatus.FAIL, "参数类型不匹配"),
    HttpMediaTypeNotAcceptableException(HttpStatus.FAIL, "前端不支持的Content-Type"),
    MissingServletRequestPartException(HttpStatus.FAIL, "请求缺失了一部分"),
    AsyncRequestTimeoutException(HttpStatus.FAIL, "异步请求超时"),

    HttpMessageNotReadableException(HttpStatus.FAIL, "序列化请求值失败"),
    HttpMessageNotWritableException(HttpStatus.FAIL, "序列化响应值失败"),
    ServletRequestBindingException(HttpStatus.FAIL, "参数绑定失败"),
    ConversionNotSupportedException(HttpStatus.FAIL, "类型转换失败");

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
