package com.vpclub.admin.service.impl;


import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.admin.dao.SysUserTokenDao;
import com.vpclub.admin.entity.SysUserTokenEntity;
import com.vpclub.admin.service.SysUserTokenService;
import com.vpclub.admin.utils.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    Result result = ResponseResult.success();

    @Override
    public Result createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date nowTime = new Date();
        //时间类型转换
        Long now = System.currentTimeMillis();
        //过期时间
//		Date expireTime = new Date(nowTime.getTime() + EXPIRE * 1000);

        Long expireTime = (nowTime.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        SysUserTokenEntity tokenEntity = this.selectById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdatedTime(now);
            tokenEntity.setExpireTime(expireTime);
            tokenEntity.setCreatedBy(userId);
            tokenEntity.setCreatedTime(now);
            tokenEntity.setUpdatedBy(userId);

            //保存token
            this.insert(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdatedTime(now);
            tokenEntity.setExpireTime(expireTime);
            tokenEntity.setUpdatedBy(userId);
            //更新token
            this.updateById(tokenEntity);
        }

        result.setData(token);
        return result;
    }

    @Override
    public Result logout(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
        Result result = ResponseResult.success();
        result.setData(tokenEntity);
        return result;
    }
}
