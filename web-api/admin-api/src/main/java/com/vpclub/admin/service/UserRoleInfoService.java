package com.vpclub.admin.service;

import com.vpclub.admin.client.SysUserRoleClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by chentao on 2018/5/31.
 */
@FeignClient("${feign-client.admin-server}")
public interface UserRoleInfoService extends SysUserRoleClient {
}
