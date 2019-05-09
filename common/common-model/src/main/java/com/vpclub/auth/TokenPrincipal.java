package com.vpclub.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenPrincipal implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户openid
     */
    private String openid;

    /**
     * 小程序登录的临时code
     */
    private String jsCode;


    private String sessionKey;

    /**
     * 登录时ip地址
     */
    private String userIp;

    /**
     * 用户角色
     */
    private String role;


}
