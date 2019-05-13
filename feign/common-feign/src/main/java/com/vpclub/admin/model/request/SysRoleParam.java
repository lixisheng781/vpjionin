package com.vpclub.admin.model.request;

import com.vpclub.result.BasePageParam;
import lombok.Data;

import java.util.List;

/**
 * Created by lxs.
 */
@Data
public class SysRoleParam extends BasePageParam {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 菜单ID集合
     */
    private List<Long> menuIdList;

    /**
     * 创建时间
     */
    private Long createdTime;

    /**
     * 角色ID集合
     */
    private List<Long> roleIds;
}
