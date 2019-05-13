package com.vpclub.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.domain.OrgDTO;
import com.vpclub.admin.domain.UserParam;
import com.vpclub.admin.entity.SysUserInfoEntity;

import java.util.List;

/**
 * <p>
 * 机构用户信息表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-02-22
 */
public interface ISysUserInfoService extends IService<SysUserInfoEntity> {

	SysUserInfoEntity getSysUserInfo(Long id);

    List<OrgDTO> queryByUserIdAndSchoolId(UserParam userParam);
}
