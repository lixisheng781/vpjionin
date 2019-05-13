package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 待验证注册用户数据信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:08
 */
@Data
@TableName("sys_check_user")
public class SysCheckUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "ucu_num")
	private Long sysCheckUserId;
	/**
	 * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	@TableField("ucu_code")
	private String ucuCode;
	/**
	 * 机构id
	 */
	@TableField("ubi_id")
	private Long schoolId;
	/**
	 * 隶属机构名称
	 */
	@TableField("ubi_name")
	private String schoolName;
	/**
	 * 院系id
	 */
	@TableField("uoi_id")
	private Long organizationId;
	/**
	 * 隶属院系名称
	 */
	@TableField("uoi_name")
	private String organizationName;
	/**
	 * 学号
	 */
	@TableField("grade_code")
	private String gradeCode;
	/**
	 * 姓名
	 */
	@TableField("ucu_name")
	private String ucuName;
	/**
	 * 邮箱地址
	 */
	@TableField("ucu_mail")
	private String ucuMail;
	/**
	 * 性别（0表示女，1表示男）
	 */
	@TableField("ucu_sex")
	private Integer ucuSex;
	/**
	 * 职员的身份证号码
	 */
	@TableField("ucu_idcard")
	private String ucuIdcard;
	/**
	 * 数据状态，默认是0，表示正常，1表示已注册
	 */
	@TableField("is_state")
	private Integer isState;
	/**
	 * 
	 */
	@TableField("sri_id")
	private Long sriId;
	/**
	 * 创建时间.WEB服务器时间
	 */
	@TableField("create_date")
	private Date createDate;
	/**
	 * 
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
	 * 
	 */
	@TableField("update_id")
	private Long updateId;
	/**
	 * 最近修改人名称
	 */
	@TableField("update_name")
	private String updateName;
	/**
	 * 用户类型1老师 2学生
	 */
	@TableField("ucu_type")
	private Integer ucuType;
	/**
	 * 民族
	 */
	@TableField("ucu_nation")
	private String ucuNation;
	/**
	 * 籍贯
	 */
	@TableField("ucu_native_place")
	private String ucuNativePlace;
	/**
	 * 学制
	 */
	@TableField("ucu_edu_year")
	private Integer ucuEduYear;
	/**
	 * 年级
	 */
	@TableField("ucu_grade")
	private Integer ucuGrade;
	/**
	 * 学科类别
	 */
	@TableField("ucu_edu_type")
	private String ucuEduType;
	/**
	 * 学历类型 0 本科生 1研究生
	 */
	@TableField("ucu_education")
	private Integer ucuEducation;
	/**
	 * 专业码
	 */
	@TableField("ucu_zym")
	private String ucuZym;
	/**
	 * 学校专业名称
	 */
	@TableField("ucu_zymc")
	private String ucuZymc;

}
