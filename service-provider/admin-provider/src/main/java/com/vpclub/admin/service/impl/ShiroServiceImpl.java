package com.vpclub.admin.service.impl;


import com.vpclub.admin.dao.MenuBaseInfoDao;
import com.vpclub.admin.dao.SysUserInfoDao;
import com.vpclub.admin.dao.SysUserTokenDao;
import com.vpclub.admin.entity.MenuBaseInfoEntity;
import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.admin.entity.SysUserTokenEntity;
import com.vpclub.admin.service.ShiroService;
import com.vpclub.admin.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private MenuBaseInfoDao menuBaseInfoDao;
    @Autowired
    private SysUserInfoDao sysUserInfoDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<MenuBaseInfoEntity> menuList = menuBaseInfoDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(MenuBaseInfoEntity menu : menuList){
//                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserInfoDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserInfoEntity queryUser(Long userId) {
        return sysUserInfoDao.selectById(userId);
    }
}
