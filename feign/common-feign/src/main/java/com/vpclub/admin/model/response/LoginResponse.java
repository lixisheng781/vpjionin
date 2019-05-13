package com.vpclub.admin.model.response;

import com.vpclub.admin.entity.SysUserInfoEntity;
import lombok.Data;

import java.util.Set;

@Data
public class LoginResponse {
    private SysUserInfoEntity user;
    private String token;
    private Set<String> permissions;
}
