package com.vpclub.admin.client;

import com.vpclub.admin.entity.MenuBaseInfoEntity;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vpclub.admin.service.MenuBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  系统菜单 服务治理实现类！
 * </p>
 */
@Slf4j
@RestController
public class MenuBaseInfoClientImpl implements MenuBaseInfoClient {

    @Autowired
    private MenuBaseInfoService menuBaseInfoService;

    @Override
    public List<MenuBaseInfoEntity> queryListParentId(@RequestBody Long parentId) {
        return menuBaseInfoService.queryListParentId(parentId);
    }

    @Override
    public List<MenuBaseInfoEntity> queryNotButtonList() {
        return menuBaseInfoService.queryNotButtonList();
    }

    @Override
    public List<MenuBaseInfoEntity> getUserMenuList(Long userId) {
        return menuBaseInfoService.getUserMenuList(userId);
    }

    @Override
    public List<MenuBaseInfoEntity> getRoleMenuList(Long roleId) {
        return menuBaseInfoService.getRoleMenuList(roleId);
    }

    @Override
    public void delete(@RequestBody Long menuId) {
        menuBaseInfoService.delete(menuId);
    }

    @Override
    public List<MenuBaseInfoEntity> selectList(@RequestBody MenuBaseInfoEntity menuBaseInfoEntity) {
        log.info("menuBaseInfoEntity:    " + menuBaseInfoEntity);
        EntityWrapper<MenuBaseInfoEntity> ew = new EntityWrapper(menuBaseInfoEntity);
        return menuBaseInfoService.selectList(ew);
    }

    @Override
    public MenuBaseInfoEntity selectById(@RequestBody Long parentId) {
        return menuBaseInfoService.selectById(parentId);
    }

    @Override
    public Result insert(@RequestBody MenuBaseInfoEntity menu) {
        Result result = new Result();
        long now = new Date().getTime();
//        menu.setCreatedTime(now);
//        menu.setUpdatedTime(now);
        boolean back = menuBaseInfoService.insert(menu);
        if(back){
            result= ResponseResult.success();
        }else {
            result= ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR);
        }
        return result;
    }

    @Override
    public Result updateById(@RequestBody MenuBaseInfoEntity menu) {
        Result result = new Result();
//        menu.setUpdatedTime(new Date().getTime());
        boolean back = menuBaseInfoService.updateById(menu);
        if(back){
            result= ResponseResult.success();
        }else {
            result= ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR);
        }
        return result;
    }
}
