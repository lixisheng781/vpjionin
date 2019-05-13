package com.vpclub.admin.client;


import com.vpclub.admin.entity.SysUserInfoEntity;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import com.vpclub.admin.common.validator.Assert;
import com.vpclub.admin.common.validator.ValidatorUtils;
import com.vpclub.admin.common.validator.group.AddGroup;
import com.vpclub.admin.common.validator.group.UpdateGroup;
import com.vpclub.admin.model.request.PasswordForm;
import com.vpclub.admin.model.request.SysUserParam;
import com.vpclub.admin.service.SysUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户
 * @author lixisheng
 */
@RestController
@RequestMapping("/admin/sys/user")
@Slf4j
public class SysUserInfoController extends AbstractController {
    @Autowired
    private SysUserInfoService sysUserInfoService;




    /**
     * 所有用户列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysUserParam params) {
        Result result = new Result();
        //只有超级管理员，才能查看所有管理员列表
//        if (getUserId() != Constant.SUPER_ADMIN) {
//            result.setMsg("你不是超级管理员，不能查看所有管理员列表");
//        }
        result = sysUserInfoService.page(params);
        return result;
    }



    /**
     * 修改登录用户密码
     */
    @PostMapping("/password")
    public Result password(@RequestBody PasswordForm form) {
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");



        return ResponseResult.success();
    }

    /**
     * 当前登陆用户信息
     */
    @PostMapping("/info")
    public Result info() {
        Result result = ResponseResult.success();
        try {
            Long userId = this.getUserId();
            SysUserInfoEntity user;
            if (null != userId && userId.intValue() > 0) {

                user = sysUserInfoService.selectById(userId);
                result.setData(user);
                return result;
            } else {
                user = getUser();
                result.setData(user);
                return result;
            }
        } catch (Exception e) {
            log.error("错误日志 ：",e);
            return ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR);
        }
    }

    /**
     * 用户信息
     */
    @PostMapping("/querUserinfo")
    public Result info(@RequestBody SysUserParam param){
        SysUserInfoEntity user = sysUserInfoService.selectById(param.getUserId());

        return ResponseResult.success(user);
    }

    /**
     * 保存用户
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysUserInfoEntity user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);
        log.info("user: " + user.toString());

        return sysUserInfoService.save(user);
    }

    /**
     * 修改用户密码
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysUserInfoEntity user) {
        try {
            ValidatorUtils.validateEntity(user, UpdateGroup.class);

            if (user.getUserId() == null){
                return ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR, "操作用户id不能为空");
            }

            sysUserInfoService.update(user);


            return ResponseResult.success();
        } catch (Exception e) {
            log.error("错误日志 ：",e);
            return ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR, "修改用户失败");
        }
    }

    /**
     * 删除用户
     */
    @PostMapping("/delete")
    public Result delete(@RequestBody SysUserParam param) {
        List<Long> userIds = param.getIdList();
        if (userIds.contains(1)) {
            return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST, "系统管理员不能删除");
        }

//        if (userIds.contains(1)) {
//            return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST, "当前用户不能删除");
//        }

        sysUserInfoService.deleteByUserId(param);

        return ResponseResult.success();
    }

    @PostMapping("/queryByParentIdList")
    public Result queryByParentIdList() {
        Result result = ResponseResult.success();
        //获取当前登陆用户信息
        SysUserInfoEntity user = getUser();

        List<SysUserInfoEntity> listParentId = new ArrayList<>();

        result.setData(listParentId);
        return result;
    }
}
