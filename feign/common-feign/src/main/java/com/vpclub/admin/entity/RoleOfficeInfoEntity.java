package com.vpclub.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@lombok.Data
@TableName("role_office_info")
public class RoleOfficeInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "rei_seq")
    private Long reieq;
    /**S
     *
     */
    @TableId(value = "rbi_id")
    private Long roleId;
    /**
     *
     */
    private Long ubiId;
}