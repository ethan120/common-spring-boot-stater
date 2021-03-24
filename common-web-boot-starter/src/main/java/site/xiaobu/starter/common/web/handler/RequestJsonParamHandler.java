package site.xiaobu.starter.common.web.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class RequestJsonParamHandler implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(RequestJsonParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        assert request != null;
        String conditionJson = "{}";

        RequestJsonParam annotation = methodParameter.getParameter().getAnnotation(RequestJsonParam.class);

        // 1. 获取解析器实例
        Class<? extends JsonParser> parser = annotation.parser();
        JsonParser instance = parser.newInstance();
        // 2. 返回解析结果
        return instance.parse(conditionJson);
    }
}
