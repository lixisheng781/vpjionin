package com.vpclub.admin.client;

import com.vpclub.admin.entity.RoleMenuInfoEntity;
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
@RequestMapping(value = "/roleMenuInfoService")
public interface RoleMenuInfoClient {
    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result save(@RequestBody RoleMenuInfoEntity role);

    @RequestMapping(value = "update" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result update(@RequestBody RoleMenuInfoEntity role);

    @RequestMapping(value = "delete" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result delete(@RequestBody RoleMenuInfoEntity role);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    @RequestMapping(value = "queryMenuIdList",method = RequestMethod.GET)
    List<Long> queryMenuIdList(@RequestParam("roleId") Long roleId);
}
