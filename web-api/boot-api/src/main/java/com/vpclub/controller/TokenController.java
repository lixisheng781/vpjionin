package com.vpclub.controller;

import com.vpclub.util.IpUtil;
import com.vpclub.constant.CacheConstant;
import com.vpclub.annotation.Unlogin;
import com.vpclub.auth.CacheUtil;
import com.vpclub.auth.TokenPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


/**
 * 仅仅为了测试
 */
@RestController
@Slf4j
public class TokenController {

    @Unlogin
    @GetMapping("/getToken")
    public Object fileUpload(HttpServletRequest request, @RequestParam("userId")Long userId){
        String token = UUID.randomUUID().toString();
        TokenPrincipal tokenPrincipal = new TokenPrincipal();
        tokenPrincipal.setUserId(userId);
        tokenPrincipal.setOpenid("test-openid");
        tokenPrincipal.setUserIp(IpUtil.getRemoteAddr(request));
        CacheUtil.put(CacheConstant.USER_TOKEN_CACHE_NAMESPACE, token, tokenPrincipal);
        return token;

    }











}
