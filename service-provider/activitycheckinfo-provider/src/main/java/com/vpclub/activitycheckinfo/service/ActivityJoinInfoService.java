package com.vpclub.activitycheckinfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.vpclub.activitycheckinfo.entity.ActivityJoinInfoEntity;
import com.vpclub.admin.utils.PageUtils;

import java.util.Map;

/**
 * 活动人员报名签到签退表#20161213#
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 09:46:53
 */
public interface ActivityJoinInfoService extends IService<ActivityJoinInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	// 该学员是否报过名
	Integer isenlist(Long activityId, Long userId);
}
