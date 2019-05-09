package com.vpclub.activitycheckinfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.vpclub.activitybaseinfo.entity.ActivityBaseInfoEntity;
import com.vpclub.admin.utils.PageUtils;

import java.util.Map;

/**
 * 活动信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 10:41:28
 */
public interface ActivityBaseInfoService extends IService<ActivityBaseInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 判读活动是否能报名
	 */
	ActivityBaseInfoEntity isSignup(Map<String, Object> map);


	boolean updateApply(Long activityId);
}
