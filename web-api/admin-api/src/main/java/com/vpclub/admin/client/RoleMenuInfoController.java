package com.vpclub.admin.client;

import com.vpclub.admin.common.validator.ValidatorUtils;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.SysRoleEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.admin.service.SysRoleService;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
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

    @PostMapping("/save")
    public Result save(@RequestBody RoleMenuInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleMenuInfoService.save(role);
    }

    @PostMapping("/update")
    public Result update(@RequestBody RoleMenuInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleMenuInfoService.update(role);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody RoleMenuInfoEntity role){
        ValidatorUtils.validateEntity(role);
        return roleMenuInfoService.delete(role);
    }


    /**
     * 角色信息
     */
    @PostMapping ("/info")
    public Result info(@RequestBody String roleId){

        //查询角色对应的菜单
        List<Long> menuIdList = roleMenuInfoService.queryMenuIdList(Long.valueOf(roleId));

        return ResponseResult.success(menuIdList);
    }

}
