package com.vpclub.admin.entity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统角色信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:09
 */
@lombok.Data
@TableName("role_base_info")
public class SysRoleEntity  implements Serializable {
	private static final long serialVersionUID = 1L;


	@TableId(value = "rbi_num")
	private Long roleId;
	/**
	 * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	private String rbiCode;
	/**
	 * 
	 */
	private Long ubiId;
	/**
	 * 系统角色信息名称
	 */
	@TableField("rbi_name")
	private String roleName;
	/**
	 * 角色英文名称
	 */
	private String rbiEnname;
	/**
	 * 角色类型
	 */
	private Integer rbiType;
	/**
	 * 数据范围（0：所有数据；1：所在公司及以下数据；2：所在公司数据；3：所在部门及以下数据；4：所在部门数据；8：仅本人数据；9：按明细设置）
	 */
	private Integer rbiDatatype;
	/**
	 * 是否系统数据,“是”代表此数据只有超级管理员能进行修改，“否”则表示拥有角色修改人员的权限都能进行修改
	 */
	private Integer isSysdata;
	/**
	 * 是否显示,1为显示(默认), 0为不显示
	 */
	private Integer isShow;
	/**
	 * 
	 */
	private Long sriId;
	/**
	 * 排序字段
	 */
	private Integer sortno;
	/**
	 * 逻辑删除标志位，0为正常，1为删除
	 */
	private Integer delFlag;
	/**
	 * 创建时间.WEB服务器时间
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Long createId;
	/**
	 * 创建人名称
	 */
	private String createName;
	/**
	 * 最近修改时间.WEB服务器时间
	 */
	private Date updateDate;
	/**
	 * 
	 */
	private Long updateId;
	/**
	 * 最近修改人名称
	 */
	private String updateName;
	/**
	 * 
	 */
	private Long uoiId;

}
