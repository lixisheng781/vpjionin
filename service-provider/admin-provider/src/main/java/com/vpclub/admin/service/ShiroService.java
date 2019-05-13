package com.vpclub.admin.service;

import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.admin.entity.SysUserTokenEntity;
import java.util.Set;

/**
 * shiro相关接口
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserInfoEntity queryUser(Long userId);
}
