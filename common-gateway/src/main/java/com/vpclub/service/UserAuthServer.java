package com.vpclub.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author
 * @date 12/17
 */

@FeignClient("${feignClient.authServer}")
public interface UserAuthServer extends UserAuthClient {
}
