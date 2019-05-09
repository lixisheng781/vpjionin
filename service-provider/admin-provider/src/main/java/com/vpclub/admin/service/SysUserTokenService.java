package com.vpclub.admin.service;

import com.vpclub.result.Result;
import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.SysUserTokenEntity;


/**
 * 用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 03-23 15:22:07
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	Result createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	Result logout(long userId);

}
