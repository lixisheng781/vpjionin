package com.vpclub.admin.service.impl;


import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.SysRoleDao;
import com.vpclub.admin.entity.SysRoleEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.SysRoleService;
import com.vpclub.admin.service.SysUserService;
import com.vpclub.admin.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 系统角色 服务实现类
 *
 */

@Slf4j
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {



	@Autowired
	private SysUserService sysUserService;


	@Override
	public Result queryPage(SysRoleParam params) {
		log.info("系统角色列表分页 request: {}", params.toString());
		Result result = ResponseResult.success();
		Page<SysRoleEntity> page= new Page<>();
		if(StringUtil.isNotEmpty(params)){
			page.setCurrent(params.getPageNumber());
			page.setSize(params.getPageSize());
		}
		EntityWrapper<SysRoleEntity> ew = new EntityWrapper<>();
		ew.like(StringUtil.isNotEmpty(params.getRoleName()),"role_name",params.getRoleName()).eq(StringUtil.isNotEmpty(params.getCreatedBy()),"created_by",params.getCreatedBy());
		Page<SysRoleEntity> selectPage=this.selectPage(page,ew);
//		BeanUtils.copyProperties(selectPage,result);
		result.setData(selectPage);
		return result;
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result save(SysRoleEntity role) {
		EntityWrapper<SysRoleEntity> ew = new EntityWrapper<>();
		ew.eq("role_name",role.getRoleName());
		SysRoleEntity sysRoleEntity = this.selectOne(ew);
		if(sysRoleEntity!=null){
			return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"该角色名称已存在！");
		}

        this.insert(role);
 		return ResponseResult.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {

        this.updateById(role);
        //检查权限是否越权
        //checkPrems(role);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteBatch(Long[] roleIds) {

			//删除角色
			this.deleteBatchIds(Arrays.asList(roleIds));


			return ResponseResult.success();


    }


    @Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return baseMapper.queryRoleIdList(createUserId);
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRoleEntity role){


			return;
	}

}