package com.vpclub.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.RoleMenuInfoDao;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuInfoServiceImpl extends ServiceImpl<RoleMenuInfoDao, RoleMenuInfoEntity> implements RoleMenuInfoService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        //先删除角色与菜单关系
        deleteBatch(new Long[]{roleId});
        if(null == menuIdList || menuIdList.size() == 0){
            return ;
        }
        //保存角色与菜单关系
        List<RoleMenuInfoEntity> list = new ArrayList<>(menuIdList.size());
        for(Long menuId : menuIdList){
            RoleMenuInfoEntity sysRoleMenuEntity = new RoleMenuInfoEntity();
            sysRoleMenuEntity.setRoleId(roleId);
            sysRoleMenuEntity.setMenuId(menuId);

            list.add(sysRoleMenuEntity);
        }
        this.insertBatch(list);
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }

    @Override
    public int deleteBatch(Long[] roleIds){
        return baseMapper.deleteBatch(roleIds);
    }
}
