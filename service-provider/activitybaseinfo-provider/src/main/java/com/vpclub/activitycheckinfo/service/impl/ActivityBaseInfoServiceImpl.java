package com.vpclub.activitycheckinfo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.activitybaseinfo.entity.ActivityBaseInfoEntity;
import com.vpclub.activitycheckinfo.dao.ActivityBaseInfoDao;
import com.vpclub.activitycheckinfo.service.ActivityBaseInfoService;
import com.vpclub.admin.utils.PageUtils;
import com.vpclub.admin.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("activityBaseInfoService")
public class ActivityBaseInfoServiceImpl extends ServiceImpl<ActivityBaseInfoDao, ActivityBaseInfoEntity>
		implements ActivityBaseInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<ActivityBaseInfoEntity> page = this.selectPage(new Query<ActivityBaseInfoEntity>(params).getPage(),
				new EntityWrapper<ActivityBaseInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public ActivityBaseInfoEntity isSignup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.baseMapper.isSignup(map);
	}

	@Override
	public boolean updateApply(Long activityId) {
		return retBool(this.baseMapper.updateApply(activityId));
	}

}
