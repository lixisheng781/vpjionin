package com.vpclub.admin.service;



import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.result.Result;
import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.model.request.SysUserParam;

import java.util.List;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserInfoService extends IService<SysUserInfoEntity> {

	Result queryPage(SysUserParam params);

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

	/**
	 * 保存用户
	 */
	Result save(SysUserInfoEntity user);
	
	/**
	 * 修改用户
	 */
	void update(SysUserInfoEntity user);

	/**
	 * 删除用户
	 */
	void deleteBatch(Long[] userIds);

	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);

	/***
	 * 更新删除标记，0表示删除
	 */
	void deleteByUserId(List<Long> ids);

	void register(SysUserInfoEntity registerUser);

	SysUserInfoEntity queryByPhone(SysUserInfoEntity mobileuser);

	/**
	 * 分页查询用户列表
	 */
	Result page(SysUserParam param);
}
