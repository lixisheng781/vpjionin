package com.vpclub.activitycheckinfo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动人员报名签到签退表#20161213#
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 09:46:53
 */
@TableName("activity_join_info")
public class ActivityJoinInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	private Long ajiNum;
	/**
	 * 
	 */
	private Long ubiId;
	/**
	 * 
	 */
	private Long abiId;
	/**
	 * 
	 */
	private Long amiId;
	/**
	 * 轮次
	 */
	private Integer joinTime;
	/**
	 * 轮次达标状态0、未达标 1达标
	 */
	private Integer joinTimeStatus;
	/**
	 * 1、报名 ，2、签到，3、签退
	 */
	private Integer joinType;
	/**
	 * 时间
	 */
	private Date joinDate;
	/**
	 * 报名资料附件url
	 */
	private String fileUrl;
	/**
	 * 
	 */
	private Long auditId;
	/**
	 * 审核说明
	 */
	private String auditContent;
	/**
	 * 审核人姓名
	 */
	private String auditName;
	/**
	 * 审核时间
	 */
	private Date auditDate;

	/**
	 * 设置：
	 */
	public void setAjiNum(Long ajiNum) {
		this.ajiNum = ajiNum;
	}

	/**
	 * 获取：
	 */
	public Long getAjiNum() {
		return ajiNum;
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
	 * 设置：
	 */
	public void setAmiId(Long amiId) {
		this.amiId = amiId;
	}

	/**
	 * 获取：
	 */
	public Long getAmiId() {
		return amiId;
	}

	/**
	 * 设置：轮次
	 */
	public void setJoinTime(Integer joinTime) {
		this.joinTime = joinTime;
	}

	/**
	 * 获取：轮次
	 */
	public Integer getJoinTime() {
		return joinTime;
	}

	/**
	 * 设置：轮次达标状态0、未达标 1达标
	 */
	public void setJoinTimeStatus(Integer joinTimeStatus) {
		this.joinTimeStatus = joinTimeStatus;
	}

	/**
	 * 获取：轮次达标状态0、未达标 1达标
	 */
	public Integer getJoinTimeStatus() {
		return joinTimeStatus;
	}

	/**
	 * 设置：1、报名 ，2、签到，3、签退
	 */
	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}

	/**
	 * 获取：1、报名 ，2、签到，3、签退
	 */
	public Integer getJoinType() {
		return joinType;
	}

	/**
	 * 设置：时间
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * 获取：时间
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * 设置：报名资料附件url
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	/**
	 * 获取：报名资料附件url
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * 设置：
	 */
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	/**
	 * 获取：
	 */
	public Long getAuditId() {
		return auditId;
	}

	/**
	 * 设置：审核说明
	 */
	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}

	/**
	 * 获取：审核说明
	 */
	public String getAuditContent() {
		return auditContent;
	}

	/**
	 * 设置：审核人姓名
	 */
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	/**
	 * 获取：审核人姓名
	 */
	public String getAuditName() {
		return auditName;
	}

	/**
	 * 设置：审核时间
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * 获取：审核时间
	 */
	public Date getAuditDate() {
		return auditDate;
	}
}
