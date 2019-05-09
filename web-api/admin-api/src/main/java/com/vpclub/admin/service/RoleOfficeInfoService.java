package com.vpclub.admin.service;

import com.vpclub.admin.client.RoleOfficeInfoClient;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("${feign-client.admin-server}")
public interface RoleOfficeInfoService extends RoleOfficeInfoClient {
}
