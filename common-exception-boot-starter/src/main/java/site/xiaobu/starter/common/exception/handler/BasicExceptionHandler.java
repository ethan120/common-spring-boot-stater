package site.xiaobu.starter.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.xiaobu.starter.common.base.R;
import site.xiaobu.starter.common.base.Resp;
import site.xiaobu.starter.common.constant.HttpStatus;
import site.xiaobu.starter.common.exception.exception.ApplicationException;
import site.xiaobu.starter.common.exception.exception.AssertException;

import javax.annotation.PostConstruct;

/**
 * 基本的异常处理, 可以捕获所有异常
 */
@Slf4j
@RestControllerAdvice
public class BasicExceptionHandler {

    private static final String PROD = "prod";

    @Value("${spring.profiles.active:default}")
    private String profile;

    @PostConstruct
    public void init() {
        log.info("基础异常处理器初始化完毕...");
    }

    @ExceptionHandler(AssertException.class)
    public R<?> handlerAssertException(AssertException e) {
        log.error("发生断言异常", e);
        return Resp.newFailed(e.getResponse().getCode(), e.getResponse().getMessage());
    }

    @ExceptionHandler(ApplicationException.class)
    public R<?> handlerApplicationException(ApplicationException e) {
        log.error("发生程序异常", e);
        if (PROD.equals(profile)) {
            return Resp.newFailed(HttpStatus.INTERNAL_ERROR, "未知异常,请联系管理员");
        }
        return Resp.newFailed(HttpStatus.INTERNAL_ERROR, e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public R<?> handlerNullPointerException(NullPointerException e) {
        log.error("发生空指针异常", e);
        if (PROD.equals(profile)) {
            return Resp.newFailed(HttpStatus.INTERNAL_ERROR, "未知异常,请联系管理员");
        }
        return Resp.newFailed(HttpStatus.INTERNAL_ERROR, "空指针异常");
    }

    @ExceptionHandler(Exception.class)
    public R<?> handlerException(Exception e) {
        log.error("发生未知异常", e);
        if (PROD.equals(profile)) {
            return Resp.newFailed(HttpStatus.INTERNAL_ERROR, "未知异常,请联系管理员");
        }
        return Resp.newFailed(HttpStatus.INTERNAL_ERROR, e.getMessage());
    }
}
