package com.vpclub.resolver;


import com.alibaba.fastjson.JSON;
import com.vpclub.annotation.JsonBody;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 将含有 @JsonBody 注解的参数注入
 */
public class JsonBodyArgResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return  parameter.hasParameterAnnotation(JsonBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //parameter.get
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        Object val = null;
        try {
            String json = IOUtils.toString(servletRequest.getInputStream());
            val = JSON.parseObject(json, parameter.getParameterType());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (val == null) {
                throw new ArgumentResolverException("参数"+parameter.getParameterName()+"解析失败");
            }
            return val;
        }
    }
}
