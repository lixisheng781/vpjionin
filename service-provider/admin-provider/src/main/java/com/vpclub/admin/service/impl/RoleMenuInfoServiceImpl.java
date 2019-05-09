package com.vpclub.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.RoleMenuInfoDao;
import com.vpclub.admin.entity.RoleMenuInfoEntity;
import com.vpclub.admin.entity.SysRoleEntity;
import com.vpclub.admin.service.RoleMenuInfoService;
import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuInfoServiceImpl extends ServiceImpl<RoleMenuInfoDao, RoleMenuInfoEntity> implements RoleMenuInfoService {

    @Override
    public Result save(RoleMenuInfoEntity role) {
        log.info("RoleMenuInfoServiceImpl request save role  :  {}",role.toString());
        boolean back = this.insert(role);
        log.info("response  add  back  :  {}",back);
        Result result = ResponseResult.success(role);
        return result;
    }

    @Override
    public Result update(RoleMenuInfoEntity role) {
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
    public Result delete(RoleMenuInfoEntity role) {
        log.info("RoleMenuInfoServiceImpl request delete role  :  {}",role.toString());

        EntityWrapper<RoleMenuInfoEntity> ew = new EntityWrapper<>(role);
        //查询信息
        RoleMenuInfoEntity roleMenuInfo = this.selectOne(ew);
        if(roleMenuInfo!=null){
            //删除
            boolean back = this.delete(ew);
            log.info("response  delete  back  :  {}",back);
        }

        return ResponseResult.success();
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }
}
