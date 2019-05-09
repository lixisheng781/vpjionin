package com.vpclub.admin.client;

import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleMenuInfoClientImpl implements RoleMenuInfoClient{
    @Autowired
    private RoleMenuInfoService roleMenuInfoService;

    @Override
    public Result save(@RequestBody RoleMenuInfoEntity role) {
        return roleMenuInfoService.save(role);
    }

    @Override
    public Result update(@RequestBody RoleMenuInfoEntity role) {
        return roleMenuInfoService.update(role);
    }

    @Override
    public Result delete(@RequestBody RoleMenuInfoEntity role) {

        return roleMenuInfoService.delete(role);
    }

    @Override
    public List<Long> queryMenuIdList(@RequestParam("roleId") Long roleId) {
        return roleMenuInfoService.queryMenuIdList(roleId); }

}
