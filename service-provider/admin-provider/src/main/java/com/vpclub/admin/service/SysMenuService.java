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

package com.vpclub.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.MenuBaseInfoEntity;

import java.util.List;


/**
 * <p>
 * 菜单管理 服务类
 * </p>
 * 
 * @author yk
 * @since  2018-06-01
 *
 */
public interface SysMenuService extends IService<MenuBaseInfoEntity> {

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<MenuBaseInfoEntity> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<MenuBaseInfoEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<MenuBaseInfoEntity> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
	List<MenuBaseInfoEntity> getUserMenuList(Long userId);

	/**
	 * 获取角色菜单列表
	 */
	List<MenuBaseInfoEntity> getRoleMenuList(Long roleId);

	/**
	 * 删除
	 */
	void delete(Long menuId);

	/**
	 * 根据菜单类型，查询菜单列表
	 * @param type 菜单类型
	 */
	List<Long> queryListType(Integer type);
}
