package com.vpclub.resolver;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpclub.annotation.JsonBodyParam;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 *   直接处理json根参数
 *   例如 {"name":"张三"}中name参数
 */
public class JsonBodyParamArgResolver implements HandlerMethodArgumentResolver {

    private static final String JSON_REQUEST_BODY = "_JSON_BODY";

    ObjectMapper objectMapper = new ObjectMapper();

    //判断是否支持要转换的参数类型
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(JsonBodyParam.class);
    }

    //当支持后进行相应的转换
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        JSONObject jsonObject = getRequestBody(webRequest);
        JsonBodyParam jsonParam = parameter.getParameterAnnotation(JsonBodyParam.class);
        Object val = jsonObject.getObject(jsonParam.value(),parameter.getParameterType());
        if (jsonParam.required() && val == null) {
            throw new ArgumentResolverException("参数"+jsonParam.value()+"缺失");
        }
        return val;
    }

    private JSONObject getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        JSONObject jsonObject = (JSONObject) servletRequest.getAttribute(JSON_REQUEST_BODY);
        if (jsonObject == null) {
            try {
                String json = IOUtils.toString(servletRequest.getInputStream());
                jsonObject = JSON.parseObject(json);
                servletRequest.setAttribute(JSON_REQUEST_BODY, jsonObject);
            } catch (IOException e) {
                throw new ArgumentResolverException(e);
            }
        }
        return jsonObject;
    }

}
