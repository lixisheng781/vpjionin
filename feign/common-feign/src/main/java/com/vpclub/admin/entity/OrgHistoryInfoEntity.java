package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生组织隶属历史信息表
 *
 */
@Data
@TableName("org_history_info")
public class OrgHistoryInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "ohi_num")
	private Long orgHistoryInfoId;
	/**
	 * 学校ID
	 */
	@TableField("ubi_id")
	private Long schoolId;
	/**
	 * 组织类型 ：1：学校；4：院系；5：支部；6：社团；7：学生会；8：研究生会；99：机关单位
	 */
	@TableField("ohi_type")
	private Integer organizationType;
	/**
	 * 机构ID
	 */
	@TableField("ohi_ubi_id")
	private Long organizationId;
	/**
	 * 学生ID
	 */
	@TableField("uui_id")
	private Long userId;
	/**
	 * 学生姓名
	 */
	@TableField("uui_name")
	private String userName;
	/**
	 * 状态(默认为0)  0：正常变更；1：其它
	 */
	@TableField("ohi_state")
	private Integer ohiState;
	/**
	 * 有效开始时间
	 */
	@TableField("ohi_start_date")
	private Date ohiStartDate;
	/**
	 * 离开组织时间
	 */
	@TableField("ohi_leave_date")
	private Date ohiLeaveDate;
	/**
	 * 标签字段，组织职务等说明
	 */
	@TableField("ohi_flag")
	private String ohiFlag;
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
	 * 备注字段，关联备注表ID
	 */
	@TableField("sri_id")
	private Long sysRemarkId;
}
