package com.vpclub.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.vpclub.admin.dao.SysUserInfoDao;
import com.vpclub.admin.domain.OrgDTO;
import com.vpclub.admin.domain.UserParam;
import com.vpclub.admin.entity.SysOfficeInfoEntity;
import com.vpclub.admin.entity.SysUserInfo;
import com.vpclub.admin.service.ISysUserInfoService;
import com.vpclub.admin.service.SysOfficeInfoService;
import com.vpclub.exception.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 机构用户信息表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-02-22
 */
@Service
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoDao, SysUserInfo> implements ISysUserInfoService {

	@Autowired
	private SysOfficeInfoService sysOfficeInfoService;
	@Override
	public SysUserInfo getSysUserInfo(Long id) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectById(id);
	}

	@Override
	public List<OrgDTO> queryByUserIdAndSchoolId(UserParam userParam) {

		if (userParam == null) {
			throw new RRException("确认参数");
		}
		if (userParam.getUserId() == null) {
			throw new RRException("userId必穿");
		}
		if (userParam.getSchoolId() == null) {
			throw new RRException("schoolId必穿");
		}
		EntityWrapper<SysUserInfo> queryWrapper = new EntityWrapper<>();
		queryWrapper.eq("uui_num", userParam.getUserId());
		queryWrapper.eq("ubi_id", userParam.getSchoolId());
		SysUserInfo dbUser = this.selectOne(queryWrapper);
		if (dbUser == null) {
			throw new RRException("该用户不存在");
		}
		Long orgId = dbUser.getUoiId();
		if (null == orgId) {
			throw new RRException("该用户下机构不存在");
		}
		SysOfficeInfoEntity orgDb = sysOfficeInfoService.selectById(orgId);
		if (orgDb == null) {
			throw new RRException("该用户下机构不存在");
		}
		String path = orgDb.getPath();
		String[] pathArr = path.split(",");
		List<Long> pathList = Lists.newArrayList();
		for (String s : pathArr) {
			pathList.add(Long.valueOf(s));
		}
		//带上自己的机构
		pathList.add(orgDb.getUbiNum());
		EntityWrapper<SysOfficeInfoEntity> qw = new EntityWrapper<>();
		qw.in("ubi_num", pathList);
		List<SysOfficeInfoEntity> orgList = sysOfficeInfoService.selectList(qw);
		List<OrgDTO> orgDTOList = Lists.newArrayList();
		if (!CollectionUtils.isEmpty(orgList)) {
			for (SysOfficeInfoEntity org : orgList) {
				OrgDTO orgDTO = new OrgDTO();
				orgDTO.setOrgId(org.getUbiNum());
				orgDTO.setOrgName(org.getFullName());
				orgDTOList.add(orgDTO);
			}
		}
		return orgDTOList;
	}

}
