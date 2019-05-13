package com.vpclub.admin.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.RoleBaseInfoDao;
import com.vpclub.admin.entity.RoleBaseInfoEntity;
import com.vpclub.admin.entity.UserRoleInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.admin.service.RoleBaseInfoService;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.admin.service.SysUserInfoService;
import com.vpclub.admin.service.UserRoleInfoService;
import com.vpclub.admin.utils.Constant;
import com.vpclub.admin.utils.StringUtil;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 系统角色 服务实现类
 */

@Slf4j
@Service("roleBaseInfoService")
public class RoleBaseInfoServiceImpl extends ServiceImpl<RoleBaseInfoDao, RoleBaseInfoEntity> implements RoleBaseInfoService {

    @Autowired
    private RoleMenuInfoService roleMenuInfoService;

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Autowired
    private UserRoleInfoService userRoleInfoService;

    @Override
    public Result queryPage(SysRoleParam params) {
        log.info("系统角色列表分页 request: {}", params.toString());
        Result result = ResponseResult.success();
        Page<RoleBaseInfoEntity> page = new Page<>();
        if (StringUtil.isNotEmpty(params)) {
            page.setCurrent(params.getPageNumber());
            page.setSize(params.getPageSize());
        }
        EntityWrapper<RoleBaseInfoEntity> ew = new EntityWrapper<>();
        ew.like(StringUtil.isNotEmpty(params.getRoleName()), "role_name", params.getRoleName()).eq(StringUtil.isNotEmpty(params.getCreatedBy()), "created_by", params.getCreatedBy());
        Page<RoleBaseInfoEntity> selectPage = this.selectPage(page, ew);
//		BeanUtils.copyProperties(selectPage,result);12
        result.setData(selectPage);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result save(RoleBaseInfoEntity role) {
        EntityWrapper<RoleBaseInfoEntity> ew = new EntityWrapper<>();
        ew.eq("role_name", role.getRoleName());
        RoleBaseInfoEntity roleBaseInfoEntity = this.selectOne(ew);
        if (roleBaseInfoEntity != null) {
            return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST, "该角色名称已存在！");
        }

        //当前时间
        Date nowTime = new Date();
        //时间戳转换
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String format = sdf.format(nowTime);
        try {
            role.setCreateDate(nowTime);
            role.setUpdateDate(nowTime);
        } catch (Exception e) {
        }

        this.insert(role);

        //保存角色与菜单关系
        roleMenuInfoService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
        return ResponseResult.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RoleBaseInfoEntity role) {

        //当前时间
        Date nowTime = new Date();
        //时间戳转换
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String format = sdf.format(nowTime);
        try {
            role.setCreateDate(nowTime);
            role.setUpdateDate(nowTime);
        } catch (Exception e) {
        }

        this.updateById(role);
        //检查权限是否越权
        //checkPrems(role);
        //更新角色与菜单关系
        roleMenuInfoService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteBatch(Long[] roleIds) {

        //查询当前角色下是否有用户
        EntityWrapper<UserRoleInfoEntity> ew = new EntityWrapper<>();
        ew.in("rbi_id",roleIds);
        List<UserRoleInfoEntity> list = userRoleInfoService.selectList(ew);
        if(list.size()==0){
            //删除角色
            this.deleteBatchIds(Arrays.asList(roleIds));

            //删除角色与菜单关联
            roleMenuInfoService.deleteBatch(roleIds);

            //删除角色与用户关联
            userRoleInfoService.deleteBatch(roleIds);

            return ResponseResult.success();
        }else {
            return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"当前角色下有用户绑定，请先删除相关用户");
        }
    }


    @Override
    public List<Long> queryRoleIdList(Long createId) {
        return baseMapper.queryRoleIdList(createId);
    }

    /**
     * 检查权限是否越权
     */
    private void checkPrems(RoleBaseInfoEntity role) {
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserInfoService.queryAllMenuId(role.getCreateId());

        //判断是否越权
        if (!menuIdList.containsAll(role.getMenuIdList())) {
            log.error("新增角色的权限，已超出你的权限范围");
            return;
        }

    }
}