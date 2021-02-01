package site.xiaobu.starter.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.xiaobu.starter.common.base.R;
import site.xiaobu.starter.common.base.Resp;
import site.xiaobu.starter.common.exception.exception.ApplicationException;

import javax.annotation.PostConstruct;

/**
 * @Description: 基本的异常处理, 可以捕获所有异常
 * @Author: zhanghuan
 * @Date: 2020-12-28 17:32
 * @Version: V1.0
 */
@RestControllerAdvice
public class BasicExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BasicExceptionHandler.class);

    private static final String PROD = "prod";

    @Value("${spring.profiles.active:default}")
    private String profile;

    @PostConstruct
    public void init() {
        log.info("基础异常处理器初始化完毕...");
    }

    @ExceptionHandler(ApplicationException.class)
    public R<?> handlerNullPointerException(ApplicationException e) {
        log.error("发生程序异常", e);
        return Resp.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public R<?> handlerNullPointerException(NullPointerException e) {
        log.error("发生空指针异常", e);
        if (PROD.equals(profile)) {
            return Resp.fail(500, "未知异常,请联系管理员");
        }
        return Resp.fail(500, "空指针异常");
    }

    @ExceptionHandler(Exception.class)
    public R<?> handlerException(Exception e) {
        log.error("发生未知异常", e);
        if (PROD.equals(profile)) {
            return Resp.fail(500, "未知异常,请联系管理员");
        }
        return Resp.fail(500, e.getMessage());
    }
}
