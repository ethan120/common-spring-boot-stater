package site.xiaobu.starter.common.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.xiaobu.starter.common.common.CommonResponse;
import site.xiaobu.starter.common.common.Resp;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: 数据校验方面的异常处理
 * @Author: zhanghuan
 * @Date: 2020-12-28 16:53
 * @Version: V1.0
 */
@RestControllerAdvice
public class ValidationExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ValidationExceptionHandler.class);

    @PostConstruct
    public void init() {
        log.info("数据校验异常处理初始化完毕...");
    }

    /**
     * 参数校验异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public CommonResponse<?> handleValidException(Exception e) {
        log.error("发生对象数据验证异常", e);
        BindingResult bindingResult = null;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        }
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        assert bindingResult != null;
        return wrapperBindingResult(bindingResult);
    }

    /**
     * 方法参数,方法返回值校验异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResponse<?> handleMethodValidException(ConstraintViolationException e) throws JsonProcessingException {
        log.error("发生方法数据验证异常", e);
        List<Object> listRes = new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {
            Map<String, Object> map = new TreeMap<>();
            String className = constraintViolation.getRootBeanClass().getName();
            Path path = constraintViolation.getPropertyPath();
            map.put("methodName", className + "." + path.toString().split("\\.")[0]);
            map.put("fieldOfValidation", path.toString().split("\\.")[1]);
            map.put("validationRuleDescription", constraintViolation.getMessage());
            map.put("invalidValue", constraintViolation.getInvalidValue());
            listRes.add(map);
        });
        return Resp.fail(400, "参数校验发生异常", listRes);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * 封装绑定异常结果
     *
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private CommonResponse<?> wrapperBindingResult(BindingResult bindingResult) {
        List<Object> listRes = new ArrayList<>();
        for (ObjectError error : bindingResult.getAllErrors()) {
            Map<String, Object> map = new TreeMap<>();
            if (error instanceof FieldError) {
                map.put("fieldOfValidation", ((FieldError) error).getField());
                map.put("invalidValue", ((FieldError) error).getRejectedValue());
            }
            Object target = bindingResult.getTarget();
            if (target != null) {
                map.put("objectOfValidation", target.getClass().getName());
            }
            map.put("validationRuleDescription", error.getDefaultMessage());
            listRes.add(map);
        }
        return Resp.fail(400, "参数校验发生异常", listRes);
    }

}
