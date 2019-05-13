package com.vpclub.admin.client;

import com.vpclub.admin.service.UserRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chentao on 2018/6/4.
 */
@RestController
public class UserRoleInfoClientImpl implements SysUserRoleClient {
    @Autowired
    private UserRoleInfoService userRoleInfoService;

    /*@Override
    public void saveOrUpdate(@RequestParam("userId") Long userId, List<Long> roleIdList,Long createdBy) {
        sysUserRoleService.saveOrUpdate(userId,roleIdList,createdBy);
    }*/

    @Override
    public List<Long> queryRoleIdList(@RequestParam("userId") Long userId) {
        return userRoleInfoService.queryRoleIdList(userId);
    }

   /* @Override
    public int deleteBatch(@RequestBody SysRoleParam params) {
        List<Long> roleIds  = params.getRoleIds();
        Long[] ids = (Long[]) roleIds.toArray();
        return sysUserRoleService.deleteBatch(ids);
    }*/
}
