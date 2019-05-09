package com.vpclub.admin.model.response;

import com.vpclub.admin.entity.SysUserEntity;
import lombok.Data;

import java.util.Set;

@Data
public class LoginResponse {
    private SysUserEntity user;
    private String token;
    private Set<String> permissions;
}
