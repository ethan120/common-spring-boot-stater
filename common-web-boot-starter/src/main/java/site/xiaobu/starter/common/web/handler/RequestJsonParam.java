package site.xiaobu.starter.common.web.handler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestJsonParam {
    /**
     * Json参数的请求字段
     */
    String name() default "condition";

    /**
     * 指明Json参数的解析器类
     */
    Class<? extends JsonParser> parser();
}
