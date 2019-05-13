package com.vpclub.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.UserRoleInfoDao;
import com.vpclub.admin.entity.UserRoleInfoEntity;
import com.vpclub.admin.service.UserRoleInfoService;
import com.vpclub.admin.utils.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleInfoServiceImpl extends ServiceImpl<UserRoleInfoDao, UserRoleInfoEntity> implements UserRoleInfoService {

	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		//先删除用户与角色关系
		this.deleteByMap(new MapUtils().put("user_id", userId));

		if(roleIdList == null || roleIdList.size() == 0){
			return ;
		}

		//保存用户与角色关系
		List<UserRoleInfoEntity> list = new ArrayList<>(roleIdList.size());
		for(Long roleId : roleIdList){
			UserRoleInfoEntity sysUserRoleEntity = new UserRoleInfoEntity();
			sysUserRoleEntity.setUserId(userId);
			sysUserRoleEntity.setRoleId(roleId);
			list.add(sysUserRoleEntity);
		}
		this.insertBatch(list);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return baseMapper.queryRoleIdList(userId);
	}

	@Override
	public int deleteBatch(Long[] roleIds){
		return baseMapper.deleteBatch(roleIds);
	}
}
