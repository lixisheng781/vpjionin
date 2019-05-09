package com.vpclub.activitycheckinfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.activitybaseinfo.entity.ActivityBaseInfoEntity;

import java.util.Map;

/**
 * 活动信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 10:41:28
 */
public interface ActivityBaseInfoDao extends BaseMapper<ActivityBaseInfoEntity> {

	/**
	 * 判读活动是否能报名
	 */
	ActivityBaseInfoEntity isSignup(Map<String, Object> map);

	int updateApply(Long activityId);

}
