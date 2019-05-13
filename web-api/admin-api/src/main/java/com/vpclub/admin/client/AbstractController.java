package com.vpclub.admin.client;


import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller公共组件
 *
 */
public abstract class AbstractController {

	@Autowired
	private RedisUtil redis;


	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SysUserInfoEntity getUser() {
		HttpServletRequest request = getRequest();
		String token = request.getHeader("token");
		SysUserInfoEntity userEntity =  redis.get(token, SysUserInfoEntity.class);
		return userEntity;
	}

	protected Long getUserId() {
		return getUser().getSysUserInfoId();
	}


	/**得到request对象
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
