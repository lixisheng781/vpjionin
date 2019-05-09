package com.vpclub.admin.service;

import com.vpclub.admin.client.SysUserTokenClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 */
@FeignClient("${feign-client.admin-server}")
public interface SysUserTokenService extends SysUserTokenClient {
}
