package com.vpclub.admin.client;



import com.vpclub.admin.entity.SysUserTokenEntity;
import com.vpclub.admin.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 *
 */
@RestController
public class ShiroClientImpl implements ShiroClient {
    @Autowired
    private ShiroService shiroService;

    @Override
    public Set<String> getUserPermissions( long userId) {
        return shiroService.getUserPermissions(userId);
    }

    @Override
    public SysUserTokenEntity queryByToken(@RequestParam("token") String token) {
        return shiroService.queryByToken(token);
    }
}
