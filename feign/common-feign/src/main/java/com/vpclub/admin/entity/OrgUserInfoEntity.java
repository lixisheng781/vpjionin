package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生组织隶属信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:09
 */
@Data
@TableName("org_user_info")
public class OrgUserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "oui_num")
	private Long orgUserInfoId;
	/**
	 * 学校ID
	 */
	@TableField("ubi_id")
	private Long schoolId;
	/**
	 * 组织类型 ：1：学校；4：院系；5：支部；6：社团；7：学生会；8：研究生会；99：机关单位
	 */
	@TableField("oui_type")
	private Integer organizationType;
	/**
	 * 机构ID
	 */
	@TableField("oui_ubi_id")
	private Long organizationId;
	/**
	 * 审核状态（默认为：1）0：正常；1：待审核；2：拒绝
	 */
	@TableField("oui_status")
	private Integer ouiStatus;
	/**
	 * 审核人ID
	 */
	@TableField("oui_check_id")
	private Long ouiCheckId;
	/**
	 * 审核人名称
	 */
	@TableField("oui_check_name")
	private String ouiCheckName;
	/**
	 * 审核时间
	 */
	@TableField("oui_check_time")
	private Date ouiCheckTime;
	/**
	 * 审核说明
	 */
	@TableField("oui_content")
	private String ouiContent;
	/**
	 * 有效开始时间
	 */
	@TableField("oui_start_date")
	private Date ouiStartDate;
	/**
	 * 标签字段，组织职务等说明
	 */
	@TableField("oui_flag")
	private String ouiFlag;
	/**
	 * 是否可隶属管理：0：不隶属；1:隶属（默认为：0）
	 */
	@TableField("is_subjection")
	private Integer isSubjection;
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
	 * 创建时间.WEB服务器时间
	 */
	@TableField("create_date")
	private Date createDate;
	/**
	 * 备注字段，关联备注表ID
	 */
	@TableField("sri_id")
	private Long sysRemarkId;
	/**
	 * #20170608#逻辑删除标志位，0为正常，1为删除
	 */
	@TableField("del_flag")
	private Integer delFlag;

}
