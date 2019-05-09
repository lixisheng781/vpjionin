package com.vpclub.admin.service;

import com.vpclub.admin.client.SysRoleClient;
import org.springframework.cloud.netflix.feign.FeignClient;


/**
 * 系统角色 服务类
 */
@FeignClient("${feign-client.admin-server}")
public interface SysRoleService extends SysRoleClient {
}
