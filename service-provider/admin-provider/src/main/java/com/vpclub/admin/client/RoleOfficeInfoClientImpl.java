package com.vpclub.admin.client;


import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.RoleOfficeInfoEntity;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.admin.service.RoleOfficeInfoService;
import com.vpclub.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleOfficeInfoClientImpl implements RoleOfficeInfoClient{

    @Autowired
    private RoleOfficeInfoService roleOfficeInfoService;

    @Override
    public Result save(@RequestBody RoleOfficeInfoEntity role) {
        return roleOfficeInfoService.save(role);
    }

    @Override
    public Result update(@RequestBody RoleOfficeInfoEntity role) {
        return roleOfficeInfoService.update(role);
    }

    @Override
    public Result delete(@RequestBody RoleOfficeInfoEntity role) {

        return roleOfficeInfoService.delete(role);
    }
}
