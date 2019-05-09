package com.vpclub.admin.service.impl;

import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.SysUserDao;
 import com.vpclub.admin.entity.SysUserEntity;
import com.vpclub.admin.model.request.SysUserParam;
import com.vpclub.admin.service.SysUserService;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

//	@Resource
//	JavaMailSender jms;

//	@Value("${spring.mail.username}")
//	String emailSender;

	@Override
	public Result queryPage(SysUserParam params) {
		Page<SysUserEntity> page = new Page<SysUserEntity>();
		if (StringUtil.isNotEmpty(params)){
			page.setCurrent(params.getPageNumber());
			page.setSize(params.getPageSize());
		}
		EntityWrapper<SysUserEntity> ew = new EntityWrapper<>();
		ew.like(StringUtil.isNotEmpty(params.getUsername()), "username", params.getUsername());
//		ew.eq(StringUtil.isNotEmpty(params.getMobile()),"mobile",params.getMobile());
		ew.eq("deleted",1);
		Page<SysUserEntity> selectPage = this.selectPage(page, ew);
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
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

    @Override
	public Result save(SysUserEntity user) {
		String username = user.getUsername();
		SysUserEntity sysUserEntity = this.queryByUserName(username);
		if(sysUserEntity!=null){
			return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"该用户名已存在！");
		}
		Long nowTime = System.currentTimeMillis();
		//sha256加密
		//String salt = RandomStringUtils.randomAlphanumeric(20);
		String password = DigestUtils.sha1Hex(user.getPassword().trim()).toUpperCase();
		user.setPassword(password);
		//user.setSalt(salt);
		this.insert((SysUserEntity) user);

		//检查角色是否越权
		//checkRole((SysUserEntity) user);

			return ResponseResult.success();
	}

	@Override
	@Transactional
	public void update(SysUserEntity sysUserEntity) {

		if(StringUtil.isEmpty(sysUserEntity.getPassword())){
			sysUserEntity.setPassword(null);
		}else{
			sysUserEntity.setPassword(DigestUtils.sha1Hex(sysUserEntity.getPassword().trim()).toUpperCase());
		}
		this.updateById(sysUserEntity);

		//检查角色是否越权
		//checkRole(sysUserEntity);
		//保存用户与角色关系
		//sysUserRoleService.saveOrUpdate(sysUserEntity.getUserId(), sysUserEntity.getRoleIdList(),sysUserEntity.getUpdatedBy());
	}

	@Override
	public void deleteBatch(Long[] userId) {
		this.deleteBatchIds(Arrays.asList(userId));
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		SysUserEntity userEntity = new SysUserEntity();
		userEntity.setPassword(newPassword);
		return this.update(userEntity,
				new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserEntity user){

	}

	@Override
	public void deleteByUserId(List<Long> ids) {
		//删除关联表记录


		baseMapper.deleteByUserIds(ids);

	}

	@Override
	public void register(SysUserEntity registerUser) {
//		baseMapper.addUser((SysUserEntity) registerUser);
		this.insert(registerUser);
	}

	@Override
	public List<SysUserEntity> queryByParentId(String parentId) {
		return baseMapper.queryByParentId(parentId);
	}

    @Override
	public SysUserEntity queryByPhone(SysUserEntity mobileuser) {
		EntityWrapper<SysUserEntity> condition = new EntityWrapper<SysUserEntity>((SysUserEntity) mobileuser);
		SysUserEntity user = this.selectOne(condition);
		return user;
	}

	@Override
	public Result page(SysUserParam param) {
		Integer current = param.getPageNumber();
		Integer size = param.getPageSize();
		//分页对象封装
		Page<SysUserEntity> page = new Page<>();
		page.setSize(size);
		page.setCurrent(current);
		List<SysUserEntity> list = this.baseMapper.page(page);
		page.setRecords(list);
		return ResponseResult.success(page);
	}
}
