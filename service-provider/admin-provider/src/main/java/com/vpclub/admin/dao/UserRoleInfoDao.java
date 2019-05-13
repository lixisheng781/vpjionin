package com.vpclub.admin.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.admin.entity.UserRoleInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:34:46
 */
@Mapper
public interface UserRoleInfoDao extends BaseMapper<UserRoleInfoEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);


    /**
     * 根据用户ID，获取角色列表
     */
    List<UserRoleInfoEntity> queryRoleList(Long userId);


    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(Long[] roleIds);
}
