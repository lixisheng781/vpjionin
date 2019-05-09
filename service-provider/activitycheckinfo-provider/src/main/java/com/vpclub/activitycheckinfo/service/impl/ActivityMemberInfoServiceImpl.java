package com.vpclub.activitycheckinfo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.activitycheckinfo.dao.ActivityMemberInfoDao;
import com.vpclub.activitycheckinfo.entity.ActivityMemberInfoEntity;
import com.vpclub.activitycheckinfo.service.ActivityMemberInfoService;
import com.vpclub.admin.utils.PageUtils;
import com.vpclub.admin.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("activityMemberInfoService")
public class ActivityMemberInfoServiceImpl extends ServiceImpl<ActivityMemberInfoDao, ActivityMemberInfoEntity> implements ActivityMemberInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityMemberInfoEntity> page = this.selectPage(
                new Query<ActivityMemberInfoEntity>(params).getPage(),
                new EntityWrapper<ActivityMemberInfoEntity>()
        );

        return new PageUtils(page);
    }

}
