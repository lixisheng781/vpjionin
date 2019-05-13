package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关联表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:09
 */
@Data
@TableName("user_role_info")
public class UserRoleInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "uri_seq")
	private Long userRoleInfoId;
	/**
	 * 
	 */
	@TableField("uui_id")
	private Long userId;
	/**
	 * 
	 */
	@TableField("rbi_id")
	private Long roleId;
}
