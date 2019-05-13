package com.vpclub.admin.client;

import com.vpclub.admin.entity.MenuBaseInfoEntity;
import com.vpclub.result.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  系统菜单 服务治理
 * </p>
 */
@RequestMapping(value = "/sysMenuClient")
public interface SysMenuClient {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    @RequestMapping(value = "queryListParentId",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<MenuBaseInfoEntity> queryListParentId(@RequestBody Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    @RequestMapping(value = "queryNotButtonList",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<MenuBaseInfoEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     */
    @RequestMapping(value = "getUserMenuList")
    List<MenuBaseInfoEntity> getUserMenuList(@RequestParam("userId") Long userId);
    /**
     * 获取角色菜单列表
     */
    @RequestMapping(value = "getRoleMenuList")
    List<MenuBaseInfoEntity> getRoleMenuList(@RequestParam("roleId") Long roleId);

    /**
     * 删除
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody Long menuId);

    @RequestMapping(value = "/selectList" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<MenuBaseInfoEntity> selectList(MenuBaseInfoEntity menuBaseInfoEntity);

    @RequestMapping(value = "/selectById",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    MenuBaseInfoEntity selectById(@RequestBody Long parentId);

    @RequestMapping(value = "/insert",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result insert(@RequestBody MenuBaseInfoEntity menu);

    @RequestMapping(value = "/updateById",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result updateById(@RequestBody MenuBaseInfoEntity menu);
}
