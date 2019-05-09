package com.vpclub.admin.service;

import com.vpclub.admin.client.SysUserClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 */
@FeignClient("${feign-client.admin-server}")
public interface SysUserService  extends SysUserClient {
}
