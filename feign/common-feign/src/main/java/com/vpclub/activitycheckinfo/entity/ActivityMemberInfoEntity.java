package com.vpclub.activitycheckinfo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动人员信息表#20161213#
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 10:41:26
 */
@TableName("activity_member_info")
public class ActivityMemberInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	private Long amiNum;
	/**
	 * 
	 */
	private Long ubiId;
	/**
	 * 
	 */
	private Long udiId;
	/**
	 * 
	 */
	private Long abiId;
	/**
	 * 0、创建人员，1、发起人员，2,、组织人员，3、报名人员
	 */
	private Integer amiUserType;
	/**
	 * 
	 */
	private Long amiUserId;
	/**
	 * 人员名称
	 */
	private String amiUserName;
	/**
	 * 人员学号
	 */
	private String amiUserNo;
	/**
	 * 审核状态0、通过 1、，待审核 ，2不通过
	 */
	private Integer amiAuditStatus;
	/**
	 * 0、未结束，1、达标，2、未达标
	 */
	private Integer isUpStandard;
	/**
	 * 学分
	 */
	private BigDecimal amiCredit;
	/**
	 * 评分
	 */
	private BigDecimal amiGrade;
	/**
	 * 活动结束时统一赋值
	 */
	private Date abiEndTime;
	/**
	 * #20170329#逻辑删除，0正常，1删除
	 */
	private Integer delFlag;
	/**
	 * #20170608#最近修改时间.WEB服务器时间
	 */
	private Date updateDate;
	/**
	 * 
	 */
	private Long updateId;
	/**
	 * #20170608#最近修改人名称
	 */
	private String updateName;
	/**
	 * 
	 */
	private Long amiAllowId;
	/**
	 * 活动状态，0为待审核（默认），1为待开始，2为进行中，3为结束，4为完成，5为审核不通过 6、取消 7、草稿 8、审核中
	 */
	private Integer abiStatus;

	/**
	 * 设置：
	 */
	public void setAmiNum(Long amiNum) {
		this.amiNum = amiNum;
	}

	/**
	 * 获取：
	 */
	public Long getAmiNum() {
		return amiNum;
	}

	/**
	 * 设置：
	 */
	public void setUbiId(Long ubiId) {
		this.ubiId = ubiId;
	}

	/**
	 * 获取：
	 */
	public Long getUbiId() {
		return ubiId;
	}

	/**
	 * 设置：
	 */
	public void setUdiId(Long udiId) {
		this.udiId = udiId;
	}

	/**
	 * 获取：
	 */
	public Long getUdiId() {
		return udiId;
	}

	/**
	 * 设置：
	 */
	public void setAbiId(Long abiId) {
		this.abiId = abiId;
	}

	/**
	 * 获取：
	 */
	public Long getAbiId() {
		return abiId;
	}

	/**
	 * 设置：0、创建人员，1、发起人员，2,、组织人员，3、报名人员
	 */
	public void setAmiUserType(Integer amiUserType) {
		this.amiUserType = amiUserType;
	}

	/**
	 * 获取：0、创建人员，1、发起人员，2,、组织人员，3、报名人员
	 */
	public Integer getAmiUserType() {
		return amiUserType;
	}

	/**
	 * 设置：
	 */
	public void setAmiUserId(Long amiUserId) {
		this.amiUserId = amiUserId;
	}

	/**
	 * 获取：
	 */
	public Long getAmiUserId() {
		return amiUserId;
	}

	/**
	 * 设置：人员名称
	 */
	public void setAmiUserName(String amiUserName) {
		this.amiUserName = amiUserName;
	}

	/**
	 * 获取：人员名称
	 */
	public String getAmiUserName() {
		return amiUserName;
	}

	/**
	 * 设置：人员学号
	 */
	public void setAmiUserNo(String amiUserNo) {
		this.amiUserNo = amiUserNo;
	}

	/**
	 * 获取：人员学号
	 */
	public String getAmiUserNo() {
		return amiUserNo;
	}

	/**
	 * 设置：审核状态0、通过 1、，待审核 ，2不通过
	 */
	public void setAmiAuditStatus(Integer amiAuditStatus) {
		this.amiAuditStatus = amiAuditStatus;
	}

	/**
	 * 获取：审核状态0、通过 1、，待审核 ，2不通过
	 */
	public Integer getAmiAuditStatus() {
		return amiAuditStatus;
	}

	/**
	 * 设置：0、未结束，1、达标，2、未达标
	 */
	public void setIsUpStandard(Integer isUpStandard) {
		this.isUpStandard = isUpStandard;
	}

	/**
	 * 获取：0、未结束，1、达标，2、未达标
	 */
	public Integer getIsUpStandard() {
		return isUpStandard;
	}

	/**
	 * 设置：学分
	 */
	public void setAmiCredit(BigDecimal amiCredit) {
		this.amiCredit = amiCredit;
	}

	/**
	 * 获取：学分
	 */
	public BigDecimal getAmiCredit() {
		return amiCredit;
	}

	/**
	 * 设置：评分
	 */
	public void setAmiGrade(BigDecimal amiGrade) {
		this.amiGrade = amiGrade;
	}

	/**
	 * 获取：评分
	 */
	public BigDecimal getAmiGrade() {
		return amiGrade;
	}

	/**
	 * 设置：活动结束时统一赋值
	 */
	public void setAbiEndTime(Date abiEndTime) {
		this.abiEndTime = abiEndTime;
	}

	/**
	 * 获取：活动结束时统一赋值
	 */
	public Date getAbiEndTime() {
		return abiEndTime;
	}

	/**
	 * 设置：#20170329#逻辑删除，0正常，1删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取：#20170329#逻辑删除，0正常，1删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * 设置：#20170608#最近修改时间.WEB服务器时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取：#20170608#最近修改时间.WEB服务器时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置：
	 */
	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	/**
	 * 获取：
	 */
	public Long getUpdateId() {
		return updateId;
	}

	/**
	 * 设置：#20170608#最近修改人名称
	 */
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	/**
	 * 获取：#20170608#最近修改人名称
	 */
	public String getUpdateName() {
		return updateName;
	}

	/**
	 * 设置：
	 */
	public void setAmiAllowId(Long amiAllowId) {
		this.amiAllowId = amiAllowId;
	}

	/**
	 * 获取：
	 */
	public Long getAmiAllowId() {
		return amiAllowId;
	}

	/**
	 * 设置：活动状态，0为待审核（默认），1为待开始，2为进行中，3为结束，4为完成，5为审核不通过 6、取消 7、草稿 8、审核中
	 */
	public void setAbiStatus(Integer abiStatus) {
		this.abiStatus = abiStatus;
	}

	/**
	 * 获取：活动状态，0为待审核（默认），1为待开始，2为进行中，3为结束，4为完成，5为审核不通过 6、取消 7、草稿 8、审核中
	 */
	public Integer getAbiStatus() {
		return abiStatus;
	}
}
