package site.xiaobu.starter.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import site.xiaobu.starter.common.common.R;
import site.xiaobu.starter.common.common.Resp;
import site.xiaobu.starter.common.exception.enums.ServletExEnum;

import javax.annotation.PostConstruct;

/**
 * @Description: Servlet层的异常处理
 * @Author: zhanghuan
 * @Date: 2020-12-28 16:49
 * @Version: V1.0
 */
@RestControllerAdvice
public class ServletExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ServletExceptionHandler.class);

    @PostConstruct
    public void init() {
        log.info("web异常处理初始化完毕...");
    }

    /**
     * Servlet相关异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R<?> handleServletException(Exception e) {
        log.info("发生Servlet异常", e);
        ServletExEnum servletExceptionEnum = ServletExEnum.valueOf(e.getClass().getSimpleName());
        int code = servletExceptionEnum.getCode();
        return Resp.fail(code, servletExceptionEnum.getMessage());
    }
}
