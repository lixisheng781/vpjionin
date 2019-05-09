package com.vpclub.activitycheckinfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.vpclub.activitycheckinfo.entity.ActivityMemberInfoEntity;
import com.vpclub.admin.utils.PageUtils;

import java.util.Map;

/**
 * 活动人员信息表#20161213#
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 10:41:26
 */
public interface ActivityMemberInfoService extends IService<ActivityMemberInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

