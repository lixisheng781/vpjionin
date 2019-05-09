/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vpclub.admin.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单管理
 * @author lxs
 */
@Data
@TableName("menu_base_info")
public class SysMenuEntity extends com.baomidou.mybatisplus.activerecord.Model<SysMenuEntity>  {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "mbi_num")
    private Long menuId;

  /**
     * 类型(0:层级菜单,1:功能按钮)
     */
    @TableField("mbi_type")
    private Integer type;
    /**
     * 父功能ID,"0"表示最终父功能
     */
    @TableField("pid")
    private Integer parentId;
    /**
     * 菜单名称
     */
    @TableField("mbi_name")
    private String name;
    /**
     * 功能唯一标识,命名规则为父节点Code+本节点含义code
     */
    @TableField("mbi_code")
    private String code;
    /**
     * 层级
     */
    @TableField("channel_type")
    private Integer level;
    /**
     * 功能的URL
     */
    @TableField("mbi_url")
    private String functionUrl;
    /**
     * 前端页面路由
     */
    @TableField("mbi_target")
    private String routeUrl;
    /**
     * 图标
     */
    @TableField("mbi_ico")
    private String icon;
    /**
     * 是否显示(0:不显示,1:显示)
     */
    @TableField("is_show")
    private Integer isShow;
    /**
     * 是否鉴权(0:不鉴权,1:鉴权)
     */
    @TableField("del_flag")
    private Integer isAuth;
    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    private java.util.Date gmtModified;
    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private java.util.Date gmtCreate;

    /**
     * ztree属性
     */
    @TableField(exist = false)
    private Boolean open;

    @TableField(exist = false)
    private List<?> list;


    @Override
    protected java.io.Serializable pkVal() {
        return this.menuId;
    }
}
