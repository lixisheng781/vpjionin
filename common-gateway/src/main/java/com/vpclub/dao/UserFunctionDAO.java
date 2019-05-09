package com.vpclub.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.entity.UserFunctionDO;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author
 * @since 12-21
 */
@Repository
public interface UserFunctionDAO extends BaseMapper<UserFunctionDO> {

    /***
     * 获取排队鉴权的URL
     * @return
     */
    List<String> getIgnoreUrl();
}
