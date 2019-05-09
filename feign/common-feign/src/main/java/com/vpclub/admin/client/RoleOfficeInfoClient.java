package com.vpclub.admin.client;

import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.RoleOfficeInfoEntity;
import com.vpclub.result.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <P>
 *  系统角色机构权限 服务治理类
 * </P>
 * @author  yk
 * @since  2018-06-01
 */
@RequestMapping(value = "/roleOfficeInfoService")
public interface RoleOfficeInfoClient {

    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result save(@RequestBody RoleOfficeInfoEntity role);

    @RequestMapping(value = "update" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result update(@RequestBody RoleOfficeInfoEntity role);

    @RequestMapping(value = "delete" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result delete(@RequestBody RoleOfficeInfoEntity role);
}
