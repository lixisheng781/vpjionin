package com.vpclub.auth;

import com.vpclub.result.ResponseResult;
import com.vpclub.result.ResultCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpclub.constant.AuthConstant;
import com.vpclub.constant.CacheConstant;
import com.vpclub.annotation.Unlogin;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Token验证过滤器,判断是否已登录
 */
public class AuthInterceptor implements HandlerInterceptor {


    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //放过error
        if (request.getRequestURI().equals("/error")){
            return true;
        }

        if (request.getRequestURI().startsWith("/admin")){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断类中接口是否需要登录
        if (method.isAnnotationPresent(Unlogin.class)){
            return true;
        }

        //Unlogin methodAnnotation = method.getAnnotation(Unlogin.class);
        String accessToken = request.getHeader("access_token");
        if (StringUtils.isBlank(accessToken)){
            writeResponseData(response, ResponseResult.failResult(ResultCodeEnum.UNAUTHORIZED, "没有access_token消息头，请重新登录"));
            return false;
        }

        String userIp = IpUtil.getRemoteAddr(request);
        //TokenPrincipal tokenPrincipal = TokenUtils.unsign(accessToken, TokenPrincipal.class)
        TokenPrincipal tokenPrincipal =  CacheUtil.<TokenPrincipal>get(CacheConstant.USER_TOKEN_CACHE_NAMESPACE,accessToken);
        if (tokenPrincipal == null )  {
            writeResponseData(response, ResponseResult.failResult(ResultCodeEnum.UNAUTHORIZED,"无效或过期的token，请重新登录"));
            return false;
        }else if (!userIp.equals(tokenPrincipal.getUserIp())){
            writeResponseData(response, ResponseResult.failResult(ResultCodeEnum.UNAUTHORIZED,"客户端ip地址已改变，请重新登录"));
            return false;
        }else{
            request.setAttribute(AuthConstant.CURRENT_TOKEN, tokenPrincipal);
        }
        return true;
    }


    private void writeResponseData (HttpServletResponse response, Object data)throws Exception{
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }


    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
