package com.vpclub.admin.service;

import com.vpclub.admin.client.ShiroClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 */
@FeignClient("${feign-client.admin-server}")
public interface ShiroService extends ShiroClient {
}
