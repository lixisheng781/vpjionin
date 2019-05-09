package com.vpclub.resolver;


import com.vpclub.constant.AuthConstant;
import com.vpclub.annotation.LoginUserWxSessionKey;
import com.vpclub.auth.TokenPrincipal;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 将含有 @LoginUserId 注解的参数注入
 */
public class LoginUserWxSessionKeyArgResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(String.class) && parameter.hasParameterAnnotation(LoginUserWxSessionKey.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object temp =  webRequest.getAttribute(AuthConstant.CURRENT_TOKEN, RequestAttributes.SCOPE_REQUEST);
        if (temp == null){
            throw new ArgumentResolverException("没有access_token消息头,无法解析wxSessionKey参数!!!");
        }

        TokenPrincipal tokenPrincipal= (TokenPrincipal) temp;
        if (tokenPrincipal.getSessionKey() != null) {
            String paramName = parameter.getParameterName();
            mavContainer.setBindingDisabled(paramName);
            return tokenPrincipal.getSessionKey();
        }
        throw new ArgumentResolverException("无法从token中，解析出wxSessionKey参数!!!");
    }
}
