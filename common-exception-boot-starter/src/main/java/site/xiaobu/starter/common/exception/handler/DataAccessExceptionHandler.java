package site.xiaobu.starter.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.xiaobu.starter.common.base.R;
import site.xiaobu.starter.common.base.Resp;
import site.xiaobu.starter.common.exception.enums.SQLExEnum;

import javax.annotation.PostConstruct;

/**
 * 数据访问层的异常处理,主要捕获数据库操作产生的异常
 */
@Slf4j
@RestControllerAdvice
public class DataAccessExceptionHandler {
    @PostConstruct
    public void init() {
        log.info("数据访问异常处理器初始化完毕...");
    }

    /**
     * 数据访问异常，数据库异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = DataAccessException.class)
    public R<?> handleDataAccessException(DataAccessException e) {
        log.error("发生数据访问异常", e);
        SQLExEnum exEnum = SQLExEnum.valueOf(e.getClass().getSimpleName());
        int code = exEnum.getCode();
        return Resp.newFailed(code, exEnum.getMessage());
    }
}
