package com.vpclub.admin.service;



import com.vpclub.result.Result;
import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.SysRoleEntity;
import com.vpclub.admin.model.request.SysRoleParam;

import java.util.List;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 * 
 * @author yk
 * @since  2018-06-01
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	Result queryPage(SysRoleParam params);

	Result save(SysRoleEntity role);

	void update(SysRoleEntity role);

	Result deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createdBy);
}
