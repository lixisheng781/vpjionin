package com.vpclub.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.admin.entity.SysUserTokenEntity;
import org.springframework.stereotype.Repository;

/**
 * 系统用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 03-23 15:22:07
 */
@Repository
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);
	
}
