package com.vpclub.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.RoleOfficeInfoDao;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.RoleOfficeInfoEntity;
import com.vpclub.admin.service.RoleOfficeInfoService;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleOfficeInfoServiceImpl extends ServiceImpl<RoleOfficeInfoDao, RoleOfficeInfoEntity> implements RoleOfficeInfoService {

    @Override
    public Result save(RoleOfficeInfoEntity role) {
        log.info("RoleMenuInfoServiceImpl request save role  :  {}",role.toString());
        boolean back = this.insert(role);
        log.info("response  add  back  :  {}",back);
        Result result = ResponseResult.success(role);
        return result;
    }

    @Override
    public Result update(RoleOfficeInfoEntity role) {
        log.info("RoleMenuInfoServiceImpl request update role  :  {}",role.toString());
        Result result ;
        if (null == role || null == role.getRoleId()) {
            result= ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST,"角色ID未传入");
        } else {
            boolean back = this.updateById(role);
            log.info("response  update  back  :  {}",back);
            result = ResponseResult.success();
        }
        return result;
    }

    @Override
    public Result delete(RoleOfficeInfoEntity role) {
        log.info("RoleMenuInfoServiceImpl request delete role  :  {}",role.toString());

        EntityWrapper<RoleOfficeInfoEntity> ew = new EntityWrapper<>(role);
        //查询信息
        RoleOfficeInfoEntity roleMenuInfo = this.selectOne(ew);
        if(roleMenuInfo!=null){
            //删除
            boolean back = this.delete(ew);
            log.info("response  delete  back  :  {}",back);
        }

        return ResponseResult.success();
    }
}
