package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构基础信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:10
 */
@TableName("sys_office_info")
public class SysOfficeInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long ubiNum;
	/**
	 * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	private String ubiCode;
	/**
	 * 机构编码，用户自定义，一般较短，全表或一定范围唯一
	 */
	private String ubiNo;
	/**
	 * 机构全称
	 */
	private String fullName;
	/**
	 * 机构简称,快捷搜索字符串
	 */
	private String shortName;
	/**
	 * 机构英文名称
	 */
	private String englishName;
	/**
	 * 机构类型（0：公司，1：学校；2：分校；3：学院，4：院系）
	 */
	private Integer ubiType;
	/**
	 * 
	 */
	private Long pid;
	/**
	 * 树型路径
	 */
	private String path;
	/**
	 * 机构等级（1：一级；2：二级；3：三级；4：四级）
	 */
	private Integer ubiGrade;
	/**
	 * 
	 */
	private Long saiId;
	/**
	 * 机构详细地址
	 */
	private String ubiAddress;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 机构负责人
	 */
	private String ubiMaster;
	/**
	 * 主负责人
	 */
	private String primaryPerson;
	/**
	 * 副负责人
	 */
	private String deputyPerson;
	/**
	 * 机构电话
	 */
	private String ubiTelephone;
	/**
	 * 机构传真
	 */
	private String ubiFax;
	/**
	 * 机构EMAIL
	 */
	private String ubiMail;
	/**
	 * 机构网址
	 */
	private String ubiUrl;
	/**
	 * 附件文件
	 */
	private String filesImgUrl;
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
	 * 数据状态，默认是0，表示正常
	 */
	private Integer isState;
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
	 * 学年应修学分#20161213#
	 */
	private Integer ubiCredit;
	/**
	 * 是否是特优班
	 */
	private Integer isGiftedClass;
	/**
	 * #20171012#应修活动单位名称
	 */
	private String ubiCreditname;
	/**
	 * 
	 */
	private Integer ubiCalendarFlag;
	/**
	 * 
	 */
	private Date calendarStartTime;
	/**
	 * 
	 */
	private Date calendarEndTime;
	/**
	 * 
	 */
	private Integer ubiCreditFlag;
	/**
	 * 
	 */
	private Integer creditTimes;
	/**
	 * 
	 */
	private Date creditCycleTime;
	/**
	 * 组织机构介绍，大文本表id#20180510#
	 */
	private Long presentationId;
	/**
	 * 组织机构章程，大文本表id#20180510#
	 */
	private Long constitutionId;

	/**
	 * 设置：
	 */
	public void setUbiNum(Long ubiNum) {
		this.ubiNum = ubiNum;
	}
	/**
	 * 获取：
	 */
	public Long getUbiNum() {
		return ubiNum;
	}
	/**
	 * 设置：预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	public void setUbiCode(String ubiCode) {
		this.ubiCode = ubiCode;
	}
	/**
	 * 获取：预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
	public String getUbiCode() {
		return ubiCode;
	}
	/**
	 * 设置：机构编码，用户自定义，一般较短，全表或一定范围唯一
	 */
	public void setUbiNo(String ubiNo) {
		this.ubiNo = ubiNo;
	}
	/**
	 * 获取：机构编码，用户自定义，一般较短，全表或一定范围唯一
	 */
	public String getUbiNo() {
		return ubiNo;
	}
	/**
	 * 设置：机构全称
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * 获取：机构全称
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * 设置：机构简称,快捷搜索字符串
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * 获取：机构简称,快捷搜索字符串
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * 设置：机构英文名称
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * 获取：机构英文名称
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * 设置：机构类型（0：公司，1：学校；2：分校；3：学院，4：院系）
	 */
	public void setUbiType(Integer ubiType) {
		this.ubiType = ubiType;
	}
	/**
	 * 获取：机构类型（0：公司，1：学校；2：分校；3：学院，4：院系）
	 */
	public Integer getUbiType() {
		return ubiType;
	}
	/**
	 * 设置：
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：树型路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：树型路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：机构等级（1：一级；2：二级；3：三级；4：四级）
	 */
	public void setUbiGrade(Integer ubiGrade) {
		this.ubiGrade = ubiGrade;
	}
	/**
	 * 获取：机构等级（1：一级；2：二级；3：三级；4：四级）
	 */
	public Integer getUbiGrade() {
		return ubiGrade;
	}
	/**
	 * 设置：
	 */
	public void setSaiId(Long saiId) {
		this.saiId = saiId;
	}
	/**
	 * 获取：
	 */
	public Long getSaiId() {
		return saiId;
	}
	/**
	 * 设置：机构详细地址
	 */
	public void setUbiAddress(String ubiAddress) {
		this.ubiAddress = ubiAddress;
	}
	/**
	 * 获取：机构详细地址
	 */
	public String getUbiAddress() {
		return ubiAddress;
	}
	/**
	 * 设置：邮编
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * 设置：机构负责人
	 */
	public void setUbiMaster(String ubiMaster) {
		this.ubiMaster = ubiMaster;
	}
	/**
	 * 获取：机构负责人
	 */
	public String getUbiMaster() {
		return ubiMaster;
	}
	/**
	 * 设置：主负责人
	 */
	public void setPrimaryPerson(String primaryPerson) {
		this.primaryPerson = primaryPerson;
	}
	/**
	 * 获取：主负责人
	 */
	public String getPrimaryPerson() {
		return primaryPerson;
	}
	/**
	 * 设置：副负责人
	 */
	public void setDeputyPerson(String deputyPerson) {
		this.deputyPerson = deputyPerson;
	}
	/**
	 * 获取：副负责人
	 */
	public String getDeputyPerson() {
		return deputyPerson;
	}
	/**
	 * 设置：机构电话
	 */
	public void setUbiTelephone(String ubiTelephone) {
		this.ubiTelephone = ubiTelephone;
	}
	/**
	 * 获取：机构电话
	 */
	public String getUbiTelephone() {
		return ubiTelephone;
	}
	/**
	 * 设置：机构传真
	 */
	public void setUbiFax(String ubiFax) {
		this.ubiFax = ubiFax;
	}
	/**
	 * 获取：机构传真
	 */
	public String getUbiFax() {
		return ubiFax;
	}
	/**
	 * 设置：机构EMAIL
	 */
	public void setUbiMail(String ubiMail) {
		this.ubiMail = ubiMail;
	}
	/**
	 * 获取：机构EMAIL
	 */
	public String getUbiMail() {
		return ubiMail;
	}
	/**
	 * 设置：机构网址
	 */
	public void setUbiUrl(String ubiUrl) {
		this.ubiUrl = ubiUrl;
	}
	/**
	 * 获取：机构网址
	 */
	public String getUbiUrl() {
		return ubiUrl;
	}
	/**
	 * 设置：附件文件
	 */
	public void setFilesImgUrl(String filesImgUrl) {
		this.filesImgUrl = filesImgUrl;
	}
	/**
	 * 获取：附件文件
	 */
	public String getFilesImgUrl() {
		return filesImgUrl;
	}
	/**
	 * 设置：是否显示,1为显示(默认), 0为不显示
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否显示,1为显示(默认), 0为不显示
	 */
	public Integer getIsShow() {
		return isShow;
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
	 * 设置：数据状态，默认是0，表示正常
	 */
	public void setIsState(Integer isState) {
		this.isState = isState;
	}
	/**
	 * 获取：数据状态，默认是0，表示正常
	 */
	public Integer getIsState() {
		return isState;
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
	 * 设置：学年应修学分#20161213#
	 */
	public void setUbiCredit(Integer ubiCredit) {
		this.ubiCredit = ubiCredit;
	}
	/**
	 * 获取：学年应修学分#20161213#
	 */
	public Integer getUbiCredit() {
		return ubiCredit;
	}
	/**
	 * 设置：是否是特优班
	 */
	public void setIsGiftedClass(Integer isGiftedClass) {
		this.isGiftedClass = isGiftedClass;
	}
	/**
	 * 获取：是否是特优班
	 */
	public Integer getIsGiftedClass() {
		return isGiftedClass;
	}
	/**
	 * 设置：#20171012#应修活动单位名称
	 */
	public void setUbiCreditname(String ubiCreditname) {
		this.ubiCreditname = ubiCreditname;
	}
	/**
	 * 获取：#20171012#应修活动单位名称
	 */
	public String getUbiCreditname() {
		return ubiCreditname;
	}
	/**
	 * 设置：
	 */
	public void setUbiCalendarFlag(Integer ubiCalendarFlag) {
		this.ubiCalendarFlag = ubiCalendarFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getUbiCalendarFlag() {
		return ubiCalendarFlag;
	}
	/**
	 * 设置：
	 */
	public void setCalendarStartTime(Date calendarStartTime) {
		this.calendarStartTime = calendarStartTime;
	}
	/**
	 * 获取：
	 */
	public Date getCalendarStartTime() {
		return calendarStartTime;
	}
	/**
	 * 设置：
	 */
	public void setCalendarEndTime(Date calendarEndTime) {
		this.calendarEndTime = calendarEndTime;
	}
	/**
	 * 获取：
	 */
	public Date getCalendarEndTime() {
		return calendarEndTime;
	}
	/**
	 * 设置：
	 */
	public void setUbiCreditFlag(Integer ubiCreditFlag) {
		this.ubiCreditFlag = ubiCreditFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getUbiCreditFlag() {
		return ubiCreditFlag;
	}
	/**
	 * 设置：
	 */
	public void setCreditTimes(Integer creditTimes) {
		this.creditTimes = creditTimes;
	}
	/**
	 * 获取：
	 */
	public Integer getCreditTimes() {
		return creditTimes;
	}
	/**
	 * 设置：
	 */
	public void setCreditCycleTime(Date creditCycleTime) {
		this.creditCycleTime = creditCycleTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreditCycleTime() {
		return creditCycleTime;
	}
	/**
	 * 设置：组织机构介绍，大文本表id#20180510#
	 */
	public void setPresentationId(Long presentationId) {
		this.presentationId = presentationId;
	}
	/**
	 * 获取：组织机构介绍，大文本表id#20180510#
	 */
	public Long getPresentationId() {
		return presentationId;
	}
	/**
	 * 设置：组织机构章程，大文本表id#20180510#
	 */
	public void setConstitutionId(Long constitutionId) {
		this.constitutionId = constitutionId;
	}
	/**
	 * 获取：组织机构章程，大文本表id#20180510#
	 */
	public Long getConstitutionId() {
		return constitutionId;
	}
}
