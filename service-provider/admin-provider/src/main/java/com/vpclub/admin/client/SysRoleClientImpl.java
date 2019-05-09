package com.vpclub.admin.client;

import com.vpclub.result.Result;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vpclub.admin.entity.SysRoleEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  系统角色 服务治理实现类
 * </p>
 * @author yk
 * @since  2018-06-01
 */
@Slf4j
@RestController
public class SysRoleClientImpl implements SysRoleClient {

    @Resource
    private SysRoleService sysRoleService;

    @Override
    public Result queryPage(@RequestBody SysRoleParam params) { return sysRoleService.queryPage(params); }

    @Override
    public Result save(@RequestBody SysRoleEntity role) {
        return sysRoleService.save(role);
    }

    @Override
    public void update(@RequestBody SysRoleEntity role) {
        sysRoleService.update(role);
    }

    @Override
    public Result deleteBatch(@RequestBody SysRoleParam params) {
        List<Long> roleIds  = params.getRoleIds();
        Long[] array = new Long[roleIds.size()];
        Long[] ids = roleIds.toArray(array);
        return sysRoleService.deleteBatch(ids);
    }

    @Override
    public List<Long> queryRoleIdList(@RequestBody Long createdBy) { return sysRoleService.queryRoleIdList(createdBy); }

    @Override
    public List<SysRoleEntity> selectByParam(@RequestBody SysRoleEntity sysRoleEntity) {
        EntityWrapper<SysRoleEntity> ew = new EntityWrapper<>();

        ew.eq("deleted", "1");

        return sysRoleService.selectList(ew);
    }

    @Override
    public SysRoleEntity selectById(@RequestBody Long roleId) { return sysRoleService.selectById(roleId); }
}
