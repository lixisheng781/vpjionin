package com.vpclub.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.RoleBaseInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.result.Result;

import java.util.List;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 * 
 * @author yk
 * @since  2018-06-01
 */
public interface RoleBaseInfoService extends IService<RoleBaseInfoEntity> {

	Result queryPage(SysRoleParam params);

	Result save(RoleBaseInfoEntity role);

	void update(RoleBaseInfoEntity role);

	Result deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createId);
}
