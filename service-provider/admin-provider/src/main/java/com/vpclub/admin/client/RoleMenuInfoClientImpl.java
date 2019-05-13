package com.vpclub.admin.client;

import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleMenuInfoClientImpl implements RoleMenuInfoClient {
    @Autowired
    private RoleMenuInfoService roleMenuInfoService;

    @Override
    public List<Long> queryMenuIdList(@RequestParam("roleId") Long roleId) {
        return roleMenuInfoService.queryMenuIdList(roleId);
    }

    @Override
    public int deleteBatch(@RequestBody SysRoleParam params) {
        List<Long> roleIds  = params.getRoleIds();
        Long[] ids = (Long[]) roleIds.toArray();
        return roleMenuInfoService.deleteBatch(ids);
    }
}
