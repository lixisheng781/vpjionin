package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 机构用户信息表
 * </p>
 *
 * @author jobob
 * @since 2019-02-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_info")
public class SysUserInfoEntity extends Model<SysUserInfoEntity> {

    private static final long serialVersionUID = 1L;

    @TableId("uui_num")
    private Long userId;

    /**
     * 预留业务对接字符编码，全表唯一,主要对接第三方系统数据预留
     */
    @TableField("uui_code")
    private String uuiCode;

    /**
     * 学校id
     */
    @TableField("ubi_id")
    private Long schoolId;

    /**
     * 机构id
     */
    @TableField("uoi_id")
    private Long organizationId;

    /**
     * 年级
     */
    @TableField("uui_grade")
    private String uuiGrade;

    /**
     * 用户登录名（6-20  个字符）
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 用户登录密码，SHA1非对称加密
     */
    @TableField("login_pwd")
    private String password;

    /**
     * 学号
     */
    @TableField("grade_code")
    private String gradeCode;

    /**
     * 姓名
     */
    @TableField("uui_name")
    private String uuiName;

    /**
     * 邮箱地址
     */
    @TableField("uui_mail")
    private String uuiMail;

    /**
     * 电话
     */
    @TableField("uui_phone")
    private String uuiPhone;

    /**
     * 手机号
     */
    @TableField("uui_mobile")
    private String uuiMobile;

    /**
     * 用户类型
     */
    @TableField("uui_type")
    private Integer uuiType;

    /**
     * 图标
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 备选图标，不能超过4个
     */
    @TableField("user_file_img_url")
    private String userFileImgUrl;

    /**
     * 性别（0表示女，1表示男）
     */
    @TableField("uui_sex")
    private Integer uuiSex;

    /**
     * 职员的身份证号码
     */
    @TableField("uui_idcard")
    private String uuiIdcard;

    /**
     * 签名
     */
    @TableField("uui_signature")
    private String uuiSignature;

    /**
     * 用户最后登录时间
     */
    @TableField("login_time")
    private Date loginTime;

    /**
     * 用户登录时的IP
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 最近定位时间
     */
    @TableField("gps_time")
    private Date gpsTime;

    /**
     * 最近定位经度
     */
    @TableField("gps_lng")
    private BigDecimal gpsLng;

    /**
     * 最近定位纬度
     */
    @TableField("gps_lat")
    private BigDecimal gpsLat;

    /**
     * 最近定位位置描述
     */
    @TableField("gps_place")
    private String gpsPlace;

    /**
     * 是否可登录,1为可登录(默认), 0为不可以
     */
    @TableField("is_login_flag")
    private Integer isLoginFlag;

    @TableField("sri_id")
    private Long sysRemarkId;

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

    @TableField("update_id")
    private Long updateId;

    /**
     * 最近修改人名称
     */
    @TableField("update_name")
    private String updateName;

    /**
     * 籍贯#20171121#
     */
    @TableField("uui_native_place")
    private String uuiNativePlace;

    /**
     * 民族#20170628#
     */
    @TableField("uui_nation")
    private String uuiNation;

    /**
     * #20170824完善资料时间
     */
    @TableField("full_info_date")
    private Date fullInfoDate;

    /**
     * #20170824#完善资料标记
     */
    @TableField("full_info_flag")
    private Integer fullInfoFlag;

    /**
     * 学历类型，1为本科，2为硕士，3为博士
     */
    @TableField("uui_education")
    private Integer uuiEducation;

    /**
     * 1、群众2、共青团员3、中共党员4、中共预备党员5、民革党员6、民盟盟员7、民建会员8、民进会员9、农工党党员10、致公党党员11、九三学社社员12、台盟盟员13、无党派人士
     */
    @TableField("political_status")
    private Integer politicalStatus;

    /**
     * 学科类别
     */
    @TableField("uui_edu_type")
    private String uuiEduType;

    /**
     * 学校专业id
     */
    @TableField("uui_zy_id")
    private Long uuiZyId;

    /**
     * 学校专业名称
     */
    @TableField("uui_zy_mc")
    private String uuiZyMc;

    /**
     * 角色名称
     */
    @TableField(exist = false)
    private String roleName;

    /**
     * 角色ID列表
     */
    @TableField(exist = false)
    private List<Long> roleIdList;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
