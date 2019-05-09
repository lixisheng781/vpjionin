package com.vpclub.activitybaseinfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 10:41:28
 */
@TableName("activity_base_info")
@ToString
public class ActivityBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.INPUT)
	private Long abiNum;
	/**
	 * 
	 */
	private Long ubiId;
	/**
	 * 活动名称
	 */
	private String abiName;
	/**
	 * 活动标签名称
	 */
	private String abiCategory;
	/**
	 * 活动主办方名称
	 */
	private String abiSponsor;
	/**
	 * 活动承办方名称
	 */
	private String abiOrganizer;
	/**
	 * 父级ID
	 */
	private Integer pid;
	/**
	 * 活动目的
	 */
	private String abiPurpose;
	/**
	 * 活动简介
	 */
	private String abiDescription;
	/**
	 * 活动图片，最多6张图片
	 */
	private String imgUrl;
	/**
	 * 活动banner图，最多一张
	 */
	private String bannerUrl;
	/**
	 * 活动附件
	 */
	private String fileUrl;
	/**
	 * 开始时间
	 */
	private Date abiStartTime;
	/**
	 * 结束时间
	 */
	private Date abiEndTime;
	/**
	 * 报名截止时间
	 */
	private Date abiRegistrationDeadline;
	/**
	 * 允许报名人数
	 */
	private Integer limitSignNum;
	/**
	 * 实际报名人数
	 */
	private Integer abiSignNum;
	/**
	 * 已报名人数
	 */
	private Integer abiEnrollmentNum;
	/**
	 * 签到人数
	 */
	private Integer abiCheckNum;
	/**
	 * 活动预算最低，单位元
	 */
	private Integer abiMinBudget;
	/**
	 * 活动预算最高，单位元
	 */
	private Integer abiMaxBudget;
	/**
	 * 活动地点
	 */
	private String abiGpsPlace;
	/**
	 * 活动地点定位经度
	 */
	private BigDecimal abiGpsLng;
	/**
	 * 活动地点定位纬度
	 */
	private BigDecimal abiGpsLat;
	/**
	 * 活动微页面,预留
	 */
	private String abiDetailedInfo;
	/**
	 * 权重，越大越靠前
	 */
	private Integer abiWeight;
	/**
	 * 权重期限，过期后将权重设置为：0
	 */
	private Date abiWeightDate;
	/**
	 * 是否报销，0为不需报销（默认），1为需要报销
	 */
	private Integer haveExpenses;
	/**
	 * 是否允许评论，0为允许,公开评论（默认），1为允许,参与活动人员评论，2为不允许
	 */
	private Integer allowComment;
	/**
	 * 评论是否审核，0为不审核（默认），1位审核
	 */
	private Integer commentAudit;
	/**
	 * 报名方式，0为公开报名（默认），1为审核报名  ,2为报名状态已满
	 */
	private Integer abiSignOpen;
	/**
	 * 审核状态，0为待审核（默认），1为未通过，2为已通过
	 */
	private Integer auditStatus;
	/**
	 * 审核时间
	 */
	private Date auditTime;
	/**
	 * 审核说明
	 */
	private String auditContent;
	/**
	 * 活动状态，0为审核中（默认），1为待开始，2为进行中，3为结束，4为完成，5为审核不通过
	 */
	private Integer abiStatus;
	/**
	 * 
	 */
	private Long sriId;
	/**
	 * 排序字段
	 */
	private Integer sortno;
	/**
	 * 活动负责人
	 */
	private String abiChargeName;
	/**
	 * 负责人学号
	 */
	private String abiChargeNo;
	/**
	 * 负责人联系方式
	 */
	private String abiChargeMobile;
	/**
	 * 活动负责人
	 */
	private String abiSupervisorName;
	/**
	 * 监管人联系方式
	 */
	private String abiSupervisorMobile;
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
	 * #20160926#1是学校，2,3原来是分校、院（现此两项停用），4、院系 （下面有院系、4以后的，99以前的）， 5、支部，6、社团，7、学生会，8、研究生会，。。。。（预留分类）。。。99、机关单位
	 */
	private Integer abiRangeType;
	/**
	 * 
	 */
	private Long abiRangeId;
	/**
	 * #20160926#1是学校，2,3原来是分校、院（现此两项停用），4、院系 （下面有院系、4以后的，99以前的）， 5、支部，6、社团，7、学生会，8、研究生会，。。。。（预留分类）。。。99、机关单位
	 */
	private Integer abiPublishType;
	/**
	 * 
	 */
	private Long abiPublishId;
	/**
	 * #20160926#报名开始时间
	 */
	private Date signStartTime;
	/**
	 * #20160926#0不可以1可以
	 */
	private Integer isCanCancel;
	/**
	 * #20160926#0、不需要签到1、普通签到2、扫描签到3、管理员扫描签到4验票签到
	 */
	private Integer signinType;
	/**
	 * #20160926#签到开始时间
	 */
	private Date signinStartTime;
	/**
	 * #20160926#签到截止时间
	 */
	private Date signinEndTime;
	/**
	 * #20160926#0、不需要签退1、普通签退2、扫描签退3、管理员扫描签退4验票签退
	 */
	private Integer signoutType;
	/**
	 * #20160926#签退开始时间
	 */
	private Date signoutStartTime;
	/**
	 * #20160926#签退截止时间
	 */
	private Date signoutEndTime;
	/**
	 * #20160926#提醒时间
	 */
	private Date remindTime;
	/**
	 * #20160926#提醒时间次数，0为不提醒
	 */
	private Integer remindTimes;
	/**
	 * #20160926#提醒内容
	 */
	private String remindContent;
	/**
	 * #20160926#审核流次数，一次完整的活动审核流为一次
	 */
	private Integer auditTimes;
	/**
	 * #20161027#签退人数
	 */
	private Integer abiSignoutNum;
	/**
	 * #20161213#0、允许 1、不允许
	 */
	private Integer isArtificialMark;
	/**
	 * #20161213#发起最大签到轮次
	 */
	private Integer maxSignTimes;
	/**
	 * #20161213#达标签到轮次
	 */
	private Integer mustSignTimes;
	/**
	 * #20161213#当前轮次
	 */
	private Integer currentSignTime;
	/**
	 * #20161213#有效活动课时
	 */
	private Integer abiValidHour;
	/**
	 * #20161213#0、普通活动 1、学八分活动
	 */
	private Integer abiType;
	/**
	 * #20161213#活动分值对象，包括（参政人员学分、组织人员学分、发起人学分等）
	 */
	private String abiScore;
	/**
	 * #20161213#参与人学分
	 */
	private BigDecimal joinScore;
	/**
	 * #20161213#活动达标人数
	 */
	private Integer abiUpstandardNum;
	/**
	 * 活动评分
	 */
	private Float abiGrade;
	/**
	 * 评论用户数量
	 */
	private Integer commentUserCount;
	/**
	 * #20171206#报名要求，审核报名的时候要求必填
	 */
	private String abiSignRequire;
	/**
	 * 
	 */
	private Integer creditFlag;
	/**
	 * 活动协办方
	 */
	private String abiCosponsor;
	/**
	 * 活动专题id
	 */
	private Long asiId;
	/**
	 * 活动属性 0 普通 活动 1论文征集活动
	 */
	private Integer abiProperty;
	/**
	 * 公示状态 1 待公示 2 公示中 3 公示结束 4 已锁定 
	 */
	private Integer publicStatus;
	/**
	 * 公示开始时间
	 */
	private Date publicStartTime;
	/**
	 * 公示结束时间
	 */
	private Date publicEndTime;
	/**
	 * 公示周期，单位天
	 */
	private Integer publicPeriod;
	/**
	 * 作品类型（征稿类型）0：诗歌 1：图片 2：视频 3音频
	 */
	private Integer pbiType;

	/**
	 * 设置：
	 */
	public void setAbiNum(Long abiNum) {
		this.abiNum = abiNum;
	}
	/**
	 * 获取：
	 */
	public Long getAbiNum() {
		return abiNum;
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
	 * 设置：活动名称
	 */
	public void setAbiName(String abiName) {
		this.abiName = abiName;
	}
	/**
	 * 获取：活动名称
	 */
	public String getAbiName() {
		return abiName;
	}
	/**
	 * 设置：活动标签名称
	 */
	public void setAbiCategory(String abiCategory) {
		this.abiCategory = abiCategory;
	}
	/**
	 * 获取：活动标签名称
	 */
	public String getAbiCategory() {
		return abiCategory;
	}
	/**
	 * 设置：活动主办方名称
	 */
	public void setAbiSponsor(String abiSponsor) {
		this.abiSponsor = abiSponsor;
	}
	/**
	 * 获取：活动主办方名称
	 */
	public String getAbiSponsor() {
		return abiSponsor;
	}
	/**
	 * 设置：活动承办方名称
	 */
	public void setAbiOrganizer(String abiOrganizer) {
		this.abiOrganizer = abiOrganizer;
	}
	/**
	 * 获取：活动承办方名称
	 */
	public String getAbiOrganizer() {
		return abiOrganizer;
	}
	/**
	 * 设置：父级ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：活动目的
	 */
	public void setAbiPurpose(String abiPurpose) {
		this.abiPurpose = abiPurpose;
	}
	/**
	 * 获取：活动目的
	 */
	public String getAbiPurpose() {
		return abiPurpose;
	}
	/**
	 * 设置：活动简介
	 */
	public void setAbiDescription(String abiDescription) {
		this.abiDescription = abiDescription;
	}
	/**
	 * 获取：活动简介
	 */
	public String getAbiDescription() {
		return abiDescription;
	}
	/**
	 * 设置：活动图片，最多6张图片
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 获取：活动图片，最多6张图片
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 设置：活动banner图，最多一张
	 */
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
	/**
	 * 获取：活动banner图，最多一张
	 */
	public String getBannerUrl() {
		return bannerUrl;
	}
	/**
	 * 设置：活动附件
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * 获取：活动附件
	 */
	public String getFileUrl() {
		return fileUrl;
	}
	/**
	 * 设置：开始时间
	 */
	public void setAbiStartTime(Date abiStartTime) {
		this.abiStartTime = abiStartTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getAbiStartTime() {
		return abiStartTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setAbiEndTime(Date abiEndTime) {
		this.abiEndTime = abiEndTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getAbiEndTime() {
		return abiEndTime;
	}
	/**
	 * 设置：报名截止时间
	 */
	public void setAbiRegistrationDeadline(Date abiRegistrationDeadline) {
		this.abiRegistrationDeadline = abiRegistrationDeadline;
	}
	/**
	 * 获取：报名截止时间
	 */
	public Date getAbiRegistrationDeadline() {
		return abiRegistrationDeadline;
	}
	/**
	 * 设置：允许报名人数
	 */
	public void setLimitSignNum(Integer limitSignNum) {
		this.limitSignNum = limitSignNum;
	}
	/**
	 * 获取：允许报名人数
	 */
	public Integer getLimitSignNum() {
		return limitSignNum;
	}
	/**
	 * 设置：实际报名人数
	 */
	public void setAbiSignNum(Integer abiSignNum) {
		this.abiSignNum = abiSignNum;
	}
	/**
	 * 获取：实际报名人数
	 */
	public Integer getAbiSignNum() {
		return abiSignNum;
	}
	/**
	 * 设置：已报名人数
	 */
	public void setAbiEnrollmentNum(Integer abiEnrollmentNum) {
		this.abiEnrollmentNum = abiEnrollmentNum;
	}
	/**
	 * 获取：已报名人数
	 */
	public Integer getAbiEnrollmentNum() {
		return abiEnrollmentNum;
	}
	/**
	 * 设置：签到人数
	 */
	public void setAbiCheckNum(Integer abiCheckNum) {
		this.abiCheckNum = abiCheckNum;
	}
	/**
	 * 获取：签到人数
	 */
	public Integer getAbiCheckNum() {
		return abiCheckNum;
	}
	/**
	 * 设置：活动预算最低，单位元
	 */
	public void setAbiMinBudget(Integer abiMinBudget) {
		this.abiMinBudget = abiMinBudget;
	}
	/**
	 * 获取：活动预算最低，单位元
	 */
	public Integer getAbiMinBudget() {
		return abiMinBudget;
	}
	/**
	 * 设置：活动预算最高，单位元
	 */
	public void setAbiMaxBudget(Integer abiMaxBudget) {
		this.abiMaxBudget = abiMaxBudget;
	}
	/**
	 * 获取：活动预算最高，单位元
	 */
	public Integer getAbiMaxBudget() {
		return abiMaxBudget;
	}
	/**
	 * 设置：活动地点
	 */
	public void setAbiGpsPlace(String abiGpsPlace) {
		this.abiGpsPlace = abiGpsPlace;
	}
	/**
	 * 获取：活动地点
	 */
	public String getAbiGpsPlace() {
		return abiGpsPlace;
	}
	/**
	 * 设置：活动地点定位经度
	 */
	public void setAbiGpsLng(BigDecimal abiGpsLng) {
		this.abiGpsLng = abiGpsLng;
	}
	/**
	 * 获取：活动地点定位经度
	 */
	public BigDecimal getAbiGpsLng() {
		return abiGpsLng;
	}
	/**
	 * 设置：活动地点定位纬度
	 */
	public void setAbiGpsLat(BigDecimal abiGpsLat) {
		this.abiGpsLat = abiGpsLat;
	}
	/**
	 * 获取：活动地点定位纬度
	 */
	public BigDecimal getAbiGpsLat() {
		return abiGpsLat;
	}
	/**
	 * 设置：活动微页面,预留
	 */
	public void setAbiDetailedInfo(String abiDetailedInfo) {
		this.abiDetailedInfo = abiDetailedInfo;
	}
	/**
	 * 获取：活动微页面,预留
	 */
	public String getAbiDetailedInfo() {
		return abiDetailedInfo;
	}
	/**
	 * 设置：权重，越大越靠前
	 */
	public void setAbiWeight(Integer abiWeight) {
		this.abiWeight = abiWeight;
	}
	/**
	 * 获取：权重，越大越靠前
	 */
	public Integer getAbiWeight() {
		return abiWeight;
	}
	/**
	 * 设置：权重期限，过期后将权重设置为：0
	 */
	public void setAbiWeightDate(Date abiWeightDate) {
		this.abiWeightDate = abiWeightDate;
	}
	/**
	 * 获取：权重期限，过期后将权重设置为：0
	 */
	public Date getAbiWeightDate() {
		return abiWeightDate;
	}
	/**
	 * 设置：是否报销，0为不需报销（默认），1为需要报销
	 */
	public void setHaveExpenses(Integer haveExpenses) {
		this.haveExpenses = haveExpenses;
	}
	/**
	 * 获取：是否报销，0为不需报销（默认），1为需要报销
	 */
	public Integer getHaveExpenses() {
		return haveExpenses;
	}
	/**
	 * 设置：是否允许评论，0为允许,公开评论（默认），1为允许,参与活动人员评论，2为不允许
	 */
	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	/**
	 * 获取：是否允许评论，0为允许,公开评论（默认），1为允许,参与活动人员评论，2为不允许
	 */
	public Integer getAllowComment() {
		return allowComment;
	}
	/**
	 * 设置：评论是否审核，0为不审核（默认），1位审核
	 */
	public void setCommentAudit(Integer commentAudit) {
		this.commentAudit = commentAudit;
	}
	/**
	 * 获取：评论是否审核，0为不审核（默认），1位审核
	 */
	public Integer getCommentAudit() {
		return commentAudit;
	}
	/**
	 * 设置：报名方式，0为公开报名（默认），1为审核报名  ,2为报名状态已满
	 */
	public void setAbiSignOpen(Integer abiSignOpen) {
		this.abiSignOpen = abiSignOpen;
	}
	/**
	 * 获取：报名方式，0为公开报名（默认），1为审核报名  ,2为报名状态已满
	 */
	public Integer getAbiSignOpen() {
		return abiSignOpen;
	}
	/**
	 * 设置：审核状态，0为待审核（默认），1为未通过，2为已通过
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态，0为待审核（默认），1为未通过，2为已通过
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
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
	 * 设置：活动状态，0为审核中（默认），1为待开始，2为进行中，3为结束，4为完成，5为审核不通过
	 */
	public void setAbiStatus(Integer abiStatus) {
		this.abiStatus = abiStatus;
	}
	/**
	 * 获取：活动状态，0为审核中（默认），1为待开始，2为进行中，3为结束，4为完成，5为审核不通过
	 */
	public Integer getAbiStatus() {
		return abiStatus;
	}
	/**
	 * 设置：
	 */
	public void setSriId(Long sriId) {
		this.sriId = sriId;
	}
	/**
	 * 获取：
	 */
	public Long getSriId() {
		return sriId;
	}
	/**
	 * 设置：排序字段
	 */
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	/**
	 * 获取：排序字段
	 */
	public Integer getSortno() {
		return sortno;
	}
	/**
	 * 设置：活动负责人
	 */
	public void setAbiChargeName(String abiChargeName) {
		this.abiChargeName = abiChargeName;
	}
	/**
	 * 获取：活动负责人
	 */
	public String getAbiChargeName() {
		return abiChargeName;
	}
	/**
	 * 设置：负责人学号
	 */
	public void setAbiChargeNo(String abiChargeNo) {
		this.abiChargeNo = abiChargeNo;
	}
	/**
	 * 获取：负责人学号
	 */
	public String getAbiChargeNo() {
		return abiChargeNo;
	}
	/**
	 * 设置：负责人联系方式
	 */
	public void setAbiChargeMobile(String abiChargeMobile) {
		this.abiChargeMobile = abiChargeMobile;
	}
	/**
	 * 获取：负责人联系方式
	 */
	public String getAbiChargeMobile() {
		return abiChargeMobile;
	}
	/**
	 * 设置：活动负责人
	 */
	public void setAbiSupervisorName(String abiSupervisorName) {
		this.abiSupervisorName = abiSupervisorName;
	}
	/**
	 * 获取：活动负责人
	 */
	public String getAbiSupervisorName() {
		return abiSupervisorName;
	}
	/**
	 * 设置：监管人联系方式
	 */
	public void setAbiSupervisorMobile(String abiSupervisorMobile) {
		this.abiSupervisorMobile = abiSupervisorMobile;
	}
	/**
	 * 获取：监管人联系方式
	 */
	public String getAbiSupervisorMobile() {
		return abiSupervisorMobile;
	}
	/**
	 * 设置：逻辑删除标志位，0为正常，1为删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：逻辑删除标志位，0为正常，1为删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：创建时间.WEB服务器时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间.WEB服务器时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：
	 */
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	/**
	 * 获取：
	 */
	public Long getCreateId() {
		return createId;
	}
	/**
	 * 设置：创建人名称
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * 获取：创建人名称
	 */
	public String getCreateName() {
		return createName;
	}
	/**
	 * 设置：最近修改时间.WEB服务器时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：最近修改时间.WEB服务器时间
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
	 * 设置：最近修改人名称
	 */
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	/**
	 * 获取：最近修改人名称
	 */
	public String getUpdateName() {
		return updateName;
	}
	/**
	 * 设置：#20160926#1是学校，2,3原来是分校、院（现此两项停用），4、院系 （下面有院系、4以后的，99以前的）， 5、支部，6、社团，7、学生会，8、研究生会，。。。。（预留分类）。。。99、机关单位
	 */
	public void setAbiRangeType(Integer abiRangeType) {
		this.abiRangeType = abiRangeType;
	}
	/**
	 * 获取：#20160926#1是学校，2,3原来是分校、院（现此两项停用），4、院系 （下面有院系、4以后的，99以前的）， 5、支部，6、社团，7、学生会，8、研究生会，。。。。（预留分类）。。。99、机关单位
	 */
	public Integer getAbiRangeType() {
		return abiRangeType;
	}
	/**
	 * 设置：
	 */
	public void setAbiRangeId(Long abiRangeId) {
		this.abiRangeId = abiRangeId;
	}
	/**
	 * 获取：
	 */
	public Long getAbiRangeId() {
		return abiRangeId;
	}
	/**
	 * 设置：#20160926#1是学校，2,3原来是分校、院（现此两项停用），4、院系 （下面有院系、4以后的，99以前的）， 5、支部，6、社团，7、学生会，8、研究生会，。。。。（预留分类）。。。99、机关单位
	 */
	public void setAbiPublishType(Integer abiPublishType) {
		this.abiPublishType = abiPublishType;
	}
	/**
	 * 获取：#20160926#1是学校，2,3原来是分校、院（现此两项停用），4、院系 （下面有院系、4以后的，99以前的）， 5、支部，6、社团，7、学生会，8、研究生会，。。。。（预留分类）。。。99、机关单位
	 */
	public Integer getAbiPublishType() {
		return abiPublishType;
	}
	/**
	 * 设置：
	 */
	public void setAbiPublishId(Long abiPublishId) {
		this.abiPublishId = abiPublishId;
	}
	/**
	 * 获取：
	 */
	public Long getAbiPublishId() {
		return abiPublishId;
	}
	/**
	 * 设置：#20160926#报名开始时间
	 */
	public void setSignStartTime(Date signStartTime) {
		this.signStartTime = signStartTime;
	}
	/**
	 * 获取：#20160926#报名开始时间
	 */
	public Date getSignStartTime() {
		return signStartTime;
	}
	/**
	 * 设置：#20160926#0不可以1可以
	 */
	public void setIsCanCancel(Integer isCanCancel) {
		this.isCanCancel = isCanCancel;
	}
	/**
	 * 获取：#20160926#0不可以1可以
	 */
	public Integer getIsCanCancel() {
		return isCanCancel;
	}
	/**
	 * 设置：#20160926#0、不需要签到1、普通签到2、扫描签到3、管理员扫描签到4验票签到
	 */
	public void setSigninType(Integer signinType) {
		this.signinType = signinType;
	}
	/**
	 * 获取：#20160926#0、不需要签到1、普通签到2、扫描签到3、管理员扫描签到4验票签到
	 */
	public Integer getSigninType() {
		return signinType;
	}
	/**
	 * 设置：#20160926#签到开始时间
	 */
	public void setSigninStartTime(Date signinStartTime) {
		this.signinStartTime = signinStartTime;
	}
	/**
	 * 获取：#20160926#签到开始时间
	 */
	public Date getSigninStartTime() {
		return signinStartTime;
	}
	/**
	 * 设置：#20160926#签到截止时间
	 */
	public void setSigninEndTime(Date signinEndTime) {
		this.signinEndTime = signinEndTime;
	}
	/**
	 * 获取：#20160926#签到截止时间
	 */
	public Date getSigninEndTime() {
		return signinEndTime;
	}
	/**
	 * 设置：#20160926#0、不需要签退1、普通签退2、扫描签退3、管理员扫描签退4验票签退
	 */
	public void setSignoutType(Integer signoutType) {
		this.signoutType = signoutType;
	}
	/**
	 * 获取：#20160926#0、不需要签退1、普通签退2、扫描签退3、管理员扫描签退4验票签退
	 */
	public Integer getSignoutType() {
		return signoutType;
	}
	/**
	 * 设置：#20160926#签退开始时间
	 */
	public void setSignoutStartTime(Date signoutStartTime) {
		this.signoutStartTime = signoutStartTime;
	}
	/**
	 * 获取：#20160926#签退开始时间
	 */
	public Date getSignoutStartTime() {
		return signoutStartTime;
	}
	/**
	 * 设置：#20160926#签退截止时间
	 */
	public void setSignoutEndTime(Date signoutEndTime) {
		this.signoutEndTime = signoutEndTime;
	}
	/**
	 * 获取：#20160926#签退截止时间
	 */
	public Date getSignoutEndTime() {
		return signoutEndTime;
	}
	/**
	 * 设置：#20160926#提醒时间
	 */
	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}
	/**
	 * 获取：#20160926#提醒时间
	 */
	public Date getRemindTime() {
		return remindTime;
	}
	/**
	 * 设置：#20160926#提醒时间次数，0为不提醒
	 */
	public void setRemindTimes(Integer remindTimes) {
		this.remindTimes = remindTimes;
	}
	/**
	 * 获取：#20160926#提醒时间次数，0为不提醒
	 */
	public Integer getRemindTimes() {
		return remindTimes;
	}
	/**
	 * 设置：#20160926#提醒内容
	 */
	public void setRemindContent(String remindContent) {
		this.remindContent = remindContent;
	}
	/**
	 * 获取：#20160926#提醒内容
	 */
	public String getRemindContent() {
		return remindContent;
	}
	/**
	 * 设置：#20160926#审核流次数，一次完整的活动审核流为一次
	 */
	public void setAuditTimes(Integer auditTimes) {
		this.auditTimes = auditTimes;
	}
	/**
	 * 获取：#20160926#审核流次数，一次完整的活动审核流为一次
	 */
	public Integer getAuditTimes() {
		return auditTimes;
	}
	/**
	 * 设置：#20161027#签退人数
	 */
	public void setAbiSignoutNum(Integer abiSignoutNum) {
		this.abiSignoutNum = abiSignoutNum;
	}
	/**
	 * 获取：#20161027#签退人数
	 */
	public Integer getAbiSignoutNum() {
		return abiSignoutNum;
	}
	/**
	 * 设置：#20161213#0、允许 1、不允许
	 */
	public void setIsArtificialMark(Integer isArtificialMark) {
		this.isArtificialMark = isArtificialMark;
	}
	/**
	 * 获取：#20161213#0、允许 1、不允许
	 */
	public Integer getIsArtificialMark() {
		return isArtificialMark;
	}
	/**
	 * 设置：#20161213#发起最大签到轮次
	 */
	public void setMaxSignTimes(Integer maxSignTimes) {
		this.maxSignTimes = maxSignTimes;
	}
	/**
	 * 获取：#20161213#发起最大签到轮次
	 */
	public Integer getMaxSignTimes() {
		return maxSignTimes;
	}
	/**
	 * 设置：#20161213#达标签到轮次
	 */
	public void setMustSignTimes(Integer mustSignTimes) {
		this.mustSignTimes = mustSignTimes;
	}
	/**
	 * 获取：#20161213#达标签到轮次
	 */
	public Integer getMustSignTimes() {
		return mustSignTimes;
	}
	/**
	 * 设置：#20161213#当前轮次
	 */
	public void setCurrentSignTime(Integer currentSignTime) {
		this.currentSignTime = currentSignTime;
	}
	/**
	 * 获取：#20161213#当前轮次
	 */
	public Integer getCurrentSignTime() {
		return currentSignTime;
	}
	/**
	 * 设置：#20161213#有效活动课时
	 */
	public void setAbiValidHour(Integer abiValidHour) {
		this.abiValidHour = abiValidHour;
	}
	/**
	 * 获取：#20161213#有效活动课时
	 */
	public Integer getAbiValidHour() {
		return abiValidHour;
	}
	/**
	 * 设置：#20161213#0、普通活动 1、学八分活动
	 */
	public void setAbiType(Integer abiType) {
		this.abiType = abiType;
	}
	/**
	 * 获取：#20161213#0、普通活动 1、学八分活动
	 */
	public Integer getAbiType() {
		return abiType;
	}
	/**
	 * 设置：#20161213#活动分值对象，包括（参政人员学分、组织人员学分、发起人学分等）
	 */
	public void setAbiScore(String abiScore) {
		this.abiScore = abiScore;
	}
	/**
	 * 获取：#20161213#活动分值对象，包括（参政人员学分、组织人员学分、发起人学分等）
	 */
	public String getAbiScore() {
		return abiScore;
	}
	/**
	 * 设置：#20161213#参与人学分
	 */
	public void setJoinScore(BigDecimal joinScore) {
		this.joinScore = joinScore;
	}
	/**
	 * 获取：#20161213#参与人学分
	 */
	public BigDecimal getJoinScore() {
		return joinScore;
	}
	/**
	 * 设置：#20161213#活动达标人数
	 */
	public void setAbiUpstandardNum(Integer abiUpstandardNum) {
		this.abiUpstandardNum = abiUpstandardNum;
	}
	/**
	 * 获取：#20161213#活动达标人数
	 */
	public Integer getAbiUpstandardNum() {
		return abiUpstandardNum;
	}
	/**
	 * 设置：活动评分
	 */
	public void setAbiGrade(Float abiGrade) {
		this.abiGrade = abiGrade;
	}
	/**
	 * 获取：活动评分
	 */
	public Float getAbiGrade() {
		return abiGrade;
	}
	/**
	 * 设置：评论用户数量
	 */
	public void setCommentUserCount(Integer commentUserCount) {
		this.commentUserCount = commentUserCount;
	}
	/**
	 * 获取：评论用户数量
	 */
	public Integer getCommentUserCount() {
		return commentUserCount;
	}
	/**
	 * 设置：#20171206#报名要求，审核报名的时候要求必填
	 */
	public void setAbiSignRequire(String abiSignRequire) {
		this.abiSignRequire = abiSignRequire;
	}
	/**
	 * 获取：#20171206#报名要求，审核报名的时候要求必填
	 */
	public String getAbiSignRequire() {
		return abiSignRequire;
	}
	/**
	 * 设置：
	 */
	public void setCreditFlag(Integer creditFlag) {
		this.creditFlag = creditFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getCreditFlag() {
		return creditFlag;
	}
	/**
	 * 设置：活动协办方
	 */
	public void setAbiCosponsor(String abiCosponsor) {
		this.abiCosponsor = abiCosponsor;
	}
	/**
	 * 获取：活动协办方
	 */
	public String getAbiCosponsor() {
		return abiCosponsor;
	}
	/**
	 * 设置：活动专题id
	 */
	public void setAsiId(Long asiId) {
		this.asiId = asiId;
	}
	/**
	 * 获取：活动专题id
	 */
	public Long getAsiId() {
		return asiId;
	}
	/**
	 * 设置：活动属性 0 普通 活动 1论文征集活动
	 */
	public void setAbiProperty(Integer abiProperty) {
		this.abiProperty = abiProperty;
	}
	/**
	 * 获取：活动属性 0 普通 活动 1论文征集活动
	 */
	public Integer getAbiProperty() {
		return abiProperty;
	}
	/**
	 * 设置：公示状态 1 待公示 2 公示中 3 公示结束 4 已锁定 
	 */
	public void setPublicStatus(Integer publicStatus) {
		this.publicStatus = publicStatus;
	}
	/**
	 * 获取：公示状态 1 待公示 2 公示中 3 公示结束 4 已锁定 
	 */
	public Integer getPublicStatus() {
		return publicStatus;
	}
	/**
	 * 设置：公示开始时间
	 */
	public void setPublicStartTime(Date publicStartTime) {
		this.publicStartTime = publicStartTime;
	}
	/**
	 * 获取：公示开始时间
	 */
	public Date getPublicStartTime() {
		return publicStartTime;
	}
	/**
	 * 设置：公示结束时间
	 */
	public void setPublicEndTime(Date publicEndTime) {
		this.publicEndTime = publicEndTime;
	}
	/**
	 * 获取：公示结束时间
	 */
	public Date getPublicEndTime() {
		return publicEndTime;
	}
	/**
	 * 设置：公示周期，单位天
	 */
	public void setPublicPeriod(Integer publicPeriod) {
		this.publicPeriod = publicPeriod;
	}
	/**
	 * 获取：公示周期，单位天
	 */
	public Integer getPublicPeriod() {
		return publicPeriod;
	}
	/**
	 * 设置：作品类型（征稿类型）0：诗歌 1：图片 2：视频 3音频
	 */
	public void setPbiType(Integer pbiType) {
		this.pbiType = pbiType;
	}
	/**
	 * 获取：作品类型（征稿类型）0：诗歌 1：图片 2：视频 3音频
	 */
	public Integer getPbiType() {
		return pbiType;
	}
}
