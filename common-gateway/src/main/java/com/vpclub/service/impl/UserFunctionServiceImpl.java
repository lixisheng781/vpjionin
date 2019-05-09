package com.vpclub.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vpclub.dao.UserFunctionDAO;
import com.vpclub.entity.UserFunctionDO;
import com.vpclub.service.UserFunctionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 12-21
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserFunctionServiceImpl extends ServiceImpl<UserFunctionDAO, UserFunctionDO> implements UserFunctionService {

    @Resource
    private UserFunctionDAO userFunctionDAO;


    @Override
    public List<String> getIgnoreUrl() {
        return userFunctionDAO.getIgnoreUrl();
    }
}
