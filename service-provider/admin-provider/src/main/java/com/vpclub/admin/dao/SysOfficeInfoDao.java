package com.vpclub.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vpclub.admin.entity.SysOfficeInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 机构基础信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:10
 */
@Mapper
public interface SysOfficeInfoDao extends BaseMapper<SysOfficeInfoEntity> {


    Integer selectMaxSortNo();
	
}
