package com.vpclub.admin.service;

import com.vpclub.admin.client.RoleMenuInfoClient;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("${feign-client.admin-server}")
public interface RoleMenuInfoService extends RoleMenuInfoClient {
}
