package com.vpclub.admin.service.impl;

import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.admin.entity.UserRoleInfoEntity;
import com.vpclub.admin.service.RoleBaseInfoService;
import com.vpclub.admin.service.UserRoleInfoService;
import com.vpclub.admin.utils.Constant;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 系统用户
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoDao, SysUserInfoEntity> implements SysUserInfoService {
	@Autowired
	private UserRoleInfoService userRoleInfoService;
	@Autowired
	private RoleBaseInfoService roleBaseInfoService;

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
		ew.like(StringUtil.isNotEmpty(params.getUsername()), "login_name", params.getUsername());
//		ew.eq(StringUtil.isNotEmpty(params.getMobile()),"mobile",params.getMobile());
		ew.eq("del_flag",0);
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
			return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"该用户已存在！");
		}
		Date nowTime = new Date();
		user.setCreateDate(nowTime);
		user.setUpdateDate(nowTime);
		//sha256加密
		//String salt = RandomStringUtils.randomAlphanumeric(20);
		String password = DigestUtils.sha1Hex(user.getPassword().trim()).toUpperCase();
		user.setPassword(password);
		//user.setSalt(salt);
		this.insert((SysUserInfoEntity) user);

		//检查角色是否越权
		//checkRole((SysUserInfoEntity) user);

		//保存用户与角色关系
		userRoleInfoService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
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
		userRoleInfoService.saveOrUpdate(sysUserInfoEntity.getUserId(), sysUserInfoEntity.getRoleIdList());
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
				new EntityWrapper<SysUserInfoEntity>().eq("uui_num", userId).eq("login_pwd", password));
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserInfoEntity user){
		if(user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
			return;
		}
		//如果不是超级管理员，则需要判断用户的角色是否自己创建
		if(user.getCreateId() == Constant.SUPER_ADMIN){
			return ;
		}

		//查询用户创建的角色列表
		List<Long> roleIdList = roleBaseInfoService.queryRoleIdList(user.getCreateId());

		//判断是否越权
		if(!roleIdList.containsAll(user.getRoleIdList())){
			log.error("新增用户所选角色，不是本人创建");
		}
	}

	@Override
	public void deleteByUserId(List<Long> ids) {
		//删除关联表记录
		EntityWrapper<UserRoleInfoEntity> ew = new EntityWrapper<>();
		ew.in("uui_id",ids);
		userRoleInfoService.delete(ew);

		baseMapper.deleteByUserIds(ids);

	}

	@Override
	public void register(SysUserInfoEntity registerUser) {
//		baseMapper.addUser((SysUserInfoEntity) registerUser);
		this.insert(registerUser);
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
