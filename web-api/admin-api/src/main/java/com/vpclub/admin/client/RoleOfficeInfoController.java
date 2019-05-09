package com.vpclub.admin.client;

import com.vpclub.admin.common.validator.ValidatorUtils;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.RoleOfficeInfoEntity;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.admin.service.RoleOfficeInfoService;
import com.vpclub.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/sys/roleOffice")
public class RoleOfficeInfoController extends AbstractController{
    @Autowired
    private RoleOfficeInfoService roleOfficeInfoService;

    @PostMapping("/save")
    public Result save(@RequestBody RoleOfficeInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleOfficeInfoService.save(role);
    }

    @PostMapping("/update")
    public Result update(@RequestBody RoleOfficeInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleOfficeInfoService.update(role);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody RoleOfficeInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleOfficeInfoService.delete(role);
    }
}
