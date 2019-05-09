package com.vpclub.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionResolver extends ResponseEntityExceptionHandler  {


    /**
     * 处理controller执行之前，不支持该（get或post）方法
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.paramError("不支持"+httpServletRequest.getMethod()+"请求"), status);
    }

    /**
     * 处理controller执行之前，缺少header或Cookie参数
     */
    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.paramError(ex.getMessage()), status);
    }

    /**
     * 处理controller执行之前，缺少路径参数异常
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.paramError("缺少"+ex.getVariableName()+"路径参数."), status);
    }

    /**
     * 处理controller执行之前，缺少请求参数异常
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.paramError("缺少"+ex.getParameterName()+"请求参数."), status);
    }

    /**
     * 处理controller执行之前，缺少body参数异常
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.paramError("缺少body参数."), status);
    }

    /**
     * 处理controller执行之前，参数类型转换异常
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException)ex;
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.paramError("参数"+exception.getName()+",类型转换失败."), status);
    }



    /**
     * 处理controller执行之前，其他异常
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest httpServletRequest = ((ServletWebRequest)request).getNativeRequest(HttpServletRequest.class);
        log(httpServletRequest, ex);
        return new ResponseEntity<Object>(ResponseResult.serverError(), status);
    }


    /*-----------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 处理在controller中的异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        log(request,e);
        return ResponseResult.serverError();
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return ResponseResult.failResult(520,"数据库中已存在该记录");
    }




    private void log(HttpServletRequest request, Exception ex) {
        logger.error("************************异常开始*******************************");
        logger.error(ex);
        logger.error("请求uri地址：" + request.getRequestURI());
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            logger.error("请求参数---> " + name + ": " + request.getParameter(name));
        }
        ex.printStackTrace();
        logger.error("************************异常结束*******************************");
    }




    @Slf4j
    public static class Result<T> {
        /***
         * 状态码
         */
        private int code;
        /***
         * 状态描述
         */
        private String msg;
        /***
         * 响应结果内容
         */
        private T data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Result result = (Result) o;
            return this.code == result.code;
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }
    }

    @Slf4j
    public static class ResponseResult{

        /***
         * 失败,带状态及描述
         */
        public static Result failResult(int code, String msg) {
            Result result = new Result();
            result.setCode(code);
            result.setMsg(msg);
            return result;
        }

        /***
         * 失败,带状态、描述、内容
         */
        public static <T> Result<T> failResult(int code, String msg, T data) {
            Result result = new Result();
            result.setCode(code);
            result.setMsg(msg);
            result.setData(data);
            return result;
        }


        public static Result serverError() {
            Result result = new Result();
            result.setCode(500);
            result.setMsg("服务异常,请联系管理员");
            return result;
        }

        public static Result paramError(String msg) {
            Result result = new Result();
            result.setCode(510);
            result.setMsg(msg);
            return result;
        }

    }

}
