package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统角色权限范围隶属
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:09
 */
@lombok.Data
@TableName("role_menu_info")
public class RoleMenuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "rmi_seq")
	private Long rmieq;
	/**
	 * 
	 */
	@TableId(value = "rbi_id")
	private Long roleId;
	/**
	 * 
	 */
	private Long mbiId;
}
