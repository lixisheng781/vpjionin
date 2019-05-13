package com.vpclub.admin.service.impl;

import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.SysUserInfoDao;
import com.vpclub.admin.model.request.SysUserParam;
import com.vpclub.admin.service.SysUserInfoService;
import com.vpclub.admin.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


/**
 * 系统用户
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoDao, SysUserInfoEntity> implements SysUserInfoService {

//	@Resource
//	JavaMailSender jms;

//	@Value("${spring.mail.username}")
//	String emailSender;

	@Override
	public Result queryPage(SysUserParam params) {
		Page<SysUserInfoEntity> page = new Page<SysUserInfoEntity>();
		if (StringUtil.isNotEmpty(params)){
			page.setCurrent(params.getPageNumber());
			page.setSize(params.getPageSize());
		}
		EntityWrapper<SysUserInfoEntity> ew = new EntityWrapper<>();
		ew.like(StringUtil.isNotEmpty(params.getUsername()), "username", params.getUsername());
//		ew.eq(StringUtil.isNotEmpty(params.getMobile()),"mobile",params.getMobile());
		ew.eq("delFlag",1);
		Page<SysUserInfoEntity> selectPage = this.selectPage(page, ew);
		return ResponseResult.success(selectPage);
	}

	@Override
	public List<String> queryAllPerms(Long userId) {
		return baseMapper.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	public SysUserInfoEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

    @Override
	public Result save(SysUserInfoEntity user) {
		String username = user.getUuiName();
		SysUserInfoEntity sysUserInfoEntity = this.queryByUserName(username);
		if(sysUserInfoEntity !=null){
			return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"该用户名已存在！");
		}
		Long nowTime = System.currentTimeMillis();
		//sha256加密
		//String salt = RandomStringUtils.randomAlphanumeric(20);
		String password = DigestUtils.sha1Hex(user.getPassword().trim()).toUpperCase();
		user.setPassword(password);
		//user.setSalt(salt);
		this.insert((SysUserInfoEntity) user);

		//检查角色是否越权
		//checkRole((SysUserInfoEntity) user);

			return ResponseResult.success();
	}

	@Override
	@Transactional
	public void update(SysUserInfoEntity sysUserInfoEntity) {

		if(StringUtil.isEmpty(sysUserInfoEntity.getPassword())){
			sysUserInfoEntity.setPassword(null);
		}else{
			sysUserInfoEntity.setPassword(DigestUtils.sha1Hex(sysUserInfoEntity.getPassword().trim()).toUpperCase());
		}
		this.updateById(sysUserInfoEntity);

		//检查角色是否越权
		//checkRole(sysUserInfoEntity);
		//保存用户与角色关系
		//sysUserRoleService.saveOrUpdate(sysUserInfoEntity.getUserId(), sysUserInfoEntity.getRoleIdList(),sysUserInfoEntity.getUpdatedBy());
	}

	@Override
	public void deleteBatch(Long[] userId) {
		this.deleteBatchIds(Arrays.asList(userId));
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		SysUserInfoEntity userEntity = new SysUserInfoEntity();
		userEntity.setPassword(newPassword);
		return this.update(userEntity,
				new EntityWrapper<SysUserInfoEntity>().eq("user_id", userId).eq("password", password));
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserInfoEntity user){

	}

	@Override
	public void deleteByUserId(List<Long> ids) {
		//删除关联表记录


		baseMapper.deleteByUserIds(ids);

	}

	@Override
	public void register(SysUserInfoEntity registerUser) {
//		baseMapper.addUser((SysUserInfoEntity) registerUser);
		this.insert(registerUser);
	}

	@Override
	public List<SysUserInfoEntity> queryByParentId(String parentId) {
		return baseMapper.queryByParentId(parentId);
	}

    @Override
	public SysUserInfoEntity queryByPhone(SysUserInfoEntity mobileuser) {
		EntityWrapper<SysUserInfoEntity> condition = new EntityWrapper<SysUserInfoEntity>((SysUserInfoEntity) mobileuser);
		SysUserInfoEntity user = this.selectOne(condition);
		return user;
	}

	@Override
	public Result page(SysUserParam param) {
		Integer current = param.getPageNumber();
		Integer size = param.getPageSize();
		//分页对象封装
		Page<SysUserInfoEntity> page = new Page<>();
		page.setSize(size);
		page.setCurrent(current);
		List<SysUserInfoEntity> list = this.baseMapper.page(page);
		page.setRecords(list);
		return ResponseResult.success(page);
	}
}