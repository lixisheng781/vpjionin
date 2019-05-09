package com.vpclub.service;

import com.vpclub.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author
 * @date 12/17
 */
@RequestMapping("/userAuthClient")
public interface UserAuthClient {

    /***
     * 校验Toekn
     * @param token 密钥
     * @param userCode 用户编码
     * @param userAgent 终端类型(WEB:PC端，WEIXIN:微信端)
     * @return 结果封装
     */
    @RequestMapping(value = "/checkToken", method = RequestMethod.GET)
    Result checkToken(@RequestParam("token") String token, @RequestParam("userCode") String userCode, @RequestParam("userAgent") String userAgent);

    /***
     * 授权登录
     * @param authAccount
     * @param authPassword
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "authLogin", method = RequestMethod.GET)
    Result authLogin(@RequestParam("authAccount") String authAccount, @RequestParam("authPassword") String authPassword, @RequestParam("account") String account, @RequestParam("password") String password);
}
