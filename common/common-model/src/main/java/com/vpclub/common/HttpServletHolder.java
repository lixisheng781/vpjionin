package com.vpclub.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class HttpServletHolder {

    private static MultipartResolver multipartResolver;

    @Autowired
    public void setMultipartResolver(MultipartResolver multipartResolver) {
        HttpServletHolder.multipartResolver = multipartResolver;
    }

    public static HttpServletRequest getRequest(){
        HttpServletRequest req = checkMultipart(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return req;
    }

    public static HttpServletResponse getResponse(){
        HttpServletResponse resp = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
        return resp;
    }


    /**
     * 处理文件上传，form表单的enctype类型为”multipart/form-data”，参数无法获取问题
     */
    private static HttpServletRequest checkMultipart(HttpServletRequest request) throws MultipartException {
        if (multipartResolver != null && multipartResolver.isMultipart(request)) {
            if (WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class) != null) {
                log.debug("Request is already a MultipartHttpServletRequest - if not in a forward,this typically results from an additional MultipartFilter in web.xml");
            } else if (hasMultipartException(request) ) {
                log.debug("Multipart resolution failed for current request before - skipping re-resolution for undisturbed error rendering");
            } else {
                try {
                    return  multipartResolver.resolveMultipart(request);
                } catch (MultipartException ex) {
                    if (request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE) != null) {
                        log.debug("Multipart resolution failed for error dispatch", ex);
                    } else {
                        throw ex;
                    }
                }
            }
        }
        // If not returned before: return original request.
        return request;
    }

    /**
     * Check "javax.servlet.error.exception" attribute for a multipart exception.
     */
    private static boolean hasMultipartException(HttpServletRequest request) {
        Throwable error = (Throwable) request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
        while (error != null) {
            if (error instanceof MultipartException) {
                return true;
            }
            error = error.getCause();
        }
        return false;
    }


}
