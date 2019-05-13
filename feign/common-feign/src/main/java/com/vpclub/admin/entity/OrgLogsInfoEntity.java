package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生组织隶属变更日志表
 *
 */
@Data
@TableName("org_logs_info")
public class OrgLogsInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键，全表唯一
	 */
	@TableId(value = "oli_num")
	private Integer orgLogsInfoId;
	/**
	 * 组织隶属信息表ID
	 */
	@TableField("oui_id")
	private Integer ouiId;
	/**
	 * 学校ID
	 */
	@TableField("ubi_id")
	private Integer ubiId;
	/**
	 * 学校名称
	 */
	@TableField("ubi_name")
	private String ubiName;
	/**
	 * 组织类型 ：1：学校；4：院系；5：支部；6：社团；7：学生会；8：研究生会；99：机关单位
	 */
	@TableField("oli_type")
	private Integer oliType;
	/**
	 * 类型名称
	 */
	@TableField("oli_type_name")
	private String oliTypeName;
	/**
	 * 机构ID
	 */
	@TableField("oli_ubi_id")
	private Integer oliUbiId;
	/**
	 * 机构名称
	 */
	@TableField("oli_ubi_name")
	private String oliUbiName;
	/**
	 * 学号
	 */
	@TableField("grade_code")
	private String gradeCode;
	/**
	 * 学生ID
	 */
	@TableField("uui_id")
	private Integer uuiId;
	/**
	 * 学生姓名
	 */
	@TableField("uui_name")
	private String uuiName;
	/**
	 * 有效开始时间
	 */
	@TableField("oli_start_date")
	private Date oliStartDate;
	/**
	 * 标签字段，组织职务等说明
	 */
	@TableField("oli_flag")
	private String oliFlag;
	/**
	 * 审核状态（默认为：1）0：正常；1：待审核；2：拒绝；3：其它
	 */
	@TableField("oli_status")
	private Integer oliStatus;
	/**
	 * 审核人ID
	 */
	@TableField("oli_check_id")
	private Integer oliCheckId;
	/**
	 * 审核人名称
	 */
	@TableField("oli_check_name")
	private String oliCheckName;
	/**
	 * 审核时间
	 */
	@TableField("oli_check_time")
	private Date oliCheckTime;
	/**
	 * 审核说明
	 */
	@TableField("oli_check_content")
	private String oliCheckContent;
	/**
	 * 创建时间.WEB服务器时间
	 */
	@TableField("create_date")
	private Date createDate;
}
