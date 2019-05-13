package com.vpclub.admin.client;

import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.result.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <P>
 *  系统角色权限范围隶属 服务治理类
 * </P>
 * @author  yk
 * @since  2018-06-01
 */
@RequestMapping(value = "/roleMenuInfoClient")
public interface RoleMenuInfoClient {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    @RequestMapping(value = "queryMenuIdList",method = RequestMethod.GET)
    List<Long> queryMenuIdList(@RequestParam("roleId") Long roleId);

    /**
     * 根据角色ID数组，批量删除
     */
    @RequestMapping(value = "deleteBatch")
    int deleteBatch(SysRoleParam params);
}
