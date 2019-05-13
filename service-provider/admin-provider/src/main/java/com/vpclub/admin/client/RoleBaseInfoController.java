package com.vpclub.admin.client;


import com.vpclub.admin.entity.RoleBaseInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.RoleBaseInfoService;
import com.vpclub.admin.utils.StringUtil;
import com.vpclub.admin.utils.ValidatorUtils;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class RoleBaseInfoController extends AbstractController {

    @Autowired
	private RoleBaseInfoService roleBaseInfoService;



	/**
	 * 角色列表
	 */
	@PostMapping("/list")
	public Result list(@RequestBody SysRoleParam params){
		//如果不是超级管理员，则只查询自己创建的角色列表
//		if(userId != Constant.SUPER_ADMIN){
//			params.setCreatedBy(userId);
//		}
		Result result = roleBaseInfoService.queryPage(params);
		result.setMsg("成功");
		return result;
	}

	/**
	 * 角色列表
	 */
	@PostMapping("/select")
	public Result select(){

		RoleBaseInfoEntity entity = new RoleBaseInfoEntity();
		//如果不是超级管理员，则只查询自己所拥有的角色列表
//		if(getUserId() != Constant.SUPER_ADMIN){
//			entity.setCreatedBy(userId);
//		}
//		List<RoleBaseInfoEntity> list = roleBaseInfoService.selectByParam(entity);
//		return ResponseResult.success(list);

		return null;
	}

	/**
	 * 角色信息
	 */
	@PostMapping ("/info")
	public Result info(@RequestBody SysRoleParam params){
		if(StringUtil.isEmpty(params.getRoleId())){
			return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"参数不能为空");
		}
		RoleBaseInfoEntity role = roleBaseInfoService.selectById(params.getRoleId());
		return ResponseResult.success(role);
	}

	/**
	 * 保存角色
	 */
	@PostMapping("/save")
	public Result save(@RequestBody RoleBaseInfoEntity role){
		ValidatorUtils.validateEntity(role);
		//role.setCreatedBy(userId);
		//role.setUpdatedBy(userId);
		return roleBaseInfoService.save(role);
	}

	/**
	 * 修改角色
	 */
	@PostMapping("/update")
	public Result update(@RequestBody RoleBaseInfoEntity role){
		ValidatorUtils.validateEntity(role);
		roleBaseInfoService.update(role);
		return ResponseResult.success();
	}

	/**
	 * 删除角色
	 */
	@PostMapping("/delete")
	public Result delete(@RequestBody SysRoleParam params){

		return roleBaseInfoService.deleteBatch(null);
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}


