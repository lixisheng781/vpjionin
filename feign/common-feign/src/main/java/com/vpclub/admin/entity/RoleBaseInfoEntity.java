package com.vpclub.admin.entity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统角色信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:09
 */
@lombok.Data
@TableName("role_base_info")
public class RoleBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	@TableId(value = "rbi_num")
	private Long roleId;
	/**
	 * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	@TableField("rbi_code")
	private String rbiCode;
	/**
	 * 学校ID
	 */
	@TableField("ubi_id")
	private Long schoolId;
	/**
	 * 系统角色信息名称
	 */
	@TableField("rbi_name")
	private String roleName;
	/**
	 * 角色英文名称
	 */
	@TableField("rbi_enname")
	private String roleEnname;
	/**
	 * 角色类型
	 */
	@TableField("rbi_type")
	private Integer roleType;
	/**
	 * 数据范围（0：所有数据；1：所在公司及以下数据；2：所在公司数据；3：所在部门及以下数据；4：所在部门数据；8：仅本人数据；9：按明细设置）
	 */
	@TableField("rbi_datatype")
	private Integer rbiDatatype;
	/**
	 * 是否系统数据,“是”代表此数据只有超级管理员能进行修改，“否”则表示拥有角色修改人员的权限都能进行修改
	 */
	@TableField("is_sysdata")
	private Integer isSysdata;
	/**
	 * 是否显示,1为显示(默认), 0为不显示
	 */
	@TableField("is_show")
	private Integer isShow;
	/**
	 * 备注字段，关联备注表ID
	 */
	@TableField("sri_id")
	private Long sysRemarkId;
	/**
	 * 排序字段
	 */
	@TableField("sortno")
	private Integer sortno;
	/**
	 * 逻辑删除标志位，0为正常，1为删除
	 */
	@TableField("del_flag")
	private Integer delFlag;
	/**
	 * 创建时间.WEB服务器时间
	 */
	@TableField("create_date")
	private Date createDate;
	/**
	 * 创建人ID
	 */
	@TableField("create_id")
	private Long createId;
	/**
	 * 创建人名称
	 */
	@TableField("create_name")
	private String createName;
	/**
	 * 最近修改时间.WEB服务器时间
	 */
	@TableField("update_date")
	private Date updateDate;
	/**
	 * 最近修改人ID
	 */
	@TableField("update_id")
	private Long updateId;
	/**
	 * 最近修改人名称
	 */
	@TableField("update_name")
	private String updateName;
	/**
	 * 隶属院系ID
	 */
	@TableField("uoi_id")
	private Long organizationId;

	@TableField(exist=false)
	private List<Long> menuIdList;

}
