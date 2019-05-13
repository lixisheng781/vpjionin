

package com.vpclub.admin.client;


import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.vpclub.admin.entity.MenuBaseInfoEntity;
import com.vpclub.admin.model.request.SysMenuParam;
import com.vpclub.admin.model.response.MenuResponse;
import com.vpclub.admin.service.ShiroService;
import com.vpclub.admin.service.SysMenuService;
import com.vpclub.admin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统菜单 前端控制器
 *
 * @author lxs
 */
@RestController
@RequestMapping("/admin/sys/menu")
public class SysMenuController extends AbstractController {

	@Autowired
	private SysMenuService sysMenuService;

	@Autowired
	private ShiroService shiroService;

	/**
	 * 导航菜单
	 */
	@PostMapping("/nav")
	public Result nav(@RequestParam("roleId") Long roleId) {
		Result result = new Result();
		//List<MenuBaseInfoEntity> menuList = sysMenuService.getUserMenuList(userId);
		List<MenuBaseInfoEntity> menuList = sysMenuService.getRoleMenuList(roleId);
		//Set<String> permissions = shiroService.getUserPermissions(getUserId());

		MenuResponse menuResponse = new MenuResponse();
		menuResponse.setMenuList(menuList);
		//menuResponse.setPermissions(permissions);

		result = ResponseResult.success(menuResponse);
		return result;
	}

	/**
	 * 所有菜单列表
	 */
	@PostMapping("/list")
	public Result list(@RequestBody MenuBaseInfoEntity menuBaseInfoEntity){
		Result result = new Result();
		List<MenuBaseInfoEntity> menuList = sysMenuService.selectList(menuBaseInfoEntity);
//		for(MenuBaseInfoEntity menuBaseInfoEntity : menuList){
//			MenuBaseInfoEntity parentMenuEntity = sysMenuService.selectById(menuBaseInfoEntity.getParentId());
//			if(parentMenuEntity != null){
//				menuBaseInfoEntity.setParentName(parentMenuEntity.getMenuName());
//			}
//		}
		result = ResponseResult.success(menuList);
		return result;
	}

	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@PostMapping("/select")
	public Result select() {
		Result result = new Result();
		//查询列表数据
		List<MenuBaseInfoEntity> menuList = sysMenuService.queryNotButtonList();

		//添加顶级菜单
		MenuBaseInfoEntity root = new MenuBaseInfoEntity();
		root.setMenuId(0L);
		root.setOpen(true);
		menuList.add(root);
		result = ResponseResult.success(menuList);
		return result;
	}

	/**
	 * 菜单信息
	 */
	@PostMapping("/info")
	public Result info(@RequestBody SysMenuParam param){
		Result result = new Result();
		if (StringUtil.isEmpty(param.getMenuId())){
			result = ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST);
			return result;
		}else {
			MenuBaseInfoEntity menu = sysMenuService.selectById(param.getMenuId());
			result = ResponseResult.success(menu);
			return result;
		}
	}

	/**
	 * 保存
	 */
	@PostMapping("/save")
	public Result save(@RequestBody MenuBaseInfoEntity menu){
		Result result = new Result();
		//数据校验
		verifyForm(menu);
		result = sysMenuService.insert(menu);

		return result;
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	public Result update(@RequestBody MenuBaseInfoEntity menu){
		Result result = new Result();
		//数据校验
		verifyForm(menu);
		result = sysMenuService.updateById(menu);
		return result;
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public Result delete(@RequestBody SysMenuParam param) {
		Result result = new Result();
		if (StringUtil.isEmpty(param.getMenuId())){
			result = ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST);
			return result;
		}else {
			Long menuId = param.getMenuId();
			if (menuId <= 31) {
				result = ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"系统菜单，不能删除");
				return result;
			}

			//判断是否有子菜单或按钮
			List<MenuBaseInfoEntity> menuList = sysMenuService.queryListParentId(menuId);
			if (menuList.size() > 0) {
				result = ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"请先删除子菜单或按钮");
				return result;
			}

			sysMenuService.delete(menuId);

			result = ResponseResult.success();
			return result;
		}
	}

	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(MenuBaseInfoEntity menu) {


//		if(menu.getParentId() == null){
//			throw new RRException("上级菜单不能为空");
//		}


//		//上级菜单类型
//		int parentType = Constant.MenuType.CATALOG.getValue();
//		if(menu.getParentId() != 0){
//			MenuBaseInfoEntity parentMenu = sysMenuService.selectById(menu.getParentId());
//			parentType = parentMenu.getMenuType();
//		}
//
//		//目录、菜单
//		if(menu.getMenuType() == Constant.MenuType.CATALOG.getValue() ||
//				menu.getMenuType() == Constant.MenuType.MENU.getValue()){
//			if(parentType != Constant.MenuType.CATALOG.getValue()){
//				throw new RRException("上级菜单只能为目录类型");
//			}
//			return ;
//		}
//
//		//按钮
//		if(menu.getMenuType() == Constant.MenuType.BUTTON.getValue()){
//			if(parentType != Constant.MenuType.MENU.getValue()){
//				throw new RRException("上级菜单只能为菜单类型");
//			}
//			return ;
//		}
	}
}
