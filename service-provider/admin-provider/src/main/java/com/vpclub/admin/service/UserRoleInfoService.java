package com.vpclub.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.UserRoleInfoEntity;

import java.util.List;

/**

 * 用户与角色对应关系 服务类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:24
 */
public interface UserRoleInfoService extends IService<UserRoleInfoEntity> {


	void saveOrUpdate(Long userId, List<Long> roleIdList);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
