package com.vpclub.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统角色权限范围隶属 Mapper接口
 */
@Mapper
public interface RoleMenuInfoDao extends BaseMapper<RoleMenuInfoEntity>{

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);
}
