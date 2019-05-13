package com.vpclub.admin.dao;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.admin.entity.RoleBaseInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统角色 Mapper接口
 */
@Mapper
public interface RoleBaseInfoDao extends BaseMapper<RoleBaseInfoEntity> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createId);

}
