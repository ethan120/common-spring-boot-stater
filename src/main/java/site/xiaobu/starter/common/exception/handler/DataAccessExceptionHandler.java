package site.xiaobu.starter.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.xiaobu.starter.common.common.R;
import site.xiaobu.starter.common.common.Resp;
import site.xiaobu.starter.common.exception.enums.SQLExEnum;

import javax.annotation.PostConstruct;

/**
 * @Description: 数据访问层的异常处理,主要捕获数据库操作产生的异常
 * @Author: zhanghuan
 * @Date: 2020-12-28 16:53
 * @Version: V1.0
 */
@RestControllerAdvice
public class DataAccessExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(DataAccessExceptionHandler.class);

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
        return Resp.fail(code, exEnum.getMessage());
    }
}
