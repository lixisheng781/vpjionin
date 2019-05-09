package com.vpclub.resolver;


import com.vpclub.annotation.LoginClientIp;
import com.vpclub.auth.IpUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 将含有 @LoginUserId 注解的参数注入
 */
public class LoginClientIpArgResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(String.class) && parameter.hasParameterAnnotation(LoginClientIp.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String userIp = IpUtil.getRemoteAddr(request);
        if (userIp != null ) {
            String paramName = parameter.getParameterName();
            mavContainer.setBindingDisabled(paramName);
            return userIp;
        }
        throw new ArgumentResolverException("解析clientIp失败");
    }
}
