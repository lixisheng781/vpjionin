package com.vpclub.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vpclub.admin.entity.SysUserInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:34:11
 */
@Repository
public interface SysUserInfoDao extends BaseMapper<SysUserInfoEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserInfoEntity queryByUserName(String username);

	void deleteByUserIds(List<Long> ids);

	/**
	 * 添加新用户
	 */
	void addUser(SysUserInfoEntity userEntity);

	/**
	 * 查询主账号下所有子账号
	 */
	List<SysUserInfoEntity> queryByParentId(String parentId);

	/**
	 * 分页查询用户列表
	 */
	List<SysUserInfoEntity> page(Pagination page);
}
