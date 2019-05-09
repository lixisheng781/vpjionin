package com.vpclub.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.RoleOfficeInfoEntity;
import com.vpclub.result.Result;

/**
 * <p>
 * 系统角色机构权限 服务类
 * </p>
 *
 * @author yk
 * @since  2018-06-01
 */
public interface RoleOfficeInfoService extends IService<RoleOfficeInfoEntity> {
    Result save(RoleOfficeInfoEntity role);

    Result update(RoleOfficeInfoEntity role);

    Result delete(RoleOfficeInfoEntity role);
}
