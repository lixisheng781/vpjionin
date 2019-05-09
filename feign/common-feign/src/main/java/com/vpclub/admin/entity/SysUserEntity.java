package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@Data
@TableName("sys_user_info")
public class SysUserEntity extends com.baomidou.mybatisplus.activerecord.Model<SysUserEntity>  {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "uui_num")
    private Long userId;

    /**
     * 预留业务对接字符编码
     */
    private String uui_code;
    /**
     * 编码
     */
    private Long ubi_id;
    /**
     * 编码
     */
    private Long uoi_id;
    /**
     * 年级
     */
    private String uui_grade;


    /**
     * 用户名
     */
    @TableId(value = "login_name")
    private String username;

    /**
     * 密码
     */
    @TableId(value = "login_pwd")
    private String password;

    /**
     * 学号
     */
    private String grade_code;

    /**
     * 姓名
     */
    private String uui_name;
    /**
     * 邮箱地址
     */
    private String uui_mail;


    /**
     * 手机号
     */
    private String uui_phone;

    /**
     * 用户类型
     */
    private Integer uui_type;


    /**
     * 图标
     */
    private String img_url;

    /**
     * 备选图标，不能超过4个
     */
    private String user_file_img_url;

    /**
     * 性别（0表示女，1表示男）
     */
    private Integer uui_sex;

    /**
     * 职员的身份证号码
     */
    private String uui_idcard;

    /**
     * 签名
     */
    private String uui_signature;


    @Override
    protected java.io.Serializable pkVal() {
        return this.userId;
    }

}
