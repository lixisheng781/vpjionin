package com.vpclub.admin.service;

import com.vpclub.admin.client.SysMenuClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 系统菜单 服务类
 */
@FeignClient("${feign-client.admin-server}")
public interface SysMenuService extends SysMenuClient {
}
