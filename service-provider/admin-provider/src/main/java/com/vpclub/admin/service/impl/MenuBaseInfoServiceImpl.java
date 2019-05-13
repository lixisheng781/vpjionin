/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vpclub.admin.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.MenuBaseInfoDao;
import com.vpclub.admin.entity.MenuBaseInfoEntity;
import com.vpclub.admin.service.MenuBaseInfoService;
import com.vpclub.admin.service.SysUserInfoService;
import com.vpclub.admin.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  系统菜单 服务实现类
 * </p>
 * @author  yk
 * @since  2018-06-01
 */
@Slf4j
@Service("menuBaseInfoService")
public class MenuBaseInfoServiceImpl extends ServiceImpl<MenuBaseInfoDao, MenuBaseInfoEntity> implements MenuBaseInfoService {

	@Autowired
	private SysUserInfoService sysUserInfoService;



	@Override
	public List<MenuBaseInfoEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<MenuBaseInfoEntity> menuList = queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}

		List<MenuBaseInfoEntity> userMenuList = new ArrayList<>();
		for(MenuBaseInfoEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<MenuBaseInfoEntity> queryListParentId(Long parentId) {
		return baseMapper.queryListParentId(parentId);
	}

	@Override
	public List<MenuBaseInfoEntity> queryNotButtonList() {
		return baseMapper.queryNotButtonList();
	}

	@Override
	public List<MenuBaseInfoEntity> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if(userId == Constant.SUPER_ADMIN){
			return getAllMenuList(null);
		}

		//用户菜单列表
		List<Long> menuIdList = sysUserInfoService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public void delete(Long menuId){
		//删除菜单
		this.deleteById(menuId);

	}

	/**
	 * 获取所有菜单列表
	 */
	private List<MenuBaseInfoEntity> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<MenuBaseInfoEntity> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);

		return menuList;
	}

	/**
	 * 递归
	 */
	private List<MenuBaseInfoEntity> getMenuTreeList(List<MenuBaseInfoEntity> menuList, List<Long> menuIdList){
		List<MenuBaseInfoEntity> subMenuList = new ArrayList<MenuBaseInfoEntity>();

		for(MenuBaseInfoEntity entity : menuList){
			//目录
			//if(entity.getMenuType() == Constant.MenuType.CATALOG.getValue()){
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			//}
			subMenuList.add(entity);
		}

		return subMenuList;
	}
}
