package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 行政区域信息表
 * 
 * @author liwenlong
 * @email liwenlong@gmail.com
 * @date 2019-03-03 17:42:09
 */
@Data
@TableName("sys_area_info")
public class SysAreaInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    @TableId(value = "sai_num")
	private Long sysAreaInfoId;
	/**
	 * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
	 */
    @TableField("sai_code")
	private String saiCode;
	/**
	 * 区域编码,全表唯一
	 */
	@TableField("sai_no")
	private String saiNo;
	/**
	 * 名称
	 */
    @TableField("sai_name")
	private String saiName;
	/**
	 * 完整行政区域名称
	 */
    @TableField("sai_pathname")
	private String saiPathname;
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
	 * 邮政编码
	 */
    @TableField("zip_code")
	private String zipCode;
	/**
	 * 行政区域级别，0为国家地区，1为省，2为市，3为县，4为乡区
	 */
    @TableField("sai_type")
	private Integer saiType;
	/**
	 * 区域定位经度
	 */
    @TableField("lng")
	private BigDecimal lng;
	/**
	 * 区域定位纬度
	 */
    @TableField("lat")
	private BigDecimal lat;
	/**
	 * 左下经度，用于快速计算。
	 */
    @TableField("lb_lng")
	private BigDecimal lbLng;
	/**
	 * 左下纬度
	 */
    @TableField("lb_lat")
	private BigDecimal lbLat;
	/**
	 * 右上经度
	 */
    @TableField("rt_lng")
	private BigDecimal rtLng;
	/**
	 * 右上纬度
	 */
    @TableField("rt_lat")
	private BigDecimal rtLat;
	/**
	 * 备注字段，关联备注表ID
	 */
    @TableField("sri_id")
	private Integer sriId;
	/**
	 * 排序字段
	 */
	@TableField("sortno")
	private Integer sortno;
	/**
	 * 是否显示,1为显示(默认), 0为不显示
	 */
    @TableField("is_show")
	private Integer isShow;
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

}
