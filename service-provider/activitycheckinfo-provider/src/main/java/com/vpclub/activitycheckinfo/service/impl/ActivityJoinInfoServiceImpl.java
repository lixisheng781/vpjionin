package com.vpclub.activitycheckinfo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.activitycheckinfo.dao.ActivityJoinInfoDao;
import com.vpclub.activitycheckinfo.entity.ActivityJoinInfoEntity;
import com.vpclub.activitycheckinfo.service.ActivityJoinInfoService;
import com.vpclub.admin.utils.PageUtils;
import com.vpclub.admin.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("activityJoinInfoService")
public class ActivityJoinInfoServiceImpl extends ServiceImpl<ActivityJoinInfoDao, ActivityJoinInfoEntity>
		implements ActivityJoinInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<ActivityJoinInfoEntity> page = this.selectPage(new Query<ActivityJoinInfoEntity>(params).getPage(),
				new EntityWrapper<ActivityJoinInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer isenlist(Long activityId, Long userId) {
		// TODO Auto-generated method stub
		return this.baseMapper.isenlist(activityId, userId);
	}

}
