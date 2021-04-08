package site.xiaobu.starter.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.xiaobu.starter.common.base.R;
import site.xiaobu.starter.common.base.Resp;
import site.xiaobu.starter.common.exception.enums.ServletExEnum;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;

/**
 * Servlet层的异常处理
 */
@Slf4j
@RestControllerAdvice
public class ServletExceptionHandler {
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
    @ExceptionHandler({ServletException.class})
    public R<?> handleServletException(ServletException e) {
        log.info("发生Servlet异常", e);
        ServletExEnum exEnum = null;
        try {
            exEnum = ServletExEnum.valueOf(e.getClass().getSimpleName());
        } catch (IllegalArgumentException ignore) {
            exEnum = ServletExEnum.ServletException;
        }
        int code = exEnum.getCode();
        return Resp.newFailed(code, exEnum.getMessage());
    }
}
