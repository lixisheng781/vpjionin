package com.vpclub.admin.client;


import com.vpclub.admin.entity.RoleBaseInfoEntity;
import com.vpclub.admin.model.request.SysRoleParam;
import com.vpclub.result.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * <P>
 *  系统角色 服务治理类
 * </P>
 * @author  yk
 * @since  2018-06-01
 */
@RequestMapping(value = "/roleBaseInfoClient")
public interface RoleBaseInfoClient {

    @RequestMapping(value = "queryPage",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result queryPage(SysRoleParam params);

    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result save(RoleBaseInfoEntity role);

    @RequestMapping(value = "update" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(RoleBaseInfoEntity role);

    @RequestMapping(value = "deleteBatch",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result deleteBatch(SysRoleParam params);

    @RequestMapping(value = "queryRoleIdList",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Long> queryRoleIdList(Long createdBy);

    @RequestMapping(value = "selectByParam",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    List<RoleBaseInfoEntity> selectByParam(RoleBaseInfoEntity entity);

    @RequestMapping(value = "selectById",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    RoleBaseInfoEntity selectById(Long roleId);
}
