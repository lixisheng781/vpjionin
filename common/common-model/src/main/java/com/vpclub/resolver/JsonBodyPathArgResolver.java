package com.vpclub.resolver;


import com.jayway.jsonpath.JsonPath;
import com.vpclub.annotation.JsonBodyPath;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JsonBodyPathArgResolver implements HandlerMethodArgumentResolver {

    private static final String JSON_REQUEST_BODY = "_JSON_BODY";

    //判断是否支持要转换的参数类型
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(JsonBodyPath.class);
    }

    //当支持后进行相应的转换
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String body = getRequestBody(webRequest);
        JsonBodyPath jsonParam = parameter.getParameterAnnotation(JsonBodyPath.class);
        Object val = null;
        try {
            String path = jsonParam.value();
            val = JsonPath.read(body, path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jsonParam.required() && val == null) {
                throw new ArgumentResolverException("参数的路径"+jsonParam.value()+"解析失败");
            }
            return val;
        }

    }

    private String getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String jsonBody = (String) servletRequest.getAttribute(JSON_REQUEST_BODY);
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getInputStream());
                servletRequest.setAttribute(JSON_REQUEST_BODY, jsonBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonBody;
    }

}
