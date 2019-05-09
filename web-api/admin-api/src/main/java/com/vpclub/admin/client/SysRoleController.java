package com.vpclub.admin.client;


import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.vpclub.admin.common.validator.ValidatorUtils;
import com.vpclub.admin.entity.SysRoleEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.SysRoleService;
import com.vpclub.admin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/***
 * <p>
 *  系统角色管理 前端控制器
 * </p>
 * @author lxs
 *
 */
@RestController
@RequestMapping("/admin/sys/role")
public class SysRoleController extends AbstractController {

    @Autowired
	private SysRoleService sysRoleService;



	/**
	 * 角色列表
	 */
	@PostMapping("/list")
	public Result list(@RequestBody SysRoleParam params){
		//如果不是超级管理员，则只查询自己创建的角色列表
//		if(userId != Constant.SUPER_ADMIN){
//			params.setCreatedBy(userId);
//		}
		Result result = sysRoleService.queryPage(params);
		result.setMsg("成功");
		return result;
	}

	/**
	 * 角色列表
	 */
	@PostMapping("/select")
	public Result select(){

		SysRoleEntity entity = new SysRoleEntity();
		//如果不是超级管理员，则只查询自己所拥有的角色列表
//		if(getUserId() != Constant.SUPER_ADMIN){
//			entity.setCreatedBy(userId);
//		}
		List<SysRoleEntity> list = sysRoleService.selectByParam(entity);
		return ResponseResult.success(list);
	}

	/**
	 * 角色信息
	 */
	@PostMapping ("/info")
	public Result info(@RequestBody SysRoleParam params){
		if(StringUtil.isEmpty(params.getRoleId())){
			return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"参数不能为空");
		}
		SysRoleEntity role = sysRoleService.selectById(params.getRoleId());
		return ResponseResult.success(role);
	}

	/**
	 * 保存角色
	 */
	@PostMapping("/save")
	public Result save(@RequestBody SysRoleEntity role){
		ValidatorUtils.validateEntity(role);
		//role.setCreatedBy(userId);
		//role.setUpdatedBy(userId);
		return sysRoleService.save(role);
	}

	/**
	 * 修改角色
	 */
	@PostMapping("/update")
	public Result update(@RequestBody SysRoleEntity role){
		ValidatorUtils.validateEntity(role);
		sysRoleService.update(role);
		return ResponseResult.success();
	}

	/**
	 * 删除角色
	 */
	@PostMapping("/delete")
	public Result delete(@RequestBody SysRoleParam params){
		return sysRoleService.deleteBatch(params);
	}

}


