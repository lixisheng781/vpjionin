package com.vpclub.admin.service;

import com.vpclub.admin.client.SysUserInfoClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 */
@FeignClient("${feign-client.admin-server}")
public interface SysUserInfoService extends SysUserInfoClient {
}
