package com.vpclub.admin.client;

import com.vpclub.admin.common.validator.ValidatorUtils;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/sys/roleMenu")
public class RoleMenuInfoController extends AbstractController {

    @Autowired
    private RoleMenuInfoService roleMenuInfoService;


    @PostMapping("/delete")
    public Result delete(@RequestBody RoleMenuInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleMenuInfoService.delete(role);
    }

}
