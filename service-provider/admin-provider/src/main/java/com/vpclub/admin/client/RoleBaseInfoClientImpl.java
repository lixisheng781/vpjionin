package com.vpclub.admin.client;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vpclub.admin.entity.RoleBaseInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.RoleBaseInfoService;
import com.vpclub.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  系统角色 服务治理实现类
 * </p>
 */
@Slf4j
@RestController
public class RoleBaseInfoClientImpl implements RoleBaseInfoClient {

    @Resource
    private RoleBaseInfoService roleBaseInfoService;

    @Override
    public Result queryPage(@RequestBody SysRoleParam params) { return roleBaseInfoService.queryPage(params); }

    @Override
    public Result save(@RequestBody RoleBaseInfoEntity role) {
        return roleBaseInfoService.save(role);
    }

    @Override
    public void update(@RequestBody RoleBaseInfoEntity role) {
        roleBaseInfoService.update(role);
    }

    @Override
    public Result deleteBatch(@RequestBody SysRoleParam params) {
        List<Long> roleIds  = params.getRoleIds();
        Long[] array = new Long[roleIds.size()];
        Long[] ids = roleIds.toArray(array);
        return roleBaseInfoService.deleteBatch(ids);
    }

    @Override
    public List<Long> queryRoleIdList(@RequestBody Long createdBy) { return roleBaseInfoService.queryRoleIdList(createdBy); }

    @Override
    public List<RoleBaseInfoEntity> selectByParam(@RequestBody RoleBaseInfoEntity roleBaseInfoEntity) {
        EntityWrapper<RoleBaseInfoEntity> ew = new EntityWrapper<>();

        ew.eq("del_flag", 0);

        return roleBaseInfoService.selectList(ew);
    }

    @Override
    public RoleBaseInfoEntity selectById(@RequestBody Long roleId) { return roleBaseInfoService.selectById(roleId); }
}
