package com.vpclub.admin.client;

import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vpclub.admin.entity.SysMenuEntity;
import com.vpclub.admin.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  系统菜单 服务治理实现类
 * </p>
 * @author yk
 * @since  2018-06-01
 */
@Slf4j
@RestController
public class SysMenuClientImpl implements SysMenuClient {

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public List<SysMenuEntity> queryListParentId(@RequestBody Long parentId) {
        return sysMenuService.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return sysMenuService.queryNotButtonList();
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        return sysMenuService.getUserMenuList(userId);
    }

    @Override
    public List<SysMenuEntity> getRoleMenuList(Long roleId) {
        return sysMenuService.getRoleMenuList(roleId);
    }

    @Override
    public void delete(@RequestBody Long menuId) {
        sysMenuService.delete(menuId);
    }

    @Override
    public List<SysMenuEntity> selectList(@RequestBody SysMenuEntity sysMenuEntity) {
        log.info("sysMenuEntity:    " + sysMenuEntity);
        EntityWrapper<SysMenuEntity> ew = new EntityWrapper(sysMenuEntity);
        return sysMenuService.selectList(ew);
    }

    @Override
    public SysMenuEntity selectById(@RequestBody Long parentId) {
        return sysMenuService.selectById(parentId);
    }

    @Override
    public Result insert(@RequestBody SysMenuEntity menu) {
        Result result = new Result();
        long now = new Date().getTime();
//        menu.setCreatedTime(now);
//        menu.setUpdatedTime(now);
        boolean back = sysMenuService.insert(menu);
        if(back){
            result= ResponseResult.success();
        }else {
            result= ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR);
        }
        return result;
    }

    @Override
    public Result updateById(@RequestBody SysMenuEntity menu) {
        Result result = new Result();
//        menu.setUpdatedTime(new Date().getTime());
        boolean back = sysMenuService.updateById(menu);
        if(back){
            result= ResponseResult.success();
        }else {
            result= ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR);
        }
        return result;
    }
}
