package com.vpclub.admin.model.request;

import com.vpclub.result.BasePageParam;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@Data
public class SysUserParam extends BasePageParam {

    /**
     * 用户Id
     */
    private Long userId;


    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * id集合
     */
    private List<Long> idList;
}
