package com.vpclub.admin.client;

import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.admin.service.SysUserInfoService;
import com.vpclub.result.Result;
import com.vpclub.admin.model.request.SysUserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chentao on 2018/5/31.
 */
@RestController
public class SysUserInfoClientImpl implements SysUserInfoClient {
    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Override
    public SysUserInfoEntity queryByPhone(@RequestBody SysUserInfoEntity mobileuser) {
        return sysUserInfoService.queryByPhone(mobileuser);
    }

    @Override
    public Result queryPage(@RequestBody SysUserParam params) {
        return sysUserInfoService.queryPage(params);
    }

    @Override
    public Result page(@RequestBody SysUserParam params) {
        return sysUserInfoService.page(params);
    }

    @Override
    public List<String> queryAllPerms(@RequestParam Long userId) {
        return sysUserInfoService.queryAllPerms(userId);
    }

    @Override
    public List<Long> queryAllMenuId(@RequestParam Long userId) {
        return sysUserInfoService.queryAllMenuId(userId);
    }

    @Override

    public SysUserInfoEntity queryByUserName(@RequestParam String userName) {
        return sysUserInfoService.queryByUserName(userName);
    }

    @Override
    public Result save(@RequestBody SysUserInfoEntity user) {
        return sysUserInfoService.save(user);
    }

    @Override
    public void update(@RequestBody SysUserInfoEntity user) {
        sysUserInfoService.update(user);
    }

    @Override
    public void deleteBatch(@RequestParam Long[] userIds) {
        sysUserInfoService.deleteBatch(userIds);
    }

    @Override
    public boolean updatePassword(@RequestParam Long userId, String password,  String newPassword) {
        return sysUserInfoService.updatePassword(userId,password,newPassword);
    }

    @Override
    public void deleteByUserId(@RequestBody SysUserParam params) {
        sysUserInfoService.deleteByUserId(params.getIdList());
    }

    @Override
    public void register(@RequestBody SysUserInfoEntity registerUser) {
        sysUserInfoService.register(registerUser);
    }

    @Override
    public SysUserInfoEntity selectById(@RequestParam("userId") Long userId) {
        return sysUserInfoService.selectById(userId);
    }
}
