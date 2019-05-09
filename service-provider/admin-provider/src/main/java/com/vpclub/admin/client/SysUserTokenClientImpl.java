package com.vpclub.admin.client;

import com.vpclub.result.Result;
import com.vpclub.admin.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chentao on 2018/6/4.
 */
@RestController
public class SysUserTokenClientImpl implements SysUserTokenClient {
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Override
    public Result createToken(long userId) {
        return sysUserTokenService.createToken(userId);
    }

    @Override
    public Result logout(long userId) {
        return sysUserTokenService.logout(userId);
    }
}
