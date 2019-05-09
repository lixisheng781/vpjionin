package com.vpclub.activitycheckinfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.activitycheckinfo.entity.ActivityJoinInfoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 活动人员报名签到签退表#20161213#
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 09:46:53
 */
public interface ActivityJoinInfoDao extends BaseMapper<ActivityJoinInfoEntity> {

	Integer isenlist(@Param("abiId") Long abiId, @Param("amiId") Long amiId);

}
