package com.vpclub.admin.client;

import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.result.Result;
import com.vpclub.admin.model.request.SysUserParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by chentao on 2018/5/31.
 */
@RequestMapping("/sysUserInfoClient")
public interface SysUserInfoClient {


    @RequestMapping(value = "queryByPhone",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    SysUserInfoEntity queryByPhone(@RequestBody SysUserInfoEntity mobileuser);

    @RequestMapping(value = "queryPage",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result queryPage(@RequestBody SysUserParam params);

    @RequestMapping(value = "page",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result page(@RequestBody SysUserParam params);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    @RequestMapping(value = "queryAllPerms",method = RequestMethod.GET)
    List<String> queryAllPerms(@RequestParam("userId") Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    @RequestMapping(value = "queryAllMenuId")
    List<Long> queryAllMenuId(@RequestParam("userId") Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    @RequestMapping(value = "queryByUserName",method = RequestMethod.GET)
    SysUserInfoEntity queryByUserName(@RequestParam("userName") String userName);

    /**
     * 保存用户
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Result save(@RequestBody SysUserInfoEntity user);

    /**
     * 修改用户
     */
    @RequestMapping(value = "update",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody SysUserInfoEntity user);

    /**
     * 删除用户
     */
    @RequestMapping(value = "deleteBatch",method = RequestMethod.GET)
    void deleteBatch(@RequestParam("userIds") Long[] userIds);

    /**
     * 修改密码
     * @param userId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    boolean updatePassword(@RequestParam("userId") Long userId, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword);

    /***
     * 更新删除标记，0表示删除
     */
    @RequestMapping(value = "deleteByUserId",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteByUserId(@RequestBody SysUserParam params);
    @RequestMapping(value = "register",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void register(@RequestBody SysUserInfoEntity registerUser);

    @RequestMapping(value = "selectById")
    SysUserInfoEntity selectById(@RequestParam("userId") Long userId);
}
