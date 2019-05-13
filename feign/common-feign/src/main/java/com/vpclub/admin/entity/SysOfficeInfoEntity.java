package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构基础信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:10
 */
@Data
@TableName("sys_office_info")
public class SysOfficeInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键，全表唯一
	 */
    @TableId(value = "ubi_num")
	private Long sysOfficeInfoId;
	/**
	 * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	@TableField("ubi_code")
	private String ubiCode;
	/**
	 * 机构编码，用户自定义，一般较短，全表或一定范围唯一
	 */
	@TableField("ubi_no")
	private String ubiNo;
	/**
	 * 机构全称
	 */
	@TableField("full_name")
	private String fullName;
	/**
	 * 机构简称,快捷搜索字符串
	 */
	@TableField("short_name")
	private String shortName;
	/**
	 * 机构英文名称
	 */
	@TableField("english_name")
	private String englishName;
	/**
	 * 机构类型（0：公司，1：学校；2：分校；3：学院，4：院系）
	 */
	@TableField("ubi_type")
	private Integer ubiType;
	/**
	 * 父级ID
	 */
	@TableField("pid")
	private Long pid;
	/**
	 * 树型路径
	 */
	@TableField("path")
	private String path;
	/**
	 * 机构等级（1：一级；2：二级；3：三级；4：四级）
	 */
	@TableField("ubi_grade")
	private Integer ubiGrade;
	/**
	 * 机构所属行政区域ID(关联到行政区域信息表)
	 */
	@TableField("sai_id")
	private Long sysAreaInfoId;
	/**
	 * 机构详细地址
	 */
	@TableField("ubi_address")
	private String ubiAddress;
	/**
	 * 邮编
	 */
	@TableField("zip_code")
	private String zipCode;
	/**
	 * 机构负责人
	 */
	@TableField("ubi_master")
	private String ubiMaster;
	/**
	 * 主负责人
	 */
	@TableField("primary_person")
	private String primaryPerson;
	/**
	 * 副负责人
	 */
	@TableField("deputy_person")
	private String deputyPerson;
	/**
	 * 机构电话
	 */
	@TableField("ubi_telephone")
	private String ubiTelephone;
	/**
	 * 机构传真
	 */
	@TableField("ubi_fax")
	private String ubiFax;
	/**
	 * 机构EMAIL
	 */
	@TableField("ubi_mail")
	private String ubiMail;
	/**
	 * 机构网址
	 */
	@TableField("ubi_url")
	private String ubiUrl;
	/**
	 * 附件文件
	 */
	@TableField("files_img_url")
	private String filesImgUrl;
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
	 * 数据状态，默认是0，表示正常
	 */
	@TableField("is_state")
	private Integer isState;
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
	 * 学年应修学分#20161213#
	 */
	@TableField("ubi_credit")
	private Integer ubiCredit;
	/**
	 * 是否是特优班
	 */
	@TableField("is_gifted_class")
	private Integer isGiftedClass;
	/**
	 * #20171012#应修活动单位名称
	 */
	@TableField("ubi_creditName")
	private String ubiCreditname;
	/**
	 * 
	 */
	@TableField("ubi_calendar_flag")
	private Integer ubiCalendarFlag;
	/**
	 * 
	 */
	@TableField("calendar_start_time")
	private Date calendarStartTime;
	/**
	 * 
	 */
	@TableField("calendar_end_time")
	private Date calendarEndTime;
	/**
	 * 
	 */
	@TableField("ubi_credit_flag")
	private Integer ubiCreditFlag;
	/**
	 * 
	 */
	@TableField("credit_times")
	private Integer creditTimes;
	/**
	 * 
	 */
	@TableField("credit_cycle_time")
	private Date creditCycleTime;
	/**
	 * 组织机构介绍，大文本表id#20180510#
	 */
	@TableField("presentation_id")
	private Long presentationId;
	/**
	 * 组织机构章程，大文本表id#20180510#
	 */
	@TableField("constitution_id")
	private Long constitutionId;

}
