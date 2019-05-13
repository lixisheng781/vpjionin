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

    void saveOrUpdate(Long roleId, List<Long> mbiIdList);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(Long[] roleIds);
}
