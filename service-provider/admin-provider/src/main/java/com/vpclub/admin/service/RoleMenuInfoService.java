package com.vpclub.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.result.Result;

import java.util.List;

/**
 * <p>
 * 系统角色权限范围隶属 服务类
 * </p>
 *
 * @author yk
 * @since  2018-06-01
 */
public interface RoleMenuInfoService extends IService<RoleMenuInfoEntity> {
    Result save(RoleMenuInfoEntity role);

    Result update(RoleMenuInfoEntity role);

    Result delete(RoleMenuInfoEntity role);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);
}
